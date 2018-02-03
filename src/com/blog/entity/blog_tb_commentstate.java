package com.blog.entity;

import java.util.Date;

public class blog_tb_commentstate  {
     /**
	 *
	 * @return
	 */
    private String stateID;

    public String getStateID() {
		return stateID;
	}

	public void setStateID(String value) {
		this.stateID = value;
	}


     /**
	 *
	 * @return
	 */
    private Integer articleID;

    public Integer getArticleID() {
		return articleID;
	}

	public void setArticleID(Integer value) {
		this.articleID = value;
	}


     /**
	 *
	 * @return
	 */
    private String typeID;

    public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String value) {
		this.typeID = value;
	}


     /**
	 *
	 * @return
	 */
    private Integer stateCount;

    public Integer getStateCount() {
		return stateCount;
	}

	public void setStateCount(Integer value) {
		this.stateCount = value;
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


