package com.blog.model;

/**
 * 文章档案模型
 * @author Administrator
 *
 */
public class MonthModel {

	/**
	 * 拥有的文章总数
	 */
	private int articleCount;

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public String getYyyy() {
		return yyyy;
	}

	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}

	public String getMm() {
		return mm;
	}

	public void setMm(String mm) {
		this.mm = mm;
	}


	private String url;

	public String getUrl() {
		if (url != null && !url.equals("")) {
			return url;
		}

		if (basePath != null && !basePath.equals("")) {
			return basePath + "/month-" + yyyy + mm + "-1.html";
		}

		return "/month-" + yyyy + mm + "-1.html";
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String yyyy;
	private String mm;

	public String getTitle() {
		return yyyy + "年" + mm + "月 (" + articleCount + ")";
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}


	private String basePath;
}
