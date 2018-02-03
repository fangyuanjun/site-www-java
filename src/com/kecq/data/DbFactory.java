package com.kecq.data;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;


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
		//（1）指定服务地址，其中dbname需要自己修改
        //String dbUrl = "jdbc:mysql://sqld.duapp.com:4050/dbname";
        //（2）直接从请求header中获取ip、端口、用户名和密码信息
	//String host = request.getHeader("BAE_ENV_ADDR_SQL_IP");
	//String port = request.getHeader("BAE_ENV_ADDR_SQL_PORT");
	//String username = request.getHeader("BAE_ENV_AK");
	//String password = request.getHeader("BAE_ENV_SK");
       //（3）从线程变量BaeEnv接口获取ip、端口、用户名和密码信息
	String host = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_ADDR_SQL_IP);
	String port = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_ADDR_SQL_PORT);
	String username = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_AK);
	String password = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_SK);
	String driverName = "com.mysql.jdbc.Driver";
	String dbUrl = "jdbc:mysql://";
	String serverName = host + ":" + port + "/";
 
        //从平台查询应用要使用的数据库名
	String databaseName = "yourDataBaseName";
	String connName = dbUrl + serverName + databaseName;
		*/
		if(db2==null)
		{
		DataInfo info=new DataInfo();
		info.setDirverName("com.mysql.jdbc.Driver");
		//java的数据库:  glEEzAfwwomFPzfrdWjZ 	
		//php的数据库: SRfeyCpibnRiYcjRCxFI 	
		//之前没删除的数据库: gynSFkuarmgPJAlInMHm
		info.setConStr("jdbc:mysql://sqld.duapp.com:4050/glEEzAfwwomFPzfrdWjZ");
		info.setUsername("D200252c02041aac02015b01656582bf");
		info.setPassword("8E2496464189a0b3af93b9a50eaf2505");
		db2=new DbHelper(info);

		}
		
		return db2;
	}
	public IDbHelper CreateIDbHelper(DataInfo info) throws Exception {
		if (info.getConName() == null || info.getConName() == "") {
			throw new Exception("连接名称不能为空");
		}
		
		return new DbHelper(info);
	}
}
