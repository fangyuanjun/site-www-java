/**
 * MyDataSet.java
 * 2010/5/10
 */
package com.kecq.data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.kecq.common.StringEx;

/**
 * 自定义数据库查询结果集合
 * 
 * @author 方远均
 * 
 */
public class MyDataTable {
   
	private String keyColumnName;

	private List<MyDataRow> rows=new ArrayList<MyDataRow>();
	private List<String> columnNameList;
	public HashMap<String, String> getColumnNameCaptionMap() {
		return columnNameCaptionMap;
	}

	public void setColumnNameCaptionMap(HashMap<String, String> columnNameCaptionMap) {
		this.columnNameCaptionMap = columnNameCaptionMap;
	}
	
	public String getKeyColumnName() {
		return keyColumnName;
	}

	public void setKeyColumnName(String keyColumnName) {
		this.keyColumnName = keyColumnName;
	}
	public List<String> getColumnCaptionList() {
		return columnCaptionList;
	}

	public void setColumnCaptionList(List<String> columnCaptionList) {
		this.columnCaptionList = columnCaptionList;
	}
	private HashMap<String,String> columnNameCaptionMap=new HashMap<String,String>();
	private List<String> columnCaptionList;
public List<MyDataRow> getRows() {
		return rows;
	}

	public List<String> getColumnNameList() {
	return columnNameList;
}

public void setColumnNameList(List<String> columnNameList) {
	this.columnNameList = columnNameList;
}

	public void setRows(List<MyDataRow> rows) {
		this.rows = rows;
		if(this.columnNameList==null)
		{
			this.columnNameList=rows.get(0).getColumNameList();
		}
	}

/**
 * 构造函数
 */
	public MyDataTable() {
	}

	/**
	 * 构造函数
	 * 
	 * @param sql
	 * @throws Exception
	 * @throws CloneNotSupportedException
	 */
	public MyDataTable(String sql) throws Exception {

		IDbHelper db=DbFactory.GetIDbHelper();
		if (db.exists(sql)) {
			ResultSet rs = db.getCurrentConnection().createStatement().executeQuery(sql);
			ResultSetMetaData rsmd=rs.getMetaData();
			
			List<String> columnNameList=new ArrayList<String>();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) 
			{
				columnNameList.add(rsmd.getColumnName(i));
			}
			this.setColumnNameList(columnNameList);
			
			while (rs.next()) {
				MyDataRow dr=new MyDataRow();
				ArrayList<Object> dataColList = new ArrayList<Object>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					
					dataColList.add(rs.getString(i));   //这里getObject 好像整形 (string)obj 不能这样转换
				}
			dr.setColumNameList(columnNameList);
			dr.setDataList(dataColList);
			if(this.rows==null)
				this.rows=new ArrayList<MyDataRow>();
		    this.rows.add(dr);
			}
			
			rs.close();
			db.closeDB();
		}
	}
	
	public void sort(String columnName,int order)
	{
		MyDataRowComparator comp=new MyDataRowComparator(columnName,order);
		Collections.sort(this.getRows(),comp);
	}
	
	public void sort(int columnIndex,int order)
	{
		MyDataRowComparator comp=new MyDataRowComparator(columnIndex,order);
		Collections.sort(this.getRows(),comp);
	}
	public MyDataTable clone(MyDataTable source) throws Exception
	{
		throw new Exception("暂时还没有写哦");
		//MyDataTable dest=new MyDataTable();
		//List<MyDataRow> rows=new ArrayList<MyDataRow>(); 
//		for(int i=0;i<source.getRows().size();i++)
//		{
//			List
//			for(int j=0;j<source.getColumnNameList().size();j++)
//			{
//			rows.add(source.getRows().get(i).getString(j));
//			}
//		}
		//dest.setRows(rows);
		//return dest;
	}
   public int getRowCount()
   {
	   if((this!=null)&&(this.getRows()!=null))
		   return this.getRows().size();
	   
	   return 0;
   }
   
   public int getColumnCount()
   {
	   if((this!=null)&&(this.getColumnNameList()!=null))
		   return this.getColumnNameList().size();
	   
	   return 0;
   }
	public String toJson(int page) throws Exception
	{
		
		String str="{\"total\":\""+this.getRowCount()+"\",\"page\":\""+page+"\",\"rows\":[";
	    for(int i=0;i<this.getRowCount();i++)
	    {
	    	String row="{\"id\":\"";
	    	
	    	if(this.getKeyColumnName()==null)
	    		row+=(this.getRows().get(i).getString(0)+"\",\"cell\":[");
	    	else
	    		row+=(this.getRows().get(i).getString(this.getKeyColumnName())+"\",\"cell\":[");
	    	
	    	for(int j=0;j<this.getColumnCount();j++)
	    	{
	    		row+=("\""+this.getRows().get(i).getString(j)+"\",");
	    	}
	    	
	    	row=StringEx.trimEnd(row, ",");
	    	row+="]},";
	    	str+=row;
	    }
	    str= StringEx.trimEnd(str, ",");
	    str+="]}";
		return str;
	}
	
	public String toString()
	{
		String str="";
		for(int i=0;i<this.getRowCount();i++)
		{
			str+=this.getRows().get(i).toString()+"\n";
		}
		
		return str;
	}
}
