package com.blog.model;
    /// <summary>
    /// 基础控制器的附加信息   用于统计等(如获取标题)
    /// </summary>
    public class BaseControllerTagModel
    {
       /**
        * 标题
        */
        private String Title ;

        /**
         * 站点ID
         */
        private String SiteID;

        public String getTitle() {
			return Title;
		}

		public void setTitle(String title) {
			Title = title;
		}

		public String getSiteID() {
			return SiteID;
		}

		public void setSiteID(String siteID) {
			SiteID = siteID;
		}

		public String getObjectID() {
			return ObjectID;
		}

		public void setObjectID(String objectID) {
			ObjectID = objectID;
		}

		/**
         * 对象ID
         */
        private String ObjectID;
    }

