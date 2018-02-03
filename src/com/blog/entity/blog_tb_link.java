package com.blog.entity;

import java.util.Date;

public class blog_tb_link  {
     /**
	 *
	 * @return
	 */
    private String linkID;

    public String getLinkID() {
		return linkID;
	}

	public void setLinkID(String value) {
		this.linkID = value;
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
    private String linkName;

    public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String value) {
		this.linkName = value;
	}


     /**
	 *
	 * @return
	 */
    private String linkUrl;

    public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String value) {
		this.linkUrl = value;
	}


     /**
	 *
	 * @return
	 */
    private String linkPic;

    public String getLinkPic() {
		return linkPic;
	}

	public void setLinkPic(String value) {
		this.linkPic = value;
	}


     /**
	 *
	 * @return
	 */
    private Integer linkOrder;

    public Integer getLinkOrder() {
		return linkOrder;
	}

	public void setLinkOrder(Integer value) {
		this.linkOrder = value;
	}


     /**
	 *
	 * @return
	 */
    private Boolean linkIsDisabled;

    public Boolean getLinkIsDisabled() {
		return linkIsDisabled;
	}

	public void setLinkIsDisabled(Boolean value) {
		this.linkIsDisabled = value;
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


