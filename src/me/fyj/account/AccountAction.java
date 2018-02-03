package me.fyj.account;
/*
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.util.HibernateUtil;

public class AccountAction extends ActionSupport implements IAccount {

	public void save(Account  acc)
	{
		//SessionFactory factory=new Configuration().configure().buildSessionFactory();
		//Session session=factory.openSession();  
		Session session = HibernateUtil.currentSession();  
		Transaction tran=session.beginTransaction();
		session.save(acc);
		tran.commit();
	}
	
	
	public void update(Account  acc)
	{
		Session session = HibernateUtil.currentSession();  
		Transaction tran=session.beginTransaction();
		session.update(acc);
		tran.commit();
	}
	
	public void delete(Account  acc)
	{
		Session session = HibernateUtil.currentSession();  
		Transaction tran=session.beginTransaction();
		session.delete(acc);
		
		tran.commit();
	}
	
	public static void main(String args[])
	{
		AccountAction action=new AccountAction();
		Account acc=new Account();
		acc.setAccountID("fffff");
		acc.setUrlName("hhhhhhhhhh");
		
		action.delete(acc);
	}
}*/
