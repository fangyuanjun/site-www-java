package com.blog.entity;

import java.util.Date;

public class blog_tb_category  {
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
    private String categoryName;

    public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String value) {
		this.categoryName = value;
	}


     /**
	 *
	 * @return
	 */
    private String categoryDisplay;

    public String getCategoryDisplay() {
		return categoryDisplay;
	}

	public void setCategoryDisplay(String value) {
		this.categoryDisplay = value;
	}


     /**
	 *
	 * @return
	 */
    private Integer categoryOrderWeight;

    public Integer getCategoryOrderWeight() {
		return categoryOrderWeight;
	}

	public void setCategoryOrderWeight(Integer value) {
		this.categoryOrderWeight = value;
	}


     /**
	 *
	 * @return
	 */
    private String categoryPic;

    public String getCategoryPic() {
		return categoryPic;
	}

	public void setCategoryPic(String value) {
		this.categoryPic = value;
	}


     /**
	 *
	 * @return
	 */
    private String categoryKeywords;

    public String getCategoryKeywords() {
		return categoryKeywords;
	}

	public void setCategoryKeywords(String value) {
		this.categoryKeywords = value;
	}


     /**
	 *
	 * @return
	 */
    private String categoryDescription;

    public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String value) {
		this.categoryDescription = value;
	}


     /**
	 *
	 * @return
	 */
    private String categoryDomain;

    public String getCategoryDomain() {
		return categoryDomain;
	}

	public void setCategoryDomain(String value) {
		this.categoryDomain = value;
	}


     /**
	 *
	 * @return
	 */
    private Boolean categoryIsDisabled;

    public Boolean getCategoryIsDisabled() {
		return categoryIsDisabled;
	}

	public void setCategoryIsDisabled(Boolean value) {
		this.categoryIsDisabled = value;
	}


     /**
	 *
	 * @return
	 */
    private Boolean categoryIsSystem;

    public Boolean getCategoryIsSystem() {
		return categoryIsSystem;
	}

	public void setCategoryIsSystem(Boolean value) {
		this.categoryIsSystem = value;
	}


     /**
	 *
	 * @return
	 */
    private String themeID;

    public String getThemeID() {
		return themeID;
	}

	public void setThemeID(String value) {
		this.themeID = value;
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


