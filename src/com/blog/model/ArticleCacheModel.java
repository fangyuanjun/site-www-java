package com.blog.model;

import java.util.Date;
    /**
     * 文章缓存实体
     * @author Administrator
     *
     */
    public class ArticleCacheModel
    {
        /**
         * 文章ID
         */
        private int articleID ;

        public int getArticleID() {
			return articleID;
		}

		public void setArticleID(int articleID) {
			this.articleID = articleID;
		}

		public String getArticleHtml() {
			return articleHtml;
		}

		public void setArticleHtml(String articleHtml) {
			this.articleHtml = articleHtml;
		}

		public Date getUpdateDate() {
			return updateDate;
		}

		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}

		/**
         * 文章Html
         */
        private String articleHtml;

        /**
         * 缓存更新时间
         */
        private Date updateDate;
    }
