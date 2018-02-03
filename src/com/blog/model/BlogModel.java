package com.blog.model;

import java.util.Date;

    public class BlogModel
    {
        private int blogID ;
        private String blogName ;
        private String userID ;
        private String blogTitle ;
        private String blogLogo ;
        private String blogDomain;
        private String blogNotice ;
        private String blogKeywords ;
        private String blogDescription ;
        private Date blogAddDatetime ;
        private String themeID ;
        private boolean blogIsDisabled ;
        private int blogOrder ;
        private String cnBlogsStyleID;
        private String cnBlogsCss;
 
        private String Url ;

		public int getBlogID() {
			return blogID;
		}

		public void setBlogID(int blogID) {
			this.blogID = blogID;
		}

		public String getBlogName() {
			return blogName;
		}

		public void setBlogName(String blogName) {
			this.blogName = blogName;
		}

		public String getUserID() {
			return userID;
		}

		public void setUserID(String userID) {
			this.userID = userID;
		}

		public String getBlogTitle() {
			return blogTitle;
		}

		public void setBlogTitle(String blogTitle) {
			this.blogTitle = blogTitle;
		}

		public String getBlogLogo() {
			return blogLogo;
		}

		public void setBlogLogo(String blogLogo) {
			this.blogLogo = blogLogo;
		}

		public String getBlogDomain() {
			return blogDomain;
		}

		public void setBlogDomain(String blogDomain) {
			this.blogDomain = blogDomain;
		}

		public String getBlogNotice() {
			return blogNotice;
		}

		public void setBlogNotice(String blogNotice) {
			this.blogNotice = blogNotice;
		}

		public String getBlogKeywords() {
			return blogKeywords;
		}

		public void setBlogKeywords(String blogKeywords) {
			this.blogKeywords = blogKeywords;
		}

		public String getBlogDescription() {
			return blogDescription;
		}

		public void setBlogDescription(String blogDescription) {
			this.blogDescription = blogDescription;
		}

		public Date getBlogAddDatetime() {
			return blogAddDatetime;
		}

		public void setBlogAddDatetime(Date blogAddDatetime) {
			this.blogAddDatetime = blogAddDatetime;
		}

		public String getThemeID() {
			return themeID;
		}

		public void setThemeID(String themeID) {
			this.themeID = themeID;
		}

		public boolean isBlogIsDisabled() {
			return blogIsDisabled;
		}

		public void setBlogIsDisabled(boolean blogIsDisabled) {
			this.blogIsDisabled = blogIsDisabled;
		}

		public int getBlogOrder() {
			return blogOrder;
		}

		public void setBlogOrder(int blogOrder) {
			this.blogOrder = blogOrder;
		}

		public String getCnBlogsStyleID() {
			return cnBlogsStyleID;
		}

		public void setCnBlogsStyleID(String cnBlogsStyleID) {
			this.cnBlogsStyleID = cnBlogsStyleID;
		}

		public String getCnBlogsCss() {
			return cnBlogsCss;
		}

		public void setCnBlogsCss(String cnBlogsCss) {
			this.cnBlogsCss = cnBlogsCss;
		}

		public String getUrl() {
			return Url;
		}

		public void setUrl(String url) {
			Url = url;
		}
    }
