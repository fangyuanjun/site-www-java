package com.blog.entity;

import java.util.Date;

public class blog_tb_commentsupport  {
     /**
	 *
	 * @return
	 */
    private String supportID;

    public String getSupportID() {
		return supportID;
	}

	public void setSupportID(String value) {
		this.supportID = value;
	}


     /**
	 *
	 * @return
	 */
    private String commentID;

    public String getCommentID() {
		return commentID;
	}

	public void setCommentID(String value) {
		this.commentID = value;
	}


     /**
	 *
	 * @return
	 */
    private String userID;

    public String getUserID() {
		return userID;
	}

	public void setUserID(String value) {
		this.userID = value;
	}


     /**
	 *
	 * @return
	 */
    private String supportIP;

    public String getSupportIP() {
		return supportIP;
	}

	public void setSupportIP(String value) {
		this.supportIP = value;
	}


     /**
	 *
	 * @return
	 */
    private Date supportDatetime;

    public Date getSupportDatetime() {
		return supportDatetime;
	}

	public void setSupportDatetime(Date value) {
		this.supportDatetime = value;
	}


     /**
	 *
	 * @return
	 */
    private Boolean isSupport;

    public Boolean getIsSupport() {
		return isSupport;
	}

	public void setIsSupport(Boolean value) {
		this.isSupport = value;
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


