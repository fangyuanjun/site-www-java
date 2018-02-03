package com.kecq.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.kecq.common.Path;

public class DbFactory {

	private static IDbHelper db= null;
	private static IDbHelper db2= null;
	
	public static IDbHelper GetIDbHelper() throws IOException {

		if(db==null)
		{
//		Properties p = new Properties();
//		String s = Path.getFullPathRelateClass("../../../../web.properties",Path.class);
//		FileInputStream fs=new FileInputStream(s);
//		p.load(fs);
//		String now_connection=p.getProperty("now_connection");
//		DataInfo info=new DataInfo();
//		info.setDirverName(p.getProperty(now_connection+"_driver"));
//		info.setConStr(p.getProperty(now_connection+"_url"));
//		info.setUsername(p.getProperty(now_connection+"_user"));
//		info.setPassword(p.getProperty(now_connection+"_password"));
			
			DataInfo info=new DataInfo();
			info.setDirverName("com.mysql.jdbc.Driver");
			info.setConStr("jdbc:mysql://localhost/test?characterEncoding=utf-8");
		info.setUsername("root");
		info.setPassword("root");
		db=new DbHelper(info);
		//fs.close();
		}
		
		return db;
	}

	public static IDbHelper GetIDbHelper(	HttpServletRequest request) throws IOException {

		if(request.getServerName().equals("localhost")||request.getServerName().equals("127.0.0.1"))
		{
			return GetIDbHelper();
		}
		else
		{
		 return GetIDbHelperBaidu();
		}
	}
	

	public static IDbHelper GetIDbHelperBaidu() 
	{  
		/*
		//��1��ָ�������ַ������dbname��Ҫ�Լ��޸�
        //String dbUrl = "jdbc:mysql://sqld.duapp.com:4050/dbname";
        //��2��ֱ�Ӵ�����header�л�ȡip���˿ڡ��û�����������Ϣ
	//String host = request.getHeader("BAE_ENV_ADDR_SQL_IP");
	//String port = request.getHeader("BAE_ENV_ADDR_SQL_PORT");
	//String username = request.getHeader("BAE_ENV_AK");
	//String password = request.getHeader("BAE_ENV_SK");
       //��3�����̱߳���BaeEnv�ӿڻ�ȡip���˿ڡ��û�����������Ϣ
	String host = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_ADDR_SQL_IP);
	String port = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_ADDR_SQL_PORT);
	String username = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_AK);
	String password = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_SK);
	String driverName = "com.mysql.jdbc.Driver";
	String dbUrl = "jdbc:mysql://";
	String serverName = host + ":" + port + "/";
 
        //��ƽ̨��ѯӦ��Ҫʹ�õ����ݿ���
	String databaseName = "yourDataBaseName";
	String connName = dbUrl + serverName + databaseName;
		*/
		if(db2==null)
		{
		DataInfo info=new DataInfo();
		info.setDirverName("com.mysql.jdbc.Driver");
		//java�����ݿ�:  glEEzAfwwomFPzfrdWjZ 	
		//php�����ݿ�: SRfeyCpibnRiYcjRCxFI 	
		//֮ǰûɾ�������ݿ�: gynSFkuarmgPJAlInMHm
		info.setConStr("jdbc:mysql://sqld.duapp.com:4050/glEEzAfwwomFPzfrdWjZ");
		info.setUsername("D200252c02041aac02015b01656582bf");
		info.setPassword("8E2496464189a0b3af93b9a50eaf2505");
		db2=new DbHelper(info);

		}
		
		return db2;
	}
	public IDbHelper CreateIDbHelper(DataInfo info) throws Exception {
		if (info.getConName() == null || info.getConName() == "") {
			throw new Exception("�������Ʋ���Ϊ��");
		}
		
		return new DbHelper(info);
	}
}
