package com.blog.entity;

import java.util.Date;

public class blog_tb_tagarticle  {
     /**
	 *
	 * @return
	 */
    private String tagarticleID;

    public String getTagarticleID() {
		return tagarticleID;
	}

	public void setTagarticleID(String value) {
		this.tagarticleID = value;
	}


     /**
	 *
	 * @return
	 */
    private Integer tagID;

    public Integer getTagID() {
		return tagID;
	}

	public void setTagID(Integer value) {
		this.tagID = value;
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


