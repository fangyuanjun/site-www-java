package com.blog.entity;

import java.util.Date;

public class blog_tb_tag  {
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
    private Integer blogID;

    public Integer getBlogID() {
		return blogID;
	}

	public void setBlogID(Integer value) {
		this.blogID = value;
	}


     /**
	 *
	 * @return
	 */
    private Integer categoryID;

    public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer value) {
		this.categoryID = value;
	}


     /**
	 *
	 * @return
	 */
    private Integer tagOrder;

    public Integer getTagOrder() {
		return tagOrder;
	}

	public void setTagOrder(Integer value) {
		this.tagOrder = value;
	}


     /**
	 *
	 * @return
	 */
    private String tagName;

    public String getTagName() {
		return tagName;
	}

	public void setTagName(String value) {
		this.tagName = value;
	}


     /**
	 *
	 * @return
	 */
    private String tagDisplay;

    public String getTagDisplay() {
		return tagDisplay;
	}

	public void setTagDisplay(String value) {
		this.tagDisplay = value;
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


