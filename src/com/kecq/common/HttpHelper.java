package com.kecq.common;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
      // ����URL�����׳��쳣
      URL url = new URL(urlString);
      // �õ�HttpURLConnection����
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      // ��������ʽ
      conn.setRequestMethod("GET");
      // �������ӳ�ʱ
      conn.setConnectTimeout(6 * 1000);
      // ���ӳɹ�
      if (conn.getResponseCode() == 200)
      {
          // �õ������������������ݣ����������˵������
          InputStream inputStream = conn.getInputStream();
          // �õ�����
//          byte[] data = readInStream(inputStream);
//          // ���������ļ�
//          File file = new File("xiaocai.jpg");
//          // ����һ���ļ������
//          FileOutputStream outputStream = new FileOutputStream(file);
//          // ���������õĶ���������ȫ��д�����ǽ��õ��ļ���
//          outputStream.write(data);
//          // �ر������
//          outputStream.close();
          
          return inputStream;
      }
      
      return null;
  }
  
  // ��ȡ���ļ�������
  public static byte[] readInStream(InputStream inputStream) throws Exception
  {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
     
      // ����������
      byte[] buffer = new byte[1024];
      // �����ȡĬ�ϳ���
      int length = -1;
      while ((length = inputStream.read(buffer)) != -1)
      {
          // �ѻ�������������ڴ���
          byteArrayOutputStream.write(buffer, 0, length);
      }
      // �ر������
      byteArrayOutputStream.close();
      // �ر�������
      inputStream.close();
      // ���������������ֽ�����
      return byteArrayOutputStream.toByteArray();
  }
  

  
  public static String DoPostString(String urlString,String params) throws IOException
  {
	  return convertStreamToString(DoPost(urlString,params));
  }
  /**
   * ͨ��HttpURLConnectionģ��post���ύ
   * 
   * @param urlString
   * @param params ����"name=zhangsan&age=21"
   * @return
   * @throws Exception
   */
  public static InputStream DoPost(String urlString,String params) throws IOException
  {
	  URL url = new URL(urlString);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("POST");// �ύģʽ
      // conn.setConnectTimeout(10000);//���ӳ�ʱ ��λ����
      // conn.setReadTimeout(2000);//��ȡ��ʱ ��λ����rf
      if(params!=null)
      {
      conn.setDoOutput(true);// �Ƿ��������
      byte[] bypes = params.toString().getBytes();
      conn.getOutputStream().write(bypes);// �������
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
