package me.fyj.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.kecq.Servlet.ServletAbstract;
import com.kecq.data.DbFactory;
import com.kecq.data.IDbHelper;
import com.kecq.flexigrid.Flexigrid;

public class AccountServlet  extends ServletAbstract{

	@Override
	public String GetTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetUserIDKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] GetSelectColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean BeforeDo(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}
	/*
	@Override
	public String GetTableName() {
		// TODO Auto-generated method stub
		return "my_tb_account";
	}

	@Override
	public String GetPrimaryKey() {
		// TODO Auto-generated method stub
		return "accountID";
	}

	@Override
	public String[] GetSelectColumns() {
		// TODO Auto-generated method stub
		  String []columns=new String[]{"accountID","urlName","url","userName","userPassword","email","tel","question","bindQQ","bindWeibo","remark","ADD_DATE","UPDATE_DATE"};
		return columns;
	}

	@Override
	public boolean BeforeDo(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String GetUserIDKey() {
		// TODO Auto-generated method stub
		return "userID";
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application=this.getServletContext();   
		WebApplicationContext  iocBeanFactory =  WebApplicationContextUtils.getWebApplicationContext(application); 
        Account acc=(Account)iocBeanFactory.getBean("Account_default");
        IAccount action = (IAccount)iocBeanFactory.getBean("AccountAction");
        action.save(acc);
	}
*/
}
