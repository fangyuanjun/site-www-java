package com.blog.entity;

import java.util.Date;
    
    public  class blog_tb_VisitCount
    {
        private String ID ;
        private String SiteID ;
        private String Domain ;
        private int UV ;
        private int PV ;
        private int IP ;
        private int AddUV ;
        private int AddPV ;
        public String getID() {
			return ID;
		}
		public void setID(String iD) {
			ID = iD;
		}
		public String getSiteID() {
			return SiteID;
		}
		public void setSiteID(String siteID) {
			SiteID = siteID;
		}
		public String getDomain() {
			return Domain;
		}
		public void setDomain(String domain) {
			Domain = domain;
		}
		public int getUV() {
			return UV;
		}
		public void setUV(int uV) {
			UV = uV;
		}
		public int getPV() {
			return PV;
		}
		public void setPV(int pV) {
			PV = pV;
		}
		public int getIP() {
			return IP;
		}
		public void setIP(int iP) {
			IP = iP;
		}
		public int getAddUV() {
			return AddUV;
		}
		public void setAddUV(int addUV) {
			AddUV = addUV;
		}
		public int getAddPV() {
			return AddPV;
		}
		public void setAddPV(int addPV) {
			AddPV = addPV;
		}
		public int getAddIP() {
			return AddIP;
		}
		public void setAddIP(int addIP) {
			AddIP = addIP;
		}
		public Date getCountDate() {
			return CountDate;
		}
		public void setCountDate(Date countDate) {
			CountDate = countDate;
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
		private int AddIP ;
        private Date CountDate ;
        private Date ADD_DATE ;
        private Date UPDATE_DATE ;
    }

