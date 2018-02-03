package com.kecq.data;



public class EntityHelperG <T>{

	private Class<?> c;
	private String tableName;
	private Boolean isAddPrimary;
	private IDbHelper db;
	private String[] primary;
	
	/**
	 * 
	 * @param c
	 * @param tableName     表名
	 * @param isAddPrimary  是否添加主键,对于自动递增的字段 应该为false
	 * @param db
	 * @param primary   主键,可以多个
	 */
	public  EntityHelperG(Class<?> c,String tableName,Boolean isAddPrimary, IDbHelper db, String...primary)
	{
		this.c=c;
		this.tableName=tableName;
		this.isAddPrimary=isAddPrimary;
		this.db=db;
		this.primary=primary;
	}
	
	@SuppressWarnings("unchecked")
	public T getEntity(Object id) throws Exception
	{
		T t=(T) EntityHelper.getEntity(c, id, tableName, primary[0], db);
		return t;
	}
	
	public int insert(T t) throws Exception
	{
		return EntityHelper.insert(t, tableName, primary[0], isAddPrimary, db);
	}
	
	public int update(T t) throws Exception
	{
		return EntityHelper.update(t, tableName, db, primary);
	}
}
