package com.blog.entity;

import java.util.Date;

public class blog_tb_article_file  {
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
    private int ArticleID;

    public int getArticleID() {
		return ArticleID;
	}

	public void setArticleID(int value) {
		this.ArticleID = value;
	}


     /**
	 *
	 * @return
	 */
    private String FileName;

    public String getFileName() {
		return FileName;
	}

	public void setFileName(String value) {
		this.FileName = value;
	}


     /**
	 *
	 * @return
	 */
    private String ThumbUrl;

    public String getThumbUrl() {
		return ThumbUrl;
	}

	public void setThumbUrl(String value) {
		this.ThumbUrl = value;
	}


     /**
	 *
	 * @return
	 */
    private String Url;

    public String getUrl() {
		return Url;
	}

	public void setUrl(String value) {
		this.Url = value;
	}


     /**
	 *
	 * @return
	 */
    private Boolean IsImage;

    public Boolean getIsImage() {
		return IsImage;
	}

	public void setIsImage(Boolean value) {
		this.IsImage = value;
	}


     /**
	 *
	 * @return
	 */
    private Long Size;

    public Long getSize() {
		return Size;
	}

	public void setSize(Long value) {
		this.Size = value;
	}


     /**
	 *
	 * @return
	 */
    private String Tag;

    public String getTag() {
		return Tag;
	}

	public void setTag(String value) {
		this.Tag = value;
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


