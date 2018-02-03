package com.blog.entity;

import java.util.Date;

public class blog_tb_topic  {
     /**
	 *
	 * @return
	 */
    private Integer topicID;

    public Integer getTopicID() {
		return topicID;
	}

	public void setTopicID(Integer value) {
		this.topicID = value;
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
    private String topicName;

    public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String value) {
		this.topicName = value;
	}


     /**
	 *
	 * @return
	 */
    private String topicDisplay;

    public String getTopicDisplay() {
		return topicDisplay;
	}

	public void setTopicDisplay(String value) {
		this.topicDisplay = value;
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


