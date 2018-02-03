package com.blog.dal;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Mybatis {

	private SqlSession session;
	
	public SqlSession getSqlSession() throws IOException
	{
		if(session==null)
		{
			 //mybatis的配置文件
	        String resource = "db.xml";
	        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
	        InputStream is = DalBlog.class.getClassLoader().getResourceAsStream(resource);
	        //构建sqlSession的工厂
	        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	        is.close();
	        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
	        //Reader reader = Resources.getResourceAsReader(resource); 
	        //构建sqlSession的工厂
	        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	        //创建能执行映射文件中sql的sqlSession
	         this.session = sessionFactory.openSession();
		}
		
        return session;
        
       
	}
	
	public Object selectOne(String statement,Object arg) throws IOException
	{
		 /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        
		SqlSession session=getSqlSession();
        Object entity = session.selectOne(statement, arg);
       
        session.close();
        
        return entity;
	}
}
