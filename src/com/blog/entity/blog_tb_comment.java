package com.blog.entity;

import java.util.Date;

public class blog_tb_comment  {
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
    private String parentID;

    public String getParentID() {
		return parentID;
	}

	public void setParentID(String value) {
		this.parentID = value;
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
    private String userName;

    public String getUserName() {
		return userName;
	}

	public void setUserName(String value) {
		this.userName = value;
	}


     /**
	 *
	 * @return
	 */
    private String commentIP;

    public String getCommentIP() {
		return commentIP;
	}

	public void setCommentIP(String value) {
		this.commentIP = value;
	}


     /**
	 *
	 * @return
	 */
    private String commentCountry;

    public String getCommentCountry() {
		return commentCountry;
	}

	public void setCommentCountry(String value) {
		this.commentCountry = value;
	}


     /**
	 *
	 * @return
	 */
    private String commentCity;

    public String getCommentCity() {
		return commentCity;
	}

	public void setCommentCity(String value) {
		this.commentCity = value;
	}


     /**
	 *
	 * @return
	 */
    private String commentContent;

    public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String value) {
		this.commentContent = value;
	}


     /**
	 *
	 * @return
	 */
    private String commentText;

    public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String value) {
		this.commentText = value;
	}


     /**
	 *
	 * @return
	 */
    private int commentState;

    public int getCommentState() {
		return commentState;
	}

	public void setCommentState(int value) {
		this.commentState = value;
	}


     /**
	 *
	 * @return
	 */
    private int floor;

    public int getFloor() {
		return floor;
	}

	public void setFloor(int value) {
		this.floor = value;
	}


     /**
	 *
	 * @return
	 */
    private int supportCount;

    public int getSupportCount() {
		return supportCount;
	}

	public void setSupportCount(int value) {
		this.supportCount = value;
	}


     /**
	 *
	 * @return
	 */
    private int againstCount;

    public int getAgainstCount() {
		return againstCount;
	}

	public void setAgainstCount(int value) {
		this.againstCount = value;
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


