package com.blog.entity;

import java.util.Date;

    public  class blog_tb_IpAddress
    {
        private String id ;
        private String IP;
        private String Contry;
        private String City;
        private Date ADD_DATE ;
        private Date UPDATE_DATE ;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getIP() {
			return IP;
		}
		public void setIP(String iP) {
			IP = iP;
		}
		public String getContry() {
			return Contry;
		}
		public void setContry(String contry) {
			Contry = contry;
		}
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
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
    }

