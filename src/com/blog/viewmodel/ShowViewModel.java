package com.blog.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.blog.model.*;

public class ShowViewModel {

	private ArticleModel CurrentArticle;

	private List<CommentTypeModel> commentStateCollection;

	private List<CommentTagModel> commentTagCollection;

	private List<CommentModel> commentCollection = new ArrayList<CommentModel>();

	/**
	 * 附件
	 */
	private List<AttachmentModel> attachmentCollection;
	private String categoryUrl;
	private String categoryDisplay;
	private List<TagModel> tagCollection = new ArrayList<TagModel>();
	private String commentPagerHtml;

	/**
	 * 申明
	 */
	private String shenming;

	/**
	 * 上一篇
	 */
	private ArticleModel beforeArticle;

	/**
	 * 下一篇
	 */
	private ArticleModel afterArticle;

	public void setCommentCollection(List<CommentModel> value) {
		this.commentCollection = value;
	}

	public List<CommentModel> getCommentCollection() {
		return commentCollection;
	}

	public ArticleModel getCurrentArticle() {
		return CurrentArticle;
	}

	public void setCurrentArticle(ArticleModel currentArticle) {
		CurrentArticle = currentArticle;
	}

	public List<CommentTypeModel> getCommentStateCollection() {
		return commentStateCollection;
	}

	public void setCommentStateCollection(
			List<CommentTypeModel> commentStateCollection) {
		this.commentStateCollection = commentStateCollection;
	}

	public List<CommentTagModel> getCommentTagCollection() {
		return commentTagCollection;
	}

	public void setCommentTagCollection(
			List<CommentTagModel> commentTagCollection) {
		this.commentTagCollection = commentTagCollection;
	}

	public String getCommentPagerHtml() {
		return commentPagerHtml;
	}

	public void setCommentPagerHtml(String commentPagerHtml) {
		this.commentPagerHtml = commentPagerHtml;
	}

	public String getShenming() {
		return shenming;
	}

	public void setShenming(String shenming) {
		this.shenming = shenming;
	}

	public List<AttachmentModel> getAttachmentCollection() {
		return attachmentCollection;
	}

	public void setAttachmentCollection(
			List<AttachmentModel> attachmentCollection) {
		this.attachmentCollection = attachmentCollection;
	}

	public String getCategoryUrl() {
		return categoryUrl;
	}

	public void setCategoryUrl(String categoryUrl) {
		this.categoryUrl = categoryUrl;
	}

	public String getCategoryDisplay() {
		return categoryDisplay;
	}

	public void setCategoryDisplay(String categoryDisplay) {
		this.categoryDisplay = categoryDisplay;
	}

	public ArticleModel getBeforeArticle() {
		return beforeArticle;
	}

	public void setBeforeArticle(ArticleModel beforeArticle) {
		this.beforeArticle = beforeArticle;
	}

	public ArticleModel getAfterArticle() {
		return afterArticle;
	}

	public void setAfterArticle(ArticleModel afterArticle) {
		this.afterArticle = afterArticle;
	}

	public List<TagModel> getTagCollection() {
		return tagCollection;
	}

	public void setTagCollection(List<TagModel> tagCollection) {
		this.tagCollection = tagCollection;
	}
}
