package com.blog.viewmodel;

import java.util.List;

import com.blog.entity.blog_tb_photo;
    public class PhotoShowViewModel
    {
        /**
        * 标题
        */
        private String title;

        /**
         * 当前大图
         */
        private String currentUrl ;

        /**
         * 当前缩略图
         */
        private String currentThumbUrl;

       /**
        * 图片列表
        */
        private List<blog_tb_photo> photoCollection;

        /**
         * 关键字
         */
        private String keywords ;

        /**
         * 描述
         */
        private String description ;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getCurrentUrl() {
			return currentUrl;
		}

		public void setCurrentUrl(String currentUrl) {
			this.currentUrl = currentUrl;
		}

		public String getCurrentThumbUrl() {
			return currentThumbUrl;
		}

		public void setCurrentThumbUrl(String currentThumbUrl) {
			this.currentThumbUrl = currentThumbUrl;
		}

		public List<blog_tb_photo> getPhotoCollection() {
			return photoCollection;
		}

		public void setPhotoCollection(List<blog_tb_photo> photoCollection) {
			this.photoCollection = photoCollection;
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
    }
