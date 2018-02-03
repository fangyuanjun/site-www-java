package me.fyj.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kecq.common.Encoder;
import com.kecq.data.DbFactory;
import com.kecq.data.IDbHelper;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
        response.setContentType("text/plain");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		try {
			if (request.getSession().getAttribute("valcode") == null) {
				out.print("{\"code\":\"-1\",\"msg\":\"请等待验证码生成\"}");
				return;
			}
			if (!request.getParameter("verifycode").equalsIgnoreCase(
					request.getSession().getAttribute("valcode").toString())) {
				out.print("{\"code\":\"-2\",\"msg\":\"验证码错误\"}");
				return;
			}
			String loginName = request.getParameter("loginName").toString();
			String loginPassword = request.getParameter("loginPassword").toString();
			if(loginName.equals(""))
			{
				out.print("{\"code\":\"-3\",\"msg\":\"登录名不能为空\"}");
				return;
			} 
			if(loginPassword.equals(""))
			{
				out.print("{\"code\":\"-4\",\"msg\":\"登录密码不能为空\"}");
				return;
			}
			IDbHelper db = DbFactory.GetIDbHelper(request);
			List<String> arr = new ArrayList<String>();
			arr.add(loginName);
			String userSalt = (String) db.getObject(
					"select userSalt from my_tb_user where userName = ? ", arr,
					"userSalt");

			if (userSalt == null || userSalt == "") {
				out.print("{\"code\":\"-5\",\"msg\":\"登录名不存在\"}");
				return;
			} else {
				arr.add(Encoder.getSha1String(loginPassword+userSalt));
				String userID = (String) db
						.getObject(
								"select userID from my_tb_user where userName = ?  and userPassword=?",
								arr, "userID");
				if (userID == null || userID == "") {
					out.print("{\"code\":\"-6\",\"msg\":\"登录密码错误\"}");
					return;
				} else {
					session.setAttribute("userID", userID);
					out.print("{\"code\":\"1\",\"msg\":\"登录成功\"}");
				}
			}

		} catch (Exception ex) {
			out.print("{\"code\":\"-7\",\"msg\":\"系統异常\"}");
		}
		finally
		{
			out.close();
		}
	}
}
