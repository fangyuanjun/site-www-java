package com.kecq.data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.kecq.common.GetString;


public class CRUD {

	private static Map<String, List<String>> columnsMap;
	private IDbHelper db;
	private String tableName;
    private String primaryKey;
    private String userIDKey;
	/**
	 * 构造函数
	 * 
	 * @param db
	 * @param tableName
	 * @throws Exception
	 */
	public CRUD(IDbHelper db, String tableName,String primaryKey,String userIDKey) throws Exception {
		this.db = db;
		this.tableName = tableName;
		this.primaryKey=primaryKey;
		this.userIDKey=userIDKey;
		if (columnsMap == null) {
			columnsMap = new HashMap<String, List<String>>();
			if (!columnsMap.containsKey(tableName)) {
				RefreshColumnsMap(db, tableName,primaryKey,userIDKey);
			}
		}
	}

	/**
	 * 刷新列
	 * 
	 * @param db
	 * @param tableName
	 * @throws SQLException
	 * @throws Exception
	 */
	public void RefreshColumnsMap(IDbHelper db, String tableName,String primaryKey,String userKey)
			throws SQLException, Exception {
		this.db = db;
		this.tableName = tableName;
		this.primaryKey=primaryKey;
		this.userIDKey=userKey;
		Statement stmt = db.getCurrentConnection().createStatement();
		ResultSet rs = stmt.executeQuery("select * from " + tableName
				+ " limit 0,1");
		ResultSetMetaData rsmd = rs.getMetaData();// rs为查询结果集
		int count = rsmd.getColumnCount();
		List<String> col = new ArrayList<String>();
		for (int i = 1; i <= count; i++) {
			col.add(rsmd.getColumnName(i));// 把列名存入向量heads中}
		}
		columnsMap.put(tableName, col);
	}

	public int Update(HttpServletRequest request) throws Exception {

		List<String> columns = columnsMap.get(this.tableName);
		Iterator iter = request.getParameterMap().entrySet().iterator();
		String sql="update "+this.tableName+" set ";
		List<String> sqlValue=new ArrayList<String>();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String key = entry.getKey().toString();
			Object obj = entry.getValue();
			String val = "";
			if (obj instanceof String[]) {
				String[] strs = (String[]) obj;
				val = Arrays.toString(strs);// jdk1.5以上才支持，1.4的话就自己循环
			} else {
				val = obj.toString();
			}
			
			if(columns.contains(key))
			{
				if(!key.equalsIgnoreCase(this.primaryKey)&&!key.equalsIgnoreCase("UPDATE_DATE")&&!key.equalsIgnoreCase("ADD_DATE"))
				{
				sql+=" "+key+"=?,";
				sqlValue.add(val.replace("[", "").replace("]", ""));
				}
			}
		}
		
		if(columns.contains("UPDATE_DATE"))
		{
			sql+=" UPDATE_DATE=?,";
			Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sqlValue.add(formatter.format(c.getTime()));
		}
		
		sql=sql.substring(0,sql.lastIndexOf(','));
		
		  Object obj=request.getParameter(this.primaryKey);
		     if(obj==null)
		     {
		    	 return -2;
		     }
		     
		     String v="";
		     for(String s : obj.toString().split(","))
		     {
		    	 v+="?,";
		    	sqlValue.add(s);
		     }
		     v=v.substring(0,v.lastIndexOf(","));
		     
		sql+=" where "+primaryKey+" in ("+v+") and "+userIDKey+"=?";
		sqlValue.add(request.getSession().getAttribute(userIDKey).toString());
		return db.execute(sql, sqlValue);
	}

	public int Add(HttpServletRequest request) throws Exception {

		List<String> columns = columnsMap.get(this.tableName);
		Iterator iter = request.getParameterMap().entrySet().iterator();
		String sql="insert  into "+this.tableName+" (";
		List<String> sqlValue=new ArrayList<String>();
		String cols="";
		String vals="";
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String key = entry.getKey().toString();
			Object obj = entry.getValue();
			String val = "";
			if (obj instanceof String[]) {
				String[] strs = (String[]) obj;
				val = Arrays.toString(strs);// jdk1.5以上才支持，1.4的话就自己循环
			} else {
				val = obj.toString();
			}
			
			if(columns.contains(key)&&!key.equalsIgnoreCase(userIDKey)&&!key.equalsIgnoreCase("UPDATE_DATE")&&!key.equalsIgnoreCase("ADD_DATE"))
			{
			    cols+=key+",";
			    vals+="?,";
			    
				sqlValue.add(val.replace("[", "").replace("]", ""));
			}
		}
		
		cols+=userIDKey+"";
		vals+="?";
		sqlValue.add(request.getSession().getAttribute(userIDKey).toString());
		
		if(columns.contains("ADD_DATE"))
		{
			cols+=",ADD_DATE";
			vals+=",?";
			Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sqlValue.add(formatter.format(c.getTime()));
		}
		
		if(columns.contains("UPDATE_DATE"))
		{
			cols+=",UPDATE_DATE";
			vals+=",?";
			Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sqlValue.add(formatter.format(c.getTime()));
		}
		
		Object obj=request.getParameter(primaryKey);
		//如果主键为空并且不等于0    等于0 则让数据库自动自增
		if(obj==null||obj.toString().equals(""))
		{
			cols+=","+primaryKey;
			vals+=",?";
			UUID uuid = java.util.UUID.randomUUID();
			sqlValue.add(uuid.toString());
		}
		
		sql+=cols+") values ("+vals+")";
	
		return db.execute(sql, sqlValue);
	}
	
	public int Delete(HttpServletRequest request) throws Exception {

	     Object obj=request.getParameter(this.primaryKey);
	     if(obj==null)
	     {
	    	 return -2;
	     }
	     
	     List<String> sqlValue=new ArrayList<String>();
	     
	     String v="";
	     for(String s : obj.toString().split(","))
	     {
	    	 v+="?,";
	    	sqlValue.add(s);
	     }
	     v=v.substring(0,v.lastIndexOf(","));
		String sql="delete  from "+this.tableName+"  where "+this.primaryKey+" in ("+v+") and "+userIDKey+"=?";
	
		sqlValue.add(request.getSession().getAttribute(userIDKey).toString());
		return db.execute(sql, sqlValue);
	}
	
	public String Get(HttpServletRequest request)  throws Exception
	{
		String sql="select  *  from "+this.tableName+"  where "+this.primaryKey+" =? and "+userIDKey+"=?";
	    sql="select  *  from "+this.tableName+"  where "+this.primaryKey+" ='"+GetString.FilterSql(request.getParameter(this.primaryKey))
	    		+"' and "+userIDKey+"='"+GetString.FilterSql(request.getSession().getAttribute(userIDKey).toString())+"'";
		List<String> sqlValue=new ArrayList<String>();
		sqlValue.add(request.getParameter(this.primaryKey));
		sqlValue.add(request.getSession().getAttribute(userIDKey).toString());
		//查询不能带参数?
		List<Map<String, Object>> list= db.GetListMap(sql, null);
		String json=null;
		//String json=JsonHelper.ListMapToJson(list, false);
		
		return json;
	}
}
