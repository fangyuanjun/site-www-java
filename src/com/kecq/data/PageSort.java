package com.kecq.data;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class PageSort {

	
	public MyDataTable getPageList(PageInfo pi)
	{
         
		  MyDataTable source=pi.getMyDataTable();
		   if(source==null||source.getRows()==null)
			   return source;
			int count=source.getRows().size();
			int startIndex = (pi.getPageNow() - 1) * pi.getPageShow();
			int endIndex = startIndex + pi.getPageShow() - 1;
			if (endIndex > count - 1)
				endIndex = count - 1;
			//String orderStr="";
			MyDataRowComparator comp=new MyDataRowComparator(pi.getSortColumnIndex(),pi.getOrder());
			if(pi.getSortColumnIndex()==-1)
				comp=new MyDataRowComparator(pi.getSortColumnName(),pi.getOrder());
			
			if(pi.isOnlySortCurrentPage()==false)
				Collections.sort(source.getRows(),comp);
			
		   
           List<MyDataRow> newRows=new ArrayList<MyDataRow>();
           if(source.getRows()!=null&&source.getRows().size()!=0)
           {
           for (int i = (pi.getPageNow()-1)*pi.getPageShow(); i<source.getRows().size()&&i<(pi.getPageNow()*pi.getPageShow()); i++) {
        	  
				newRows.add(source.getRows().get(i));
			}
           
           if(pi.isOnlySortCurrentPage())
        	   Collections.sort(newRows,comp);
           
           MyDataTable dest=new MyDataTable();
		   dest.setRows(newRows);
		   return dest;
           }
           
		  
		return pi.getMyDataTable();
	}
	
	public MyDataTable getOraclePageList(PageInfo info)
	{
		return null;
	}
	
	public MyDataTable getSqlServerPageList(PageInfo info)
	{
		return null;
	}
	
	public MyDataTable getMySqlPageList(PageInfo info)
	{
		return null;
	}
	public static void main(String [] args) throws Exception
	{
		
		
	   //MyDataTable dt2=   new PageSort().getPageList(info);
	 
//	   for(int i=0;i<dt2.getRows().size();i++)
//		{
//			String s="";
//			for(int j=0;j<dt2.getColumnNameList().size();j++)
//			{
//				s+=dt2.getRows().get(i).getString(j)+"     ";
//			}
//			System.out.println(s);
//		}
	   
	
	}
	

}


