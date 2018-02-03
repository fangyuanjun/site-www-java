package com.blog.viewmodel;

import java.util.List;

import com.blog.model.*;

public class CommentViewModel {
	/**
	 * 标题
	 */
	private String title;

	/**
	 * 关键字
	 */
	private String keywords;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 评论列表
	 */
	private List<CommentModel> collection;

	/**
	 * 分页html
	 */
	private String commentPagerHtml;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CommentModel> getCollection() {
		return collection;
	}

	public void setCollection(List<CommentModel> collection) {
		this.collection = collection;
	}

	public String getCommentPagerHtml() {
		return commentPagerHtml;
	}

	public void setCommentPagerHtml(String commentPagerHtml) {
		this.commentPagerHtml = commentPagerHtml;
	}

	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public List<CommentTypeModel> getCommentStateCollection() {
		return CommentStateCollection;
	}

	public void setCommentStateCollection(
			List<CommentTypeModel> commentStateCollection) {
		CommentStateCollection = commentStateCollection;
	}

	public List<CommentTagModel> getCommentTagCollection() {
		return CommentTagCollection;
	}

	public void setCommentTagCollection(List<CommentTagModel> commentTagCollection) {
		CommentTagCollection = commentTagCollection;
	}

	/**
	 * 文章ID
	 */
	private int articleID;

	private List<CommentTypeModel> CommentStateCollection;

	private List<CommentTagModel> CommentTagCollection;
}
