package com.blog.entity;

import java.util.Date;

public class blog_tb_blog_count  {
     /**
	 *
	 * @return
	 */
    private String ID;

    public String getID() {
		return ID;
	}

	public void setID(String value) {
		this.ID = value;
	}


     /**
	 *
	 * @return
	 */
    private Integer BlogID;

    public Integer getBlogID() {
		return BlogID;
	}

	public void setBlogID(Integer value) {
		this.BlogID = value;
	}


     /**
	 *
	 * @return
	 */
    private Integer PV;

    public Integer getPV() {
		return PV;
	}

	public void setPV(Integer value) {
		this.PV = value;
	}


     /**
	 *
	 * @return
	 */
    private Integer AddPV;

    public Integer getAddPV() {
		return AddPV;
	}

	public void setAddPV(Integer value) {
		this.AddPV = value;
	}


     /**
	 *
	 * @return
	 */
    private Date ADD_DATE;

    public Date getADD_DATE() {
		return ADD_DATE;
	}

	public void setADD_DATE(Date value) {
		this.ADD_DATE = value;
	}


     /**
	 *
	 * @return
	 */
    private Date UPDATE_DATE;

    public Date getUPDATE_DATE() {
		return UPDATE_DATE;
	}

	public void setUPDATE_DATE(Date value) {
		this.UPDATE_DATE = value;
	}



}


