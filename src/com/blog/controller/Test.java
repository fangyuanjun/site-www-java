package com.blog.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.blog.common.ObjectHelper;
import com.blog.dal.DalBlog;
import com.blog.entity.blog_tb_article;
import com.blog.entity.blog_tb_blog;
import com.blog.idal.IDalBlog;
import com.blog.model.BlogModel;

public class Test {

	public static void main(String[] args) throws Exception {
		
		 DalBlog dal=new DalBlog();
		 blog_tb_blog src= dal.getBlog("222");
		 BlogModel dest=new BlogModel();
		 ObjectHelper.Copy(src, dest);
		 System.out.print(dest.getBlogDomain());

    }

	
	private static void Method1() throws Exception
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
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        //String statement = "com.blog.mapping.blogMapper.getBlog";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        //blog_tb_blog entity = session.selectOne(statement, 10000001);
        //System.out.println(entity);
       
      
        
        IDalBlog dal=session.getMapper(IDalBlog.class);
       
        blog_tb_blog entity=dal.getBlog("10000001");
        System.out.println(entity);
        session.close();
	}
	
	
	private static void Method2() throws Exception
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
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.blog.mapping.blogMapper.getBlog";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        blog_tb_blog entity = session.selectOne(statement, 10000001);
        System.out.println(entity);
        session.close();
        
        
       
        
	}
}
