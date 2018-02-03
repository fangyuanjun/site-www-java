package me.fyj.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.baidu.inf.iis.bcs.BaiduBCS;
import com.baidu.inf.iis.bcs.auth.BCSCredentials;
import com.baidu.inf.iis.bcs.model.ObjectMetadata;
import com.baidu.inf.iis.bcs.model.X_BS_ACL;
import com.baidu.inf.iis.bcs.request.PutObjectRequest;
import com.kecq.common.GetString;
import com.kecq.common.StringEx;
import com.kecq.data.DbFactory;
import com.kecq.data.IDbHelper;


public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(UploadServlet.class);
	private static final String HMAC_SHA1 = "HmacSHA1";  
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
			 {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try {
			
			 //��֤
			String query=request.getQueryString();
			if(query==null||query==""||!query.contains("&ak=")||!query.contains("sign="))
			{
				out.print("{\"code\":\"-1\",\"msg\":\"��������\",\"error\":\"1\",\"message\":\"��������\"}");
				return;
			}
			String appKey=request.getParameter("ak");
			IDbHelper db = DbFactory.GetIDbHelper(request);
			Object appSecretObj=db.getObject("select appSecret from my_tb_app where appKey='"+GetString.FilterSql(appKey)+"'", null, "appSecret");
			if(appSecretObj==null||appSecretObj.toString()=="")
			{
				out.print("{\"code\":\"-2\",\"msg\":\"appKey������\",\"error\":\"1\",\"message\":\"appKey������\"}");
				return;
			}
			String dataQuery=query.substring(0,query.indexOf("&ak="));
			byte[] key=appSecretObj.toString().getBytes("utf-8");
			byte[] data=dataQuery.getBytes("utf-8");
			SecretKeySpec signingKey = new SecretKeySpec(key, HMAC_SHA1);  
	        Mac mac = Mac.getInstance(HMAC_SHA1);  
	        mac.init(signingKey);  
	        byte[] signByte = mac.doFinal(data); 
	        String sign=new String(it.sauronsoftware.base64.Base64.encode(signByte));
	        //  ֮ǰ������url���룬��request.getParameter("sign")������յ���"="����"="
			if(!sign.equals(request.getParameter("sign")))
			{
				out.print("{\"code\":\"-3\",\"msg\":\"ǩ������\",\"error\":\"1\",\"message\":\"ǩ������\"}");
				return;
			}
			
			String host = "bcs.duapp.com";
			String accessKey = "D200252c02041aac02015b01656582bf";
			String secretKey = "8E2496464189a0b3af93b9a50eaf2505";
			String bucket = "kecq-com";
			// ----------------------------------------

			BCSCredentials credentials = new BCSCredentials(accessKey,
					secretKey);
			BaiduBCS baiduBCS = new BaiduBCS(credentials, host);
			// baiduBCS.setDefaultEncoding("GBK");
			baiduBCS.setDefaultEncoding("UTF-8"); // Default UTF-8

			// 1. ����������
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 2. ����FileUpload����
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 3. �ж��Ƿ����ϴ���
			boolean b = ServletFileUpload.isMultipartContent(request);
			if (!b) {
				// �����ļ��ϴ�
				out.print("{\"code\":\"-1\",\"msg\":\"�����ļ��ϴ���\",\"error\":\"1\",\"message\":\"�����ļ��ϴ���\"}");
				return;
			}

			// ���ļ��ϴ���
			// 4. ����request�����FileItem��
			List<FileItem> fileitems = upload.parseRequest(request);
			// 5. ��������
			for (FileItem item : fileitems) {
				// �ж��ǲ�����ͨ�ֶ�
				if (item.isFormField()) {
					//String name = item.getFieldName();
					//String value = item.getString();
					// �ֹ���ת����
					//value = new String(value.getBytes("iso-8859-1"), "utf-8");
				} else {
					// �ļ��ϴ��ֶ�
					// ����ļ���
					String filename = item.getName();
		
					Calendar c = Calendar.getInstance();// ���Զ�ÿ��ʱ���򵥶��޸�
					int year = c.get(Calendar.YEAR);
					int month = c.get(Calendar.MONTH);
					int date = c.get(Calendar.DATE);
					// int hour = c.get(Calendar.HOUR_OF_DAY);
					// int minute = c.get(Calendar.MINUTE);
					// int second = c.get(Calendar.SECOND);
					UUID uuid = java.util.UUID.randomUUID();

					String object = "/" + year + "/" + month + "/" + date + "/"
							+ uuid.toString()
							+ filename.substring(filename.lastIndexOf("."));
					// ���������ȡ����д���ļ�
					MessageDigest sha1Dig = MessageDigest.getInstance("SHA-1");  
					InputStream inputSt = item.getInputStream();
                    long length=item.getSize();
					ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
					byte[] buff = new byte[4096];
					int rc = 0;
					while ((rc = inputSt.read(buff, 0, 4096)) > 0) {
						swapStream.write(buff, 0, rc);
						sha1Dig.update(buff, 0, rc);  
					}
					//����sha1 ֵ
					String sha1=StringEx.byte2hex(sha1Dig.digest());  
					String fileID = null;
					String fileUrl=null;
				   List<Map<String,Object>> list=	db.GetListMap("select fileID,fileUrl from my_tb_file where fileSha1='"+sha1+"'", null);
					if(list!=null&&list.size()>0)
					{
					     fileID=list.get(0).get("fileID").toString();
					     fileUrl=list.get(0).get("fileUrl").toString();
					}
					else
					{
					byte[] in2b = swapStream.toByteArray();
					inputSt.close();
					swapStream.close();
					
					InputStream fileContent = new ByteArrayInputStream(in2b);
				
					ObjectMetadata metadata = new ObjectMetadata();
					// metadata.setContentType("text/html");
					metadata.setContentLength(length);
					PutObjectRequest objrequest = new PutObjectRequest(bucket,
							object, fileContent, metadata);

					ObjectMetadata result = baiduBCS.putObject(objrequest)
							.getResult();
					baiduBCS.putObjectPolicy(bucket, object, X_BS_ACL.PublicRead);

					fileContent.close();
					log.info(result);
					fileUrl="http://bcs.duapp.com/"+bucket+object;
					}
					
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String nowDate=formatter.format(c.getTime());
					//��������ϴ� ����fileID
					if(fileID==null)
					{
						fileID=java.util.UUID.randomUUID().toString().replace("-", "");
						List<String> values=new ArrayList<String>();
						values.add(fileID);
						values.add(item.getName());
						values.add(item.getSize()+"");
						values.add(fileUrl);
						values.add(sha1);
						values.add(nowDate);
						values.add(nowDate);
						db.execute("insert into my_tb_file (fileID,fileName,fileSize,fileUrl,fileSha1, ADD_DATE,UPDATE_DATE) values(?,?,?,?,?,?,?)", values);
					}
					List<String> values=new ArrayList<String>();
					values.add( java.util.UUID.randomUUID().toString().replace("-", ""));
					values.add(fileID);
					values.add(request.getParameter("objectID"));
					values.add(nowDate);
					values.add(nowDate);
					db.execute("insert into my_tb_filerelation (relationID,fileID,objectID,ADD_DATE,UPDATE_DATE) values(?,?,?,?,?)", values);
					
					out.print("{\"code\":\"1\",\"msg\":\"�ϴ��ɹ�\",\"error\":\"0\",\"url\":\"" + fileUrl + "\"}");
				}
			}
		} catch (Exception ex) {
			log.info(ex);
			out.print( "{\"code\":\"-1\",\"msg\":\"ϵͳ�쳣\",\"error\":\"1\",\"message\":\"ϵͳ�쳣\"}");
		} 
		finally
		{
			out.close();
		}
	}
	
}
