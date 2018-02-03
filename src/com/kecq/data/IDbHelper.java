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
 * 数据库接口
 * @author 方远均
 * @version 1.0
 */
public interface IDbHelper {

   public Connection getCurrentConnection() throws Exception;
   
   //查询不能带参数?
	public List<Map<String, Object>> GetListMap(String sql,Object...sqlValue) throws Exception;
	
	public ResultSet GetResultSet(String sql,Object...sqlValue) throws Exception;
	
	public int execute(String sql, Object... sqlValue)throws Exception;
	public Object getObject(String sql,String columnName,Object... sqlValue)throws Exception ;
	public boolean exists(String sql,Object...sqlValue) throws Exception;
	public void closeDB() throws Exception;
	
	public void closeResultSet(ResultSet rs);
}
