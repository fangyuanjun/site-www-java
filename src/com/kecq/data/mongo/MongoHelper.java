package com.kecq.data.mongo;

import java.net.UnknownHostException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;




import com.baidu.bae.api.util.BaeEnv;
import com.baidu.cloudservice.conf.Config;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoHelper {

	private static DB baiduMongoDB;
	private static DB localMongoDB;
	
	private static DB GetBaiduMongoDB() throws UnknownHostException
	{
		if(baiduMongoDB!=null)
		{
			return baiduMongoDB;
		}
	 	/*****1. �滻Ϊ���Լ������ݿ������ɴӹ������Ĳ鿴����*****/
		String databaseName = Config.MONGODBNAME;
  
		/******2. �ӻ���������ȡ�����ݿ�������Ҫ�Ĳ���******/
		String host = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_ADDR_MONGO_IP);
		String port = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_ADDR_MONGO_PORT);
		String username = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_AK);
		String password = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_SK);
		String serverName = host + ":" + port;
      
		/******3. �������Ӳ�ѡ�����ݿ���ΪdatabaseName�ķ�����******/
      	MongoClient mongoClient = new MongoClient(new ServerAddress(serverName),
					Arrays.asList(MongoCredential.createMongoCRCredential(username, databaseName, password.toCharArray())),
					new MongoClientOptions.Builder().cursorFinalizerEnabled(false).build());
		DB mongoDB = mongoClient.getDB(databaseName);
		mongoDB.authenticate(username, password.toCharArray());
      	/*������������ȫ�������ͿɶԵ�ǰ���ݿ������Ӧ�Ĳ�����*/
		baiduMongoDB=mongoDB;
		return mongoDB;
	}
	
	private static DB GetLocalMongoDB() throws UnknownHostException
	{
		if(localMongoDB!=null)
		{
			return localMongoDB;
		}
	 	/*****1. �滻Ϊ���Լ������ݿ������ɴӹ������Ĳ鿴����*****/
		String databaseName = Config.MONGODBNAME;
 
		/******2. �ӻ���������ȡ�����ݿ�������Ҫ�Ĳ���******/
		String host = "127.0.0.1";
		String port = "27017";
		String username = "admin";
		String password = "admin";
		String serverName = host + ":" + port;
      
		/******3. �������Ӳ�ѡ�����ݿ���ΪdatabaseName�ķ�����******/
      	MongoClient mongoClient = new MongoClient(new ServerAddress(serverName),
					Arrays.asList(MongoCredential.createMongoCRCredential(username, databaseName, password.toCharArray())),
					new MongoClientOptions.Builder().cursorFinalizerEnabled(false).build());
		DB mongoDB = mongoClient.getDB(databaseName);
		mongoDB.authenticate(username, password.toCharArray());
      	/*������������ȫ�������ͿɶԵ�ǰ���ݿ������Ӧ�Ĳ�����*/
		localMongoDB=mongoDB;
		return mongoDB;
	}
	
	public static DB GetMongoDB(HttpServletRequest request) throws UnknownHostException
	{
		if(request.getServerName().equals("localhost")||request.getServerName().equals("127.0.0.1"))
		{
			return GetLocalMongoDB();
		}
		else
		{
		 return GetBaiduMongoDB();
		}
	}
}
