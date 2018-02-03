package com.blog.entity;

import java.util.Date;

    public  class blog_tb_Visit
    {
        private String visitID ;

        private String Domain ;

        private String siteID ;
        private String objectID ;

        private String Reffer ;

        private String visitUrl ;
        private String visitTitle ;
        private String visitIP ;
        private String userAgent ;
        private Date ADD_DATE ;
        private Date UPDATE_DATE ;
        private String SessionID ;
        private String City ;
        private String County ;
		public String getVisitID() {
			return visitID;
		}
		public void setVisitID(String visitID) {
			this.visitID = visitID;
		}
		public String getDomain() {
			return Domain;
		}
		public void setDomain(String domain) {
			Domain = domain;
		}
		public String getSiteID() {
			return siteID;
		}
		public void setSiteID(String siteID) {
			this.siteID = siteID;
		}
		public String getObjectID() {
			return objectID;
		}
		public void setObjectID(String objectID) {
			this.objectID = objectID;
		}
		public String getReffer() {
			return Reffer;
		}
		public void setReffer(String reffer) {
			Reffer = reffer;
		}
		public String getVisitUrl() {
			return visitUrl;
		}
		public void setVisitUrl(String visitUrl) {
			this.visitUrl = visitUrl;
		}
		public String getVisitTitle() {
			return visitTitle;
		}
		public void setVisitTitle(String visitTitle) {
			this.visitTitle = visitTitle;
		}
		public String getVisitIP() {
			return visitIP;
		}
		public void setVisitIP(String visitIP) {
			this.visitIP = visitIP;
		}
		public String getUserAgent() {
			return userAgent;
		}
		public void setUserAgent(String userAgent) {
			this.userAgent = userAgent;
		}
		public Date getADD_DATE() {
			return ADD_DATE;
		}
		public void setADD_DATE(Date aDD_DATE) {
			ADD_DATE = aDD_DATE;
		}
		public Date getUPDATE_DATE() {
			return UPDATE_DATE;
		}
		public void setUPDATE_DATE(Date uPDATE_DATE) {
			UPDATE_DATE = uPDATE_DATE;
		}
		public String getSessionID() {
			return SessionID;
		}
		public void setSessionID(String sessionID) {
			SessionID = sessionID;
		}
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
		}
		public String getCounty() {
			return County;
		}
		public void setCounty(String county) {
			County = county;
		}
    }

