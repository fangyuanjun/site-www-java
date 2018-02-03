package com.blog.dal;



import com.kecq.data.IDbHelper;

public class DalBase {

	private IDbHelper IDbHelper;
	public IDbHelper getIDbHelper()
	{
//		if(IDbHelper==null)
//		{
//			DataInfo info = new DataInfo();
//			info.setDirverName("com.mysql.jdbc.Driver");
//			info.setConStr("jdbc:mysql://localhost:3306/db_fyj?characterEncoding=utf8&allowMultiQueries=true");
//			info.setUsername("root");
//			info.setPassword("fangfang");
//			IDbHelper = new DbHelper(info);
//		}
		
		return IDbHelper;
	}
	public void setIDbHelper(IDbHelper iDbHelper) {
		IDbHelper = iDbHelper;
	}
	
	
}
