package com.kecq.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DbHelper implements IDbHelper{
 
	public DbHelper(DataInfo info)
	{
	  this.info=info;
	}

    private DataInfo info=null;
	private Connection conn = null;
	private Statement stmt=null;

	public Connection getCurrentConnection() throws Exception {
		if(this.conn==null||this.conn.isClosed())
		{
			Class.forName(this.info.getDirverName());
			// 建立连接
			this.conn = DriverManager.getConnection(this.info.getConStr(), this.info.getUsername(), this.info.getPassword());
		}
		return this.conn;
	}
	
	public Statement getCurrentStatement() throws Exception
	{
		if(stmt==null||stmt.isClosed())
		{
			stmt=getCurrentConnection().createStatement();
		}
		
		return stmt;
	}


	public List<Map<String, Object>> GetListMap(String sql,List<String> sqlValue) throws Exception
	{
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		PreparedStatement ps = this.getCurrentConnection().prepareStatement(sql);
		if (sqlValue != null) {
			for (int i = 0; i < sqlValue.size(); i++)
			{
				ps.setString(i + 1, sqlValue.get(i));
			}
		}
		ResultSet rs = ps.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount=rsmd.getColumnCount();
		while(rs.next())
		{
			Map<String, Object> map = new HashMap<String, Object>();
			for(int i=1;i<=columnCount;i++)
			{
			String columnName=rsmd.getColumnName(i);
			map.put(columnName, rs.getObject(i));
			}
			list.add(map);
		}
		
		return list;
	}

	public int execute(String sqlQuery, List<String> sqlValue)throws Exception {
		int count = 0;

		PreparedStatement ps = this.getCurrentConnection().prepareStatement(sqlQuery);
		if (sqlValue != null) {
			for (int i = 0; i < sqlValue.size(); i++)
			{
				ps.setString(i + 1, sqlValue.get(i));
			}
		}
		count = ps.executeUpdate();

		return count;
	}


	public Object getObject(String sql, List<String> sqlValue,String columnName)throws Exception {

		PreparedStatement ps = this.getCurrentConnection().prepareStatement(sql);
		if (sqlValue != null) {
			for (int i = 0; i < sqlValue.size(); i++)
				ps.setString(i + 1, sqlValue.get(i));
		}
		
		ResultSet rs=ps.executeQuery(); 
		Object obj=null;
		if (rs.next()) {
			 obj = rs.getObject(columnName);
		}
		this.closeDB();
		
		return obj;
	}
	/**
	 * 判断参数sql语句查询的对象是否存在
	 * 
	 * @param sql
	 *            ---sql语句
	 * @return 如果存在返回true,否则返回false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean exists(String sql) throws Exception {
		ResultSet rs=getCurrentStatement().executeQuery(sql); 
		boolean flag = rs.next();
		this.closeDB();
		return flag;
	}


	/**
	 * 关闭数据库
	 * 
	 * @throws SQLException
	 */

	public void closeDB() throws SQLException {
	

		if (conn != null || (!conn.isClosed()))
			conn.close();
	}

}
