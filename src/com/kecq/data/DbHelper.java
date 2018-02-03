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

	public Connection getCurrentConnection() throws Exception {
		if(this.conn==null||this.conn.isClosed())
		{
			Class.forName(this.info.getDirverName());
			// 建立连接
			this.conn = DriverManager.getConnection(this.info.getConStr(), this.info.getUsername(), this.info.getPassword());
		}
		
	
		return this.conn;
	}
	



	public List<Map<String, Object>> GetListMap(String sql,Object...sqlValue) throws Exception
	{
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		PreparedStatement ps = this.getCurrentConnection().prepareStatement(sql);
		if (sqlValue.length != 0) {
			for (int i = 0; i < sqlValue.length; i++)
			{
				ps.setObject(i + 1, sqlValue[i]);
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
		
		rs.close();
		ps.close();
		closeDB();
		return list;
	}

	public int execute(String sqlQuery, Object...sqlValue)throws Exception {
		int count = 0;

		PreparedStatement ps = this.getCurrentConnection().prepareStatement(sqlQuery);

		if (sqlValue.length>0) {
			for (int i = 0; i < sqlValue.length; i++)
			{
				ps.setObject(i + 1, sqlValue[i]);
			}
		}
		count = ps.executeUpdate();
        ps.close();
        closeDB();
		return count;
	}

	
	public Object getObject(String sql, String columnName,Object...sqlValue)throws Exception {

		PreparedStatement ps = this.getCurrentConnection().prepareStatement(sql);
		if (sqlValue.length>0) {
			for (int i = 0; i < sqlValue.length; i++)
				ps.setObject(i + 1, sqlValue[i]);
		}
		
		ResultSet rs=ps.executeQuery(); 
		Object obj=null;
		if (rs.next()) {
			 obj = rs.getObject(columnName);
		}
		
		rs.close();
		ps.close();
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
	public boolean exists(String sql,Object...sqlValue) throws Exception {
		PreparedStatement ps = this.getCurrentConnection().prepareStatement(sql);
		if (sqlValue.length != 0) {
			for (int i = 0; i < sqlValue.length; i++)
			{
				ps.setObject(i + 1, sqlValue[i]);
			}
		}
		
		ResultSet rs=ps.executeQuery(); 
		boolean flag = rs.next();
		rs.close();
		ps.close();
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
		{
			conn.close();
		}
	}

	@Override
	public ResultSet GetResultSet(String sql, Object... sqlValue)
			throws Exception {
		// TODO Auto-generated method stub
		
		PreparedStatement ps = this.getCurrentConnection().prepareStatement(sql);
		
		if (sqlValue.length != 0) {
			for (int i = 0; i < sqlValue.length; i++)
			{
				ps.setObject(i + 1, sqlValue[i]);
			}
		}
		ResultSet rs = ps.executeQuery();
		
		return rs;
	}




	@Override
	public void closeResultSet(ResultSet rs) {
		if(rs==null)
		{
			return ;
		}
		
		Connection conn=null;
		Statement st=null;
		try
		{
			st=rs.getStatement();
			conn=st.getConnection();
			rs.close();
			if(st!=null)
			{
				st.close();
			}
			
			if(conn!=null){
				conn.close();
			}
		}
		catch(Exception e){
			
		}
		finally{
			rs=null;
			st=null;
			conn=null;
		}
	}


	
	
}
