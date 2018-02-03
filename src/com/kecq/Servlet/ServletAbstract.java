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
	 * ����
	 * @return
	 */
	public abstract String GetTableName();
	
	/**
	 * ������
	 * @return
	 */
	public abstract String GetPrimaryKey();
	
	/**
	 * �û�ID�ֶ�  ɾ�����޸ĻὫ���������� ����ֵ��session �а��ֶ���ȡ,��Ҫ��request�д��и����ֵĲ���
	 * ���Խ�����1  session ֵҲ��Ϊ1  ��������� where 1=1  ���ж��û�
	 * @return
	 */
	public abstract String GetUserIDKey();
	
	/**
	 * ����Ҫ��ѯ������
	 * @return
	 */
	public abstract String[]  GetSelectColumns();
	
	/**
	 * ��ʼ����ǰִ��   �������true��ִ��  ���Խ��б����ظ�����
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
		return "{\"code\":\"1\",\"msg\":\"��ӳɹ�\"}";
		}
		else
		{
			return "{\"code\":\""+result+"\",\"msg\":\"���ʧ��,������� "+result+"\"}";
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
		return "{\"code\":\"1\",\"msg\":\"�޸ĳɹ�\"}";
		}
		else
		{
			return "{\"code\":\""+result+"\",\"msg\":\"�޸�ʧ��,������� "+result+"\"}";
		}
	}
	
	public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		IDbHelper db = DbFactory.GetIDbHelper(request);
		CRUD crud=new CRUD(db,this.GetTableName(),this.GetPrimaryKey(),this.GetUserIDKey());
		int result=crud.Delete(request);
		if(result>0)
		{
		return "{\"code\":\"1\",\"msg\":\"ɾ���ɹ�\"}";
		}
		else
		{
			return "{\"code\":\""+result+"\",\"msg\":\"ɾ��ʧ��,������� "+result+"\"}";
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
