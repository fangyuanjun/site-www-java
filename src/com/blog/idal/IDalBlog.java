package com.blog.idal;

import com.blog.entity.blog_tb_blog;
import com.blog.viewmodel.BaseViewModel;
import com.blog.viewmodel.IndexViewModel;
import com.blog.viewmodel.SitemapViewModel;

public interface IDalBlog {

	public blog_tb_blog getBlog(String id) throws Exception;
	
	
	/**
	 * 获取数据库第一条博客
	 * @return
	 */
    public blog_tb_blog getFirstEntity() throws Exception;
    
    /**
     * 获取用户的一个博客  (第一个)
     * @return
     */
    public blog_tb_blog getSingleBlogByUserID() throws Exception;
    
    /**
     * 根据域名获取博客信息  
     * @param domain
     * @return
     */
    public blog_tb_blog getSingleBlogByDomain(String domain) throws Exception;
    
    /**
     * 获取博客主页数据
     * @param blogID
     * @return
     * @throws Exception
     */
    public BaseViewModel getBlogViewModel(String blogID)   throws Exception;
    
    /**
     * 获取主页数据
     * @param blogID
     * @return
     * @throws Exception
     */
    public IndexViewModel getIndexViewModel(String blogID)  throws Exception;
    
    /**
     * 获取个人博客首页的置顶文章和文章预览列表 
     * @param blogID
     * @param page
     * @param pageSize
     * @param categoryID
     * @param tagID
     * @param year
     * @param month
     * @return
     * @throws Exception
     */
    public  IndexViewModel   getArticlePage(String blogID, int page, int pageSize, String categoryID , String tagID , int year, int month) throws Exception;
    
    /**
     * 查询站点地图
     * @param blogID
     * @return
     * @throws Exception
     */
    public SitemapViewModel GetSitemap(String blogID) throws Exception;
}
