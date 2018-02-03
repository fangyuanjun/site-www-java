package com.kecq.data;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import com.kecq.common.Convert;

public class MyDataRow {

	 private List<String> columNameList;
	 private List<Object> dataList;
	 private List<Type> columnTypes;
	 private MyDataTable dataTable;
	 private String keyColumnName;
	 
	public List<Type> getColumnTypes() {
		return columnTypes;
	}
	public void setColumnTypes(List<Type> columnTypes) {
		this.columnTypes = columnTypes;
	}
	public String getKeyColumnName() {
		return keyColumnName;
	}
	public void setKeyColumnName(String keyColumnName) {
		this.keyColumnName = keyColumnName;
	}
	public MyDataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(MyDataTable dataTable) {
		this.dataTable = dataTable;
	}
	public List<String> getColumNameList() {
		return columNameList;
	}
	public void setColumNameList(List<String> columNameList) {
		this.columNameList = columNameList;
	}
	public List<Object> getDataList() {
		return dataList;
	}
	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}
	
	
	public int getColumnCount()
	{
		if(this.columNameList!=null)
		return this.columNameList.size();
		
		return 0;
	}
	/**
	 * 根据列的名字获取该列是在数据表中的第几列   从0开始
	 * 
	 * @param column
	 * @return
	 * @throws Exception
	 */
	public int getColNumberByColumn(String columnName) throws Exception {
		if(columNameList==null||columNameList.size()==0)
			columNameList=this.getDataTable().getColumnNameList();
		for (int i = 0; i < this.columNameList.size(); i++) 
		{
			if(this.columNameList.get(i).equals(columnName))
			{
				return i;
			}
		}
     
      throw new Exception("没有找到列名！");
	}
	
	

	public Object getObject(String columnName) throws Exception {
		return this.getObject(this.getColNumberByColumn(columnName));
	}


	public Object getObject(int columnIndex)  {
	   return dataList.get(columnIndex);
	}
	
	public String getString(String columnName) throws Exception
	{
		
		return Convert.toString(this.getObject(columnName));
	}
	
	public String getString(int columnIndex)
	{
		
		return Convert.toString(this.getObject(columnIndex));
		
	}
	
	 public  Date getDate(String columnName) throws Exception
	 {
		
		 return Convert.toDateTime(this.getString(columnName));
		// return (Date)(this.getObject(columnName));
	 }
     
	 public Date getDate(int columnIndex) throws Exception
	 {
		return Convert.toDateTime(this.getObject(columnIndex));
		
	 }
	 public  boolean getBoolean(String columnName) throws Exception
	 {
		 return Convert.toBoolean(this.getString(columnName));
	 }

	 public   boolean getBoolean(int columnIndex) throws Exception
	 {
		 return Convert.toBoolean(this.getString(columnIndex));
		
	 }
	 

		
	 public int getInt(String columnName) throws NumberFormatException, Exception
	 {
		return Convert.toInt(this.getString(columnName));
		
	 }
	 

	 public int getInt(int columnIndex) throws NumberFormatException, Exception
	 {
		 return Convert.toInt(this.getString(columnIndex));
	 }
	 

	 public double getDouble(int columnIndex) throws NumberFormatException, Exception
	 {
		 return Convert.toDouble(this.getString(columnIndex));
	 }
	 public double getDouble(String columnName) throws NumberFormatException, Exception
	 {
		 return Convert.toDouble(this.getString(columnName));
	 }
	 
	 public String toString()
	 {
		 String str="";
		 for(int i=0;i<this.getColumnCount();i++)
		 {
			str+=(this.getString(i)+"    "); 
		 }
		 
		 return str;
	 }
}
