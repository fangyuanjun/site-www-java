package com.kecq.flexigrid;

import it.sauronsoftware.base64.Base64;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kecq.data.IDbHelper;

public class Flexigrid {
	private int pageIndex = 1;
	private int pageSize = 20;
	private String queryName = "";
	private String queryOp = " like ";
	private String queryValue = "";
	private String sortName = "";
	private String sortOrder = "";
	private String queryColumns = "*";

	public int getpageIndex() {
		return pageIndex;
	}

	public void setpageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getpageSize() {
		return pageSize;
	}

	public void setpageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getqueryName() {
		return queryName;
	}

	public void setqueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getqueryOp() {
		return queryOp;
	}

	public void setqueryOp(String queryOp) {
		this.queryOp = queryOp;
	}

	public String getqueryValue() {
		return queryValue;
	}

	public void setqueryValue(String queryValue) {
		this.queryValue = queryValue;
	}

	public String getsortName() {
		return sortName;
	}

	public void setsortName(String sortName) {
		this.sortName = sortName;
	}

	public String getsortOrder() {
		return sortOrder;
	}

	public void setsortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getqueryColumns() {
		return queryColumns;
	}

	public void setqueryColumns(String queryColumns) {
		this.queryColumns = queryColumns;
	}


	public Flexigrid(HttpServletRequest request
			) {

		// 当前第几页
		String pageIndex = request.getParameter("page");
		// 每页多少条
		String pageSize = request.getParameter("rp");
		// 条件字段值
		String query = request.getParameter("query");
		// System.out.println("query=" + query);
		// 条件字段
		String qtype = request.getParameter("qtype");
		// 排序字段
		String sortname = request.getParameter("sortname");
		// desc or asc
		String sortorder = request.getParameter("sortorder");
		// 操作符
		String qop = request.getParameter("qop");

		if (pageIndex != null)
			this.pageIndex = Integer.parseInt(pageIndex);
		if (pageSize != null)
			this.pageSize = Integer.parseInt(pageSize);
		if (qtype != null)
			this.queryName = qtype;
		if (qop != null)
			this.queryOp = qop;
		if (query != null)
			this.queryValue = query;
		if (sortname != null)
			this.sortName = sortname;
		if (sortorder != null)
			this.sortOrder = sortorder;
	}

	public String GetJson(String tableName, String[] columns, String primaryKey,String userIDKey,String userID, IDbHelper db) throws Exception
    {
		List<String> sqlValue=new ArrayList<String>();
		String sql="select ";
		for(String col:columns)
		{
			sql+=col+",";
		}
	    sql=sql.substring(0,sql.lastIndexOf(",")); //移除最后一个,
	    sql +=" from "+tableName+"  where "+userIDKey+"='"+userID+"'  ";
	    String where="";
	    if(queryName!=null&&queryName!="")
	    {
	    	where=" and "+queryName+" "+queryOp+" '%"+queryValue+"%'";
	    	sql+=where;
	    	//sqlValue.add(queryValue);
	    }
	    if(sortName!=null&&sortName!="")
	    {
	    	sql+=" order by "+sortName+" "+sortOrder;
	    }
	    sql+=" limit "+(pageIndex-1)*pageSize+","+pageSize;
	    List<Map<String, Object>> list=db.GetListMap(sql, sqlValue);
	    
	    Object total=db.getObject("select count(*) as cc from "+tableName+" where "+userIDKey+"='"+userID+"'  "+where, null, "cc");
	    return GetJson(Integer.parseInt(total.toString()), list,columns,false,primaryKey);
    }
	
	public String GetJson(int total,List<Map<String, Object>> list, String[] columns,boolean isToBase64, String primaryKey) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"page\":\"" + pageIndex + "\",\"total\":\"" + total
				+ "\",\"rows\":[");

		for (Map<String, Object> map : list) {
			String json = "{\"id\":\"" + map.get(primaryKey) + "\",\"cell\":[";
			
			for(String col :columns)
			{
				Object value = map.get(col);
				if (isToBase64 && value != null
						&& (!value.toString().equals(""))) {
					json += "\""
							+ Base64.encode(value.toString(), "UTF-8")
							+ "\",";
				} else {
					json += "\"" + (value==null?"":value) + "\",";
				}
			}

			json = json.substring(0, json.lastIndexOf(","));
			json = json + "]},";
			sb.append(json);
		}

		String temp = sb.toString();
		 if (list.size() > 0)
         {
			temp= temp.substring(0, temp.length() - 1); //移除逗号
         }
		String result =  temp+ "]}";

		return result;
	}
}
