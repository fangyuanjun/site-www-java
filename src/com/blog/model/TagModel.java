package com.blog.model;


public class TagModel {
	private int tagID;
	private int blogID;
	private int categoryID;
	private int tagOrder;
	private String tagName;

	private String tagDisplay;

	/**
	 * 拥有的文章总数
	 */
	private int articleCount;

	private String url;

	public String getUrl() {
		if (url != null && !url.equals("")) {
			return url;
		}

		if (basePath != null && !basePath.equals("")) {
			return  basePath + "/tag-" + tagID + "-1.html";
		}

		return "/tag-" + tagID + "-1.html";
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 标签样式
	 */
	private String style;

	private String basePath;

	public int getTagID() {
		return tagID;
	}

	public void setTagID(int tagID) {
		this.tagID = tagID;
	}

	public int getBlogID() {
		return blogID;
	}

	public void setBlogID(int blogID) {
		this.blogID = blogID;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public int getTagOrder() {
		return tagOrder;
	}

	public void setTagOrder(int tagOrder) {
		this.tagOrder = tagOrder;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagDisplay() {
		return tagDisplay;
	}

	public void setTagDisplay(String tagDisplay) {
		this.tagDisplay = tagDisplay;
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}


	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
}
