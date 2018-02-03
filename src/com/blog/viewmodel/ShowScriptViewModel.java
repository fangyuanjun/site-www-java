package com.blog.viewmodel;

import com.blog.common.Config;

public class ShowScriptViewModel {
	private String articleID;

	public String getPassportRootUrl() {

		return Config.getPassportRootUrl();
	}

	public String getArticleID() {
		return articleID;
	}

	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}
}
