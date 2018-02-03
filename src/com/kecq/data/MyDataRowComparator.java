package com.kecq.data;

import java.util.Comparator;
import java.util.Date;

import com.kecq.common.Convert;


public class MyDataRowComparator implements Comparator<Object>{
	private int columnIndex=-1;   //因为可能对列序列为0的进行排序   -1 表示没有输入列序号
	private String columnName;
	/**  排序 0表示降序   1表示升序 */
	private int order;
 public MyDataRowComparator(String columnName,int order)
 {
  this.columnName=columnName;
  this.order=order;
 }
 
 public MyDataRowComparator(int columnIndex,int order)
 {
	 this.columnIndex=columnIndex;
	 this.order=order;
 }
 
public int compare(Object o1, Object o2) {
	// TODO Auto-generated method stubi
	//如果没有设置排序列直接返回0
	if(this.columnIndex==-1&&this.columnName==null)
		return 0;
	MyDataRow row1=(MyDataRow)o1;
	MyDataRow row2=(MyDataRow)o2;
	int result=0;
    try {
		Object obj1=(this.columnIndex==-1)?row1.getObject(columnName):row1.getObject(columnIndex);
		Object obj2=(this.columnIndex==-1)?row2.getObject(columnName):row2.getObject(columnIndex);
		if(obj1 instanceof Date)
		{
			
			result= ((Date)obj1).compareTo((Date)obj2);
		}
		else
		if(obj1 instanceof String)
		{
			
			result=  ((String)obj1).compareTo((String)obj2);
		}
		else
				if(obj1 instanceof Boolean)
					result=((Boolean)obj1).compareTo((Boolean)obj2);
				else
					result=  Double.compare(Convert.toDouble(obj1), Convert.toDouble(obj2));
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    if(order>0)
	return result;
    else
    	return -result;
  }
}
