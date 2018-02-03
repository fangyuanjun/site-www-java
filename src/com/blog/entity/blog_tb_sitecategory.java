package com.blog.entity;

import java.util.Date;

public class blog_tb_sitecategory  {
     /**
	 *
	 * @return
	 */
    private Integer ID;

    public Integer getID() {
		return ID;
	}

	public void setID(Integer value) {
		this.ID = value;
	}


     /**
	 *
	 * @return
	 */
    private Integer parentID;

    public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer value) {
		this.parentID = value;
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
    private Integer OrderWeight;

    public Integer getOrderWeight() {
		return OrderWeight;
	}

	public void setOrderWeight(Integer value) {
		this.OrderWeight = value;
	}


     /**
	 *
	 * @return
	 */
    private String Pic;

    public String getPic() {
		return Pic;
	}

	public void setPic(String value) {
		this.Pic = value;
	}


     /**
	 *
	 * @return
	 */
    private Boolean IsDisabled;

    public Boolean getIsDisabled() {
		return IsDisabled;
	}

	public void setIsDisabled(Boolean value) {
		this.IsDisabled = value;
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


