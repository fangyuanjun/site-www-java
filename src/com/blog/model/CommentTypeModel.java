package com.blog.model;


public class CommentTypeModel {

	/**
	 * 
	 * @return
	 */
	private String stateID;

	public String getStateID() {
		return stateID;
	}

	public void setStateID(String stateID) {
		this.stateID = stateID;
	}

	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public int getStateCount() {
		return stateCount;
	}

	public void setStateCount(int stateCount) {
		this.stateCount = stateCount;
	}

	public String getTypepicurl() {
		return typepicurl;
	}

	public void setTypepicurl(String typepicurl) {
		this.typepicurl = typepicurl;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * 
	 * @return
	 */
	private int articleID;

	/**
	 * 
	 * @return
	 */
	private String typeID;

	/**
	 * 
	 * @return
	 */
	private int stateCount;

	private String typepicurl;

	private String typeName;
}
