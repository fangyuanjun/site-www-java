package com.blog.viewmodel;

import java.util.List;

import com.blog.entity.blog_tb_board;

public class BoardViewModel {

	private String title;

	private String keywords;

	private String description;

	/**
	 * 留言内容
	 */
	private List<blog_tb_board> collection;

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

	public List<blog_tb_board> getCollection() {
		return collection;
	}

	public void setCollection(List<blog_tb_board> collection) {
		this.collection = collection;
	}

}
