package com.blog.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ArticleModel {
	private int articleID;
	private int blogID;
	private int topicID;
	private String articleTitle;
	private String articleTitle2;
	private String articleTitleColor;
	private String articleKeywords;
	private String articleDescription;
	private String articleSource;
	private String articleAuthor;
	private String articleSourceUrl;
	private String articlePic;
	private String articleThumbPic;
	
	private Date articleDatetime;
	private String articleRedirectUrl;
	private String articleAddUserID;
	private String articleModifyUserID;
	private int articleOrder;
	private int articleClickTimes;
	private int articleCommentTimes;
	private int articleReplyCount;
	private boolean articleIsTop;
	private boolean articleIsDisabled;
	private boolean articleIsVerifyComment;
	private boolean articleIsDisableComment;
	private boolean articleIsAnonymouComment;
	private boolean articleIsIndex;
	private boolean articleIsOriginal;
	private boolean articleIsSystem;
	private boolean articleIsPic;
	private boolean articleIsDelete;
	private int attachmentLimit;
	private String articlePassword;
	private String articleUrl;
	private String articleSubContentText;
	private String articleSubContentHtml;
	private String articleContent;

	/**
	 * 隐藏内容
	 */
	private String articleHideContent;
	private int categoryID;
	private String categoryDomain;
	private String categoryUrl;
	private String basePath;
	private String categoryDisplay;


	private List<TagModel> tagCollection = new ArrayList<TagModel>();
	
	private String showDatetime;
	
	private String showDate;
	
	public void setArticleTitle2(String value) {
		articleTitle2 = value;
	}

	public String getArticleTitle2() {
		if (articleTitle2 != null && !articleTitle2.equals("")) {
			return articleTitle2;
		}

		String title = articleTitle;
		if (articleIsTop) {
			title = "[顶]" + articleTitle;
		}

		if (articleTitleColor != null && !articleTitleColor.equals("")) {
			title = "<font color='" + articleTitleColor + "'>" + title
					+ "</font>";
		}

		return title;
	}

	

	public void setArticleSource(String value) {
		articleSource = value;
	}

	public String GetArticleSource() {

		if (articleSource != null && !articleSource.equals("")) {
			if (articleIsOriginal) {
				return "本站原创";
			}
		}

		return articleSource;
	}

	

	public void setArticleSourceUrl(String value) {
		articleSourceUrl = value;
	}

	public String getArticleSourceUrl() {
		if (articleSourceUrl != null && !articleSourceUrl.equals("")) {
			return "<a href=\"" + articleSourceUrl + "\" target=\"_blank\">"
					+ articleSourceUrl + "</a>";
		}

		return articleSourceUrl;
	}

	
	public void setArticlePic(String value) {
		articlePic = value;
	}

	public String getArticlePic() {

		return articlePic;
	}

	

	public String getArticleUrl() {

		if(articleUrl==null||articleUrl.equals(""))
		{
			if (basePath != null && !basePath.equals("")) {
				return basePath + "/artic-" + articleID + ".html";
			}

			return "/artic-" + articleID + ".html";
		}
	
		return this.articleUrl;
	}

	public void setArticleUrl(String value) {
		articleUrl = value;
	}

	

	public void setCategoryUrl(String value) {
		categoryUrl = value;
	}

	public String getCategoryUrl() {

		if(categoryUrl==null||categoryUrl.equals(""))
		{
			if (categoryDomain != null && !categoryDomain.equals("")) {
				return "http://" + categoryDomain;
			}

			if (basePath != null && !basePath.equals("")) {
				return  basePath + "/cate-" + categoryID + "-1.html";
			}

			return "/cate-" + categoryID + "-1.html";
		}
		
		return this.categoryUrl;
	}

	
	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public int getBlogID() {
		return blogID;
	}

	public void setBlogID(int blogID) {
		this.blogID = blogID;
	}

	public int getTopicID() {
		return topicID;
	}

	public void setTopicID(int topicID) {
		this.topicID = topicID;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleTitleColor() {
		return articleTitleColor;
	}

	public void setArticleTitleColor(String articleTitleColor) {
		this.articleTitleColor = articleTitleColor;
	}

	public String getArticleKeywords() {
		return articleKeywords;
	}

	public void setArticleKeywords(String articleKeywords) {
		this.articleKeywords = articleKeywords;
	}

	public String getArticleDescription() {
		return articleDescription;
	}

	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}

	public String getArticleAuthor() {
		return articleAuthor;
	}

	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}

	public String getArticleThumbPic() {
		return articleThumbPic;
	}

	public void setArticleThumbPic(String articleThumbPic) {
		this.articleThumbPic = articleThumbPic;
	}


	public Date getArticleDatetime() {
		return articleDatetime;
	}

	public void setArticleDatetime(Date articleDatetime) {
		this.articleDatetime = articleDatetime;
	}

	public String getArticleRedirectUrl() {
		return articleRedirectUrl;
	}

	public void setArticleRedirectUrl(String articleRedirectUrl) {
		this.articleRedirectUrl = articleRedirectUrl;
	}

	public String getArticleAddUserID() {
		return articleAddUserID;
	}

	public void setArticleAddUserID(String articleAddUserID) {
		this.articleAddUserID = articleAddUserID;
	}

	public String getArticleModifyUserID() {
		return articleModifyUserID;
	}

	public void setArticleModifyUserID(String articleModifyUserID) {
		this.articleModifyUserID = articleModifyUserID;
	}

	public int getArticleOrder() {
		return articleOrder;
	}

	public void setArticleOrder(int articleOrder) {
		this.articleOrder = articleOrder;
	}

	public int getArticleClickTimes() {
		return articleClickTimes;
	}

	public void setArticleClickTimes(int articleClickTimes) {
		this.articleClickTimes = articleClickTimes;
	}

	public int getArticleCommentTimes() {
		return articleCommentTimes;
	}

	public void setArticleCommentTimes(int articleCommentTimes) {
		this.articleCommentTimes = articleCommentTimes;
	}

	public int getArticleReplyCount() {
		return articleReplyCount;
	}

	public void setArticleReplyCount(int articleReplyCount) {
		this.articleReplyCount = articleReplyCount;
	}

	public boolean isArticleIsTop() {
		return articleIsTop;
	}

	public void setArticleIsTop(boolean articleIsTop) {
		this.articleIsTop = articleIsTop;
	}

	public boolean isArticleIsDisabled() {
		return articleIsDisabled;
	}

	public void setArticleIsDisabled(boolean articleIsDisabled) {
		this.articleIsDisabled = articleIsDisabled;
	}

	public boolean isArticleIsVerifyComment() {
		return articleIsVerifyComment;
	}

	public void setArticleIsVerifyComment(boolean articleIsVerifyComment) {
		this.articleIsVerifyComment = articleIsVerifyComment;
	}

	public boolean isArticleIsDisableComment() {
		return articleIsDisableComment;
	}

	public void setArticleIsDisableComment(boolean articleIsDisableComment) {
		this.articleIsDisableComment = articleIsDisableComment;
	}

	public boolean isArticleIsAnonymouComment() {
		return articleIsAnonymouComment;
	}

	public void setArticleIsAnonymouComment(boolean articleIsAnonymouComment) {
		this.articleIsAnonymouComment = articleIsAnonymouComment;
	}

	public boolean isArticleIsIndex() {
		return articleIsIndex;
	}

	public void setArticleIsIndex(boolean articleIsIndex) {
		this.articleIsIndex = articleIsIndex;
	}

	public boolean isArticleIsOriginal() {
		return articleIsOriginal;
	}

	public void setArticleIsOriginal(boolean articleIsOriginal) {
		this.articleIsOriginal = articleIsOriginal;
	}

	public boolean isArticleIsSystem() {
		return articleIsSystem;
	}

	public void setArticleIsSystem(boolean articleIsSystem) {
		this.articleIsSystem = articleIsSystem;
	}

	public boolean isArticleIsPic() {
		return articleIsPic;
	}

	public void setArticleIsPic(boolean articleIsPic) {
		this.articleIsPic = articleIsPic;
	}

	public boolean isArticleIsDelete() {
		return articleIsDelete;
	}

	public void setArticleIsDelete(boolean articleIsDelete) {
		this.articleIsDelete = articleIsDelete;
	}

	public int getAttachmentLimit() {
		return attachmentLimit;
	}

	public void setAttachmentLimit(int attachmentLimit) {
		this.attachmentLimit = attachmentLimit;
	}

	public String getArticlePassword() {
		return articlePassword;
	}

	public void setArticlePassword(String articlePassword) {
		this.articlePassword = articlePassword;
	}

	public void setArticleSubContentText(String articleSubContentText) {
		this.articleSubContentText = articleSubContentText;
	}

	public String getArticleSubContentHtml() {
		 if(articleSubContentHtml==null||articleSubContentHtml.equals(""))
         {
        	return this.articleSubContentText;
         }
		 
		return articleSubContentHtml;
	}

	public void setArticleSubContentHtml(String articleSubContentHtml) {
		this.articleSubContentHtml = articleSubContentHtml;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticleHideContent() {
		return articleHideContent;
	}

	public void setArticleHideContent(String articleHideContent) {
		this.articleHideContent = articleHideContent;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryDomain() {
		return categoryDomain;
	}

	public void setCategoryDomain(String categoryDomain) {
		this.categoryDomain = categoryDomain;
	}


	public String getCategoryDisplay() {
		return categoryDisplay;
	}

	public void setCategoryDisplay(String categoryDisplay) {
		this.categoryDisplay = categoryDisplay;
	}

	public String getArticleSource() {
		return articleSource;
	}

	public void setTagCollection(List<TagModel> value) {
		tagCollection = value;
	}

	public List<TagModel> getTagCollection() {
		return tagCollection;
	}

	public String getShowDatetime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.articleDatetime);
	}
	
	public String getShowDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(this.articleDatetime);
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
}
