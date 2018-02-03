package com.blog.entity;

import java.util.Date;

public class blog_tb_album  {
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
    private String UserID;

    public String getUserID() {
		return UserID;
	}

	public void setUserID(String value) {
		this.UserID = value;
	}


     /**
	 *
	 * @return
	 */
    private String Name;

    public String getName() {
		return Name;
	}

	public void setName(String value) {
		this.Name = value;
	}


     /**
	 *
	 * @return
	 */
    private String Display;

    public String getDisplay() {
		return Display;
	}

	public void setDisplay(String value) {
		this.Display = value;
	}


     /**
	 *
	 * @return
	 */
    private String CoverUrl;

    public String getCoverUrl() {
		return CoverUrl;
	}

	public void setCoverUrl(String value) {
		this.CoverUrl = value;
	}


     /**
	 *
	 * @return
	 */
    private Integer Permission;

    public Integer getPermission() {
		return Permission;
	}

	public void setPermission(Integer value) {
		this.Permission = value;
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


