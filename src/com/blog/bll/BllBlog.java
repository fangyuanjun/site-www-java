package com.blog.bll;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.dal.DalBlog;
import com.blog.entity.blog_tb_blog;
import com.blog.ibll.IBllBlog;
import com.blog.idal.IDalBlog;
import com.blog.model.Pager;
import com.blog.viewmodel.BaseViewModel;
import com.blog.viewmodel.IndexViewModel;
import com.blog.viewmodel.SitemapViewModel;

public class BllBlog  implements IBllBlog{
	
	 
	private IDalBlog dal;
	public void setDal(IDalBlog dal)
	{
		this.dal=dal;
	}
	
	@Override
	public blog_tb_blog getBlog(String id) throws Exception {
		// TODO Auto-generated method stub
		return dal.getBlog(id);
	}

	
	@Override
	public blog_tb_blog getFirstEntity() throws Exception {
		// TODO Auto-generated method stub
		return dal.getFirstEntity();
	}

	@Override
	public blog_tb_blog getSingleBlogByUserID() throws Exception {
		// TODO Auto-generated method stub
		return dal.getSingleBlogByUserID();
	}

	@Override
	public blog_tb_blog getSingleBlogByDomain(String domain) throws Exception {
		// TODO Auto-generated method stub
		return dal.getSingleBlogByDomain(domain);
	}

	@Override
	public BaseViewModel getBlogViewModel(String blogID) throws Exception {
		// TODO Auto-generated method stub
		return dal.getBlogViewModel(blogID);
	}

	@Override
	public IndexViewModel getArticlePage(String blogID, int page, int pageSize,
			String categoryID, String tagID, int year, int month)
			throws Exception {
		// TODO Auto-generated method stub
		IndexViewModel model=dal.getIndexViewModel(blogID);
		
		IndexViewModel model2= dal.getArticlePage(blogID,page,pageSize,categoryID,tagID,year,month);
		
		model.setTopArticles(model2.getTopArticles());
		model.setIndexArticles(model2.getIndexArticles());
		model.setRecordCount(model2.getRecordCount());
		
		return model;
	}

	@Override
	public SitemapViewModel GetSitemap(String blogID) throws Exception {
		// TODO Auto-generated method stub
		return dal.GetSitemap(blogID);
	}
}
