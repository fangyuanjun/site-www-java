/*
 * SqlInterface.java
 * 2010/4/18
 */
package com.kecq.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;


/**
 * ���ݿ�ӿ�
 * @author ��Զ��
 * @version 1.0
 */
public interface IDbHelper {

   public Connection getCurrentConnection() throws Exception;
   
   //��ѯ���ܴ�����?
	public List<Map<String, Object>> GetListMap(String sql,List<String> sqlValue) throws Exception;
	public int execute(String sql, List<String> sqlValue)throws Exception;
	public Object getObject(String sql, List<String> sqlValue,String columnName)throws Exception ;
	public boolean exists(String sql) throws Exception;
	public void closeDB() throws Exception;
}
