package com.blog.idal;

import java.util.List;

import com.blog.entity.blog_tb_article;
import com.blog.entity.blog_tb_article_content;
import com.blog.model.ArticleModel;
import com.blog.viewmodel.ShowViewModel;

public interface IDalArticle {

	/**
	 * 获取文章内容页数据
	 * @param articleID
	 * @param userID
	 */
	public ShowViewModel GetArticleByID(String articleID,String userID)   throws Exception;
	
	/**
	 * 获取正文
	 * @param articleID
	 * @return
	 * @throws Exception
	 */
	 public blog_tb_article_content GetArticleContent(String articleID) throws Exception;
	 
	/**
	 * 获取单个文章信息
	 * @param articleID
	 * @return
	 */
    public blog_tb_article GetSingle(String articleID) throws Exception;
     
    
    /**
     * 文章、分类、博客是否被禁用
     * @param articleID
     * @return
     * @throws Exception
     */
     public boolean isArticleDisabled(String articleID) throws Exception;
     
     /**
      * 更新访问次数等
      * @param articleID
      * @param lastOpenIP
      * @param lastOpenUserID
      * @return
      */
     public int UpdateExtend(String articleID, String lastOpenIP, String lastOpenUserID) throws Exception;
     
     /**
      * 获取文章列表
      * @param blogID
      * @return
      * @throws Exception
      */
     public List<ArticleModel> getArticleList(String blogID) throws Exception;
}
