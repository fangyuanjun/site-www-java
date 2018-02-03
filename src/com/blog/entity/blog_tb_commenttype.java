package com.blog.entity;

import java.util.Date;

public class blog_tb_commenttype  {
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
    private String typeName;

    public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String value) {
		this.typeName = value;
	}


     /**
	 *
	 * @return
	 */
    private String typePicUrl;

    public String getTypePicUrl() {
		return typePicUrl;
	}

	public void setTypePicUrl(String value) {
		this.typePicUrl = value;
	}


     /**
	 *
	 * @return
	 */
    private int typeOrder;

    public int getTypeOrder() {
		return typeOrder;
	}

	public void setTypeOrder(int value) {
		this.typeOrder = value;
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


