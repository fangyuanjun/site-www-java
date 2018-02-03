package com.blog.bll;

import java.util.List;

import com.blog.entity.blog_tb_article;
import com.blog.entity.blog_tb_article_content;
import com.blog.ibll.IBllArticle;
import com.blog.idal.IDalArticle;
import com.blog.model.ArticleModel;
import com.blog.viewmodel.ShowViewModel;

public class BllArticle  implements IBllArticle{

	private IDalArticle dal;
	public void setDal(IDalArticle dal)
	{
		this.dal=dal;
	}
	
	@Override
	public ShowViewModel GetArticleByID(String articleID, String userID)
			throws Exception {
		// TODO Auto-generated method stub
		ShowViewModel model=dal.GetArticleByID(articleID, userID);
		
		blog_tb_article_content content=dal.GetArticleContent(articleID);
		if(content!=null)
		{
			model.getCurrentArticle().setArticleContent(content.getArticleContent());
		}
		
		return model;
	}

	@Override
	public blog_tb_article GetSingle(String articleID) throws Exception {
		// TODO Auto-generated method stub
		return dal.GetSingle(articleID);
	}

	@Override
	public boolean isArticleDisabled(String articleID) throws Exception {
		// TODO Auto-generated method stub
		return dal.isArticleDisabled(articleID);
	}

	@Override
	public int UpdateExtend(String articleID, String lastOpenIP,
			String lastOpenUserID) throws Exception {
		// TODO Auto-generated method stub
		return dal.UpdateExtend(articleID,lastOpenIP,lastOpenUserID);
	}

	@Override
	public List<ArticleModel> getArticleList(String blogID) throws Exception {
		// TODO Auto-generated method stub
		return dal.getArticleList(blogID);
	}

	
}
