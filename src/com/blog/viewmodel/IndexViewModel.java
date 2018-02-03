package com.blog.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.blog.entity.*;
import com.blog.model.*;

public class IndexViewModel {
	/**
	 * 最新文章
	 */
	private List<ArticleModel> newArticles;

	/**
	 * 最多浏览文章
	 */
	private List<ArticleModel> mostViewArticles;

	/**
	 * 最多评论文章
	 */
	private List<ArticleModel> mostCommentArticles;

	/**
	 * 分类
	 */
	private List<CategoryModel> categorys;

	/**
	 * 标签
	 */
	private List<TagModel> tags;

	/**
	 * 文章归档
	 */
	private List<MonthModel> months;

	/**
	 * 随机10条文章
	 */
	private List<ArticleModel> randomArticles;

	/**
	 * 置顶文章
	 */
	private List<ArticleModel> topArticles;

	/**
	 * 首页大图
	 */
	private List<blog_tb_slider> sliderCollection;

	/**
	 * 首页文章
	 */
	private List<ArticleModel> indexArticles;

	private List<PagerModel> pagerCollection = new ArrayList<PagerModel>();

	/**
	 * 分页html
	 */
	private String pagerHtml;

	/**
	 * 文章的轮播图片
	 */
	private List<ArticleModel> mainArticlePics;

	public List<ArticleModel> getNewArticles() {
		return newArticles;
	}

	public void setNewArticles(List<ArticleModel> newArticles) {
		this.newArticles = newArticles;
	}

	public List<ArticleModel> getMostViewArticles() {
		return mostViewArticles;
	}

	public void setMostViewArticles(List<ArticleModel> mostViewArticles) {
		this.mostViewArticles = mostViewArticles;
	}

	public List<ArticleModel> getMostCommentArticles() {
		return mostCommentArticles;
	}

	public void setMostCommentArticles(List<ArticleModel> mostCommentArticles) {
		this.mostCommentArticles = mostCommentArticles;
	}

	public List<CategoryModel> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<CategoryModel> categorys) {
		this.categorys = categorys;
	}

	public List<TagModel> getTags() {
		return tags;
	}

	public void setTags(List<TagModel> tags) {
		this.tags = tags;
	}

	public List<MonthModel> getMonths() {
		return months;
	}

	public void setMonths(List<MonthModel> months) {
		this.months = months;
	}

	public List<ArticleModel> getRandomArticles() {
		return randomArticles;
	}

	public void setRandomArticles(List<ArticleModel> randomArticles) {
		this.randomArticles = randomArticles;
	}

	public List<ArticleModel> getTopArticles() {
		return topArticles;
	}

	public void setTopArticles(List<ArticleModel> topArticles) {
		this.topArticles = topArticles;
	}

	public List<blog_tb_slider> getSliderCollection() {
		return sliderCollection;
	}

	public void setSliderCollection(List<blog_tb_slider> sliderCollection) {
		this.sliderCollection = sliderCollection;
	}

	public List<ArticleModel> getIndexArticles() {
		return indexArticles;
	}

	public void setIndexArticles(List<ArticleModel> indexArticles) {
		this.indexArticles = indexArticles;
	}

	public List<PagerModel> getPagerCollection() {
		return pagerCollection;
	}

	public void setPagerCollection(List<PagerModel> pagerCollection) {
		this.pagerCollection = pagerCollection;
	}

	public String getPagerHtml() {
		return pagerHtml;
	}

	public void setPagerHtml(String pagerHtml) {
		this.pagerHtml = pagerHtml;
	}

	public List<ArticleModel> getMainArticlePics() {
		return mainArticlePics;
	}

	public void setMainArticlePics(List<ArticleModel> mainArticlePics) {
		this.mainArticlePics = mainArticlePics;
	}

	public blog_tb_blog getBlog() {
		return blog;
	}

	public void setBlog(blog_tb_blog blog) {
		this.blog = blog;
	}

	public int getTotalPV() {
		return totalPV;
	}

	public void setTotalPV(int totalPV) {
		this.totalPV = totalPV;
	}

	/**
	 * 博客信息
	 */
	private blog_tb_blog blog;

	/**
	 * 总访问量
	 */
	private int totalPV;
	
	/**
	 * 按条件查询结果的总文章数
	 */
	private int recordCount;

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
}
