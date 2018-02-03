package com.kecq.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.fyj.service.UploadServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kecq.data.CRUD;
import com.kecq.data.DbFactory;
import com.kecq.data.IDbHelper;
import com.kecq.flexigrid.Flexigrid;

public abstract class ServletAbstract extends HttpServlet {

	private static final Log log = LogFactory.getLog(ServletAbstract.class);
	/**
	 * 表名
	 * @return
	 */
	public abstract String GetTableName();
	
	/**
	 * 主键名
	 * @return
	 */
	public abstract String GetPrimaryKey();
	
	/**
	 * 用户ID字段  删除和修改会将该条件加上 并且值从session 中按字段名取,不要在request中带有该名字的参数
	 * 可以将它传1  session 值也设为1  则条件变成 where 1=1  不判断用户
	 * @return
	 */
	public abstract String GetUserIDKey();
	
	/**
	 * 返回要查询的列名
	 * @return
	 */
	public abstract String[]  GetSelectColumns();
	
	/**
	 * 开始处理前执行   如果返回true才执行  可以进行比如重复严重
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract boolean BeforeDo(HttpServletRequest request, HttpServletResponse response);
	
	public String add(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		IDbHelper db = DbFactory.GetIDbHelper(request);
		CRUD crud=new CRUD(db,this.GetTableName(),this.GetPrimaryKey(),this.GetUserIDKey());
		int result=crud.Add(request);
		if(result>0)
		{
		return "{\"code\":\"1\",\"msg\":\"添加成功\"}";
		}
		else
		{
			return "{\"code\":\""+result+"\",\"msg\":\"添加失败,错误代码 "+result+"\"}";
		}
	}
	
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		IDbHelper db = DbFactory.GetIDbHelper(request);
		Object userID=request.getSession().getAttribute(this.GetUserIDKey());
		Flexigrid grid = new Flexigrid(request);
		String str = grid.GetJson(this.GetTableName(), this.GetSelectColumns(), this.GetPrimaryKey(),this.GetUserIDKey(),userID.toString(), db);
		
		return str;
	}
	
	public String update(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		IDbHelper db = DbFactory.GetIDbHelper(request);
		CRUD crud=new CRUD(db,this.GetTableName(),this.GetPrimaryKey(),this.GetUserIDKey());
		int result=crud.Update(request);
		if(result>0)
		{
		return "{\"code\":\"1\",\"msg\":\"修改成功\"}";
		}
		else
		{
			return "{\"code\":\""+result+"\",\"msg\":\"修改失败,错误代码 "+result+"\"}";
		}
	}
	
	public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		IDbHelper db = DbFactory.GetIDbHelper(request);
		CRUD crud=new CRUD(db,this.GetTableName(),this.GetPrimaryKey(),this.GetUserIDKey());
		int result=crud.Delete(request);
		if(result>0)
		{
		return "{\"code\":\"1\",\"msg\":\"删除成功\"}";
		}
		else
		{
			return "{\"code\":\""+result+"\",\"msg\":\"删除失败,错误代码 "+result+"\"}";
		}
	}
	
	public String get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		IDbHelper db = DbFactory.GetIDbHelper(request);
		CRUD crud=new CRUD(db,this.GetTableName(),this.GetPrimaryKey(),this.GetUserIDKey());
		String str = crud.Get(request);

          return str;
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		if(!BeforeDo(request,response))
		{
			return;
		}
		
		PrintWriter out = response.getWriter();
		try {
			Object userID=request.getSession().getAttribute(this.GetUserIDKey());
			if(userID==null)
			{
				out.print("{\"code\":\"-1\",\"msg\":\"forbidden\"}");
				return;
			}
			
			if (request.getParameter("action").equals("list")) {
				out.print(list(request,response));
			}
			if (request.getParameter("action").equals("add")) {
			  out.print(add(request,response));
			}
			if (request.getParameter("action").equals("update")) {
				 out.print(update(request,response));
			}
			if (request.getParameter("action").equals("delete")) {
				 out.print(delete(request,response));
			}
			if (request.getParameter("action").equals("get")) {
				 out.print(get(request,response));
			}
			
		} catch (Exception ex) {
		 	log.info(ex);
			out.print("{\"code\":\"-1\",\"msg\":\"exception\"}");
		}
		finally
		{
			out.close();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
}
