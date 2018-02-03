package com.kecq.common;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class HttpHelper {
	
	 public static String DoGetString(String urlString) throws IOException
	 {
		 return DoGetString(urlString,null);
	 }
	 
	  public static String DoGetString(String urlString,String charset) throws IOException
	  {
		  InputStream inputStream =DoGet(urlString);
		  BufferedReader br;
          if(charset==null||charset.equals(""))
          {
        	  br = new BufferedReader(new InputStreamReader(inputStream));
          }
          else
          {
        	  br = new BufferedReader(new InputStreamReader(inputStream,charset));
          }
           
          StringBuilder sb = new StringBuilder();
          String line;
          while((line = br.readLine())!=null) {
              sb.append(line);
          }
          inputStream.close();
          return sb.toString();
	  }

  public static InputStream DoGet(String urlString) throws IOException
  {
      // 建立URL对象，抛出异常
      URL url = new URL(urlString);
      // 得到HttpURLConnection对象
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      // 声明请求方式
      conn.setRequestMethod("GET");
      // 设置连接超时
      conn.setConnectTimeout(6 * 1000);
      // 连接成功
      if (conn.getResponseCode() == 200)
      {
          // 得到服务器传回来的数据，相对我们来说输入流
          InputStream inputStream = conn.getInputStream();
          // 得到数据
//          byte[] data = readInStream(inputStream);
//          // 创建保存文件
//          File file = new File("xiaocai.jpg");
//          // 创建一个文件输出流
//          FileOutputStream outputStream = new FileOutputStream(file);
//          // 将我们所得的二进制数据全部写入我们建好的文件中
//          outputStream.write(data);
//          // 关闭输出流
//          outputStream.close();
          
          return inputStream;
      }
      
      return null;
  }
  
  // 读取流文件的内容
  public static byte[] readInStream(InputStream inputStream) throws Exception
  {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
     
      // 声明缓冲区
      byte[] buffer = new byte[1024];
      // 定义读取默认长度
      int length = -1;
      while ((length = inputStream.read(buffer)) != -1)
      {
          // 把缓冲区中输出到内存中
          byteArrayOutputStream.write(buffer, 0, length);
      }
      // 关闭输出流
      byteArrayOutputStream.close();
      // 关闭输入流
      inputStream.close();
      // 返回这个输出流的字节数组
      return byteArrayOutputStream.toByteArray();
  }
  
  /**
	 * 获取网页全部地址  包括参数 如果参数含中文字符获取的是UTF-8的百分号形式
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String getFullUrl(HttpServletRequest request) throws UnsupportedEncodingException {
	String canshu = "";
		Enumeration<?> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			String paraValue=URLEncoder.encode(request.getParameter(paraName),"utf-8");
			canshu += (paraName + "=" + paraValue + "&");
		}

		String fullUrl = request.getRequestURL().toString();
		if (canshu.length() != 0)
			fullUrl = fullUrl + "?" + canshu.substring(0, canshu.length() - 1);

		return request.getRequestURL()+(request.getQueryString()!=null?"?"+request.getQueryString():"");
	}
  
  public static String DoPostString(String urlString,String params) throws IOException
  {
	  return convertStreamToString(DoPost(urlString,params));
  }
  /**
   * 通过HttpURLConnection模拟post表单提交
   * 
   * @param urlString
   * @param params 例如"name=zhangsan&age=21"
   * @return
   * @throws Exception
   */
  public static InputStream DoPost(String urlString,String params) throws IOException
  {
	  URL url = new URL(urlString);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("POST");// 提交模式
      // conn.setConnectTimeout(10000);//连接超时 单位毫秒
      // conn.setReadTimeout(2000);//读取超时 单位毫秒rf
      if(params!=null)
      {
      conn.setDoOutput(true);// 是否输入参数
      byte[] bypes = params.toString().getBytes();
      conn.getOutputStream().write(bypes);// 输入参数
      }
      
      if (conn.getResponseCode() == 200)
      {
      InputStream inStream=conn.getInputStream();
      return inStream;
      }
      
      return null;
  }
  
  public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
