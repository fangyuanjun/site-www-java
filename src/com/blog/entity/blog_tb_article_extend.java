package com.blog.entity;

import java.util.Date;

public class blog_tb_article_extend  {
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
    private Date lastOpenDatetime;

    public Date getLastOpenDatetime() {
		return lastOpenDatetime;
	}

	public void setLastOpenDatetime(Date value) {
		this.lastOpenDatetime = value;
	}


     /**
	 *
	 * @return
	 */
    private String lastOpenIP;

    public String getLastOpenIP() {
		return lastOpenIP;
	}

	public void setLastOpenIP(String value) {
		this.lastOpenIP = value;
	}


     /**
	 *
	 * @return
	 */
    private String lastOpenUserID;

    public String getLastOpenUserID() {
		return lastOpenUserID;
	}

	public void setLastOpenUserID(String value) {
		this.lastOpenUserID = value;
	}


     /**
	 *
	 * @return
	 */
    private int articleClickTimes;

    public int getArticleClickTimes() {
		return articleClickTimes;
	}

	public void setArticleClickTimes(int value) {
		this.articleClickTimes = value;
	}


     /**
	 *
	 * @return
	 */
    private Integer articleCommentTimes;

    public Integer getArticleCommentTimes() {
		return articleCommentTimes;
	}

	public void setArticleCommentTimes(Integer value) {
		this.articleCommentTimes = value;
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


