package com.blog.dal;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.blog.common.XmlHelper;
import com.blog.entity.blog_tb_article;
import com.blog.entity.blog_tb_article_content;
import com.blog.entity.blog_tb_article_extend;
import com.blog.idal.IDalArticle;
import com.blog.model.*;
import com.blog.viewmodel.ShowViewModel;
import com.kecq.data.EntityHelper;
import com.kecq.data.EntityHelperG;


public class DalArticle extends DalBase implements IDalArticle {

	@Override
	public ShowViewModel GetArticleByID(String articleID, String userID)
			throws Exception {
		// TODO Auto-generated method stub

		ShowViewModel model = new ShowViewModel();
		java.sql.CallableStatement call = this.getIDbHelper()
				.getCurrentConnection()
				.prepareCall("{call blog_proc_singleArticle(?,?,?)}");
		call.setObject(1, articleID);
		call.setObject(2, "");
		call.setObject(3, userID);

		int index = 1;
		boolean hadResults = call.execute();
		ResultSet rs=null;
		while (hadResults) {
			 rs = call.getResultSet();

			if (index == 1) {
				model.setCurrentArticle(EntityHelper.getEntity(
						ArticleModel.class, rs));
			}

			if (index == 2) {

			}

			if (index == 3) {

				model.setCommentStateCollection(EntityHelper.GetEntityList(
						CommentTypeModel.class, rs));
			}

			if (index == 4) {

				model.setCommentTagCollection(EntityHelper.GetEntityList(
						CommentTagModel.class, rs));
			}

			if (index == 5) {
				model.setBeforeArticle(EntityHelper.getEntity(
						ArticleModel.class, rs));
			}

			if (index == 6) {
				model.setAfterArticle(EntityHelper.getEntity(
						ArticleModel.class, rs));
			}

			if (index == 7) {
				model.setTagCollection(EntityHelper.GetEntityList(
						TagModel.class, rs));
			}

			if (index == 8) {
				List<CommentModel> list = new ArrayList<CommentModel>();
				while (rs.next()) {
					CommentModel c = new CommentModel();
					c.setCommentID(rs.getString("commentID"));
					c.setCommentIP(rs.getString("commentIP"));
					c.setMark(rs.getString("commentIP"));
					c.setCommentContent(rs.getString("commentContent"));
					c.setCommentState(rs.getInt("commentState"));
					if (c.getCommentState() == 0) {
						c.setCommentContent2(c.getCommentContent());
					} else {
						c.setCommentContent2("评论暂时被隐藏...");
					}

					c.setADD_DATE(rs.getDate("ADD_DATE"));
					c.setAuthor("");
					list.add(c);
				}

				model.setCommentCollection(list);
				// model.setCommentCollection(EntityHelper.GetEntityList(CommentModel.class,
				// rs));
			}

			index++;

			hadResults = call.getMoreResults();
		}

		this.getIDbHelper().closeResultSet(rs);
		
		return model;
	}

	@Override
	public blog_tb_article_content GetArticleContent(String articleID)
			throws Exception {
		String sql = "select * from blog_tb_article_content where articleID=?";
		ResultSet rs = this.getIDbHelper().GetResultSet(sql, articleID);
		blog_tb_article_content obj= EntityHelper.getEntity(blog_tb_article_content.class, rs);
		
		this.getIDbHelper().closeResultSet(rs);
		return obj;
	}

	@Override
	public blog_tb_article GetSingle(String articleID) throws Exception {
		// TODO Auto-generated method stub
		EntityHelperG<blog_tb_article> h = new EntityHelperG<blog_tb_article>(
				blog_tb_article.class, "blog_tb_article", true,
				this.getIDbHelper(), "articleID");

		blog_tb_article obj= h.getEntity(articleID);
		
		return obj;
	}

	@Override
	public boolean isArticleDisabled(String articleID) throws Exception {
		// TODO Auto-generated method stub
		String sql = XmlHelper.GetXmlSql("isArticleDisabled");
		ResultSet rs = this.getIDbHelper().GetResultSet(sql, articleID);
		if (rs.next()) {
			if (rs.getBoolean("articleIsDisabled")) {
				return true;
			}

			if (rs.getBoolean("categoryIsDisabled")) {
				return true;
			}

			if (rs.getBoolean("blogIsDisabled")) {
				return true;
			}
		}

		this.getIDbHelper().closeResultSet(rs);
		return false;
	}

	@Override
	public int UpdateExtend(String articleID, String lastOpenIP,
			String lastOpenUserID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from blog_tb_article_extend where articleID=?";

		if (this.getIDbHelper().exists(sql, articleID)) {
			sql = " update blog_tb_article_extend set lastOpenDatetime=?,lastOpenIP=?,lastOpenUserID=?,UPDATE_DATE=?,articleClickTimes=ifnull(articleClickTimes,0)+1 where articleID=?";

			this.getIDbHelper().execute(sql, new Date(), lastOpenIP,
					lastOpenUserID, new Date(), articleID);
		} else {
			blog_tb_article_extend entity = new blog_tb_article_extend();
			entity.setArticleClickTimes(1);
			entity.setArticleCommentTimes(0);
			entity.setArticleID(Integer.parseInt(articleID));
			entity.setLastOpenDatetime(new Date());
			entity.setUPDATE_DATE(new Date());
			entity.setLastOpenIP(lastOpenIP);
			entity.setLastOpenUserID(lastOpenUserID);

			EntityHelperG<blog_tb_article_extend> h = new EntityHelperG<blog_tb_article_extend>(
					blog_tb_article_extend.class, "blog_tb_article_extend",
					true, this.getIDbHelper(), "articleID");

			h.insert(entity);
		}

		return 1;
	}

	@Override
	public List<ArticleModel> getArticleList(String blogID) throws Exception {
		// TODO Auto-generated method stub
		String sql = XmlHelper.GetXmlSql("getArticleList");
		ResultSet rs = this.getIDbHelper().GetResultSet(sql, blogID);
		List<ArticleModel> list = EntityHelper.GetEntityList(
				ArticleModel.class, rs);

		this.getIDbHelper().closeResultSet(rs);
		return list;
	}

}
