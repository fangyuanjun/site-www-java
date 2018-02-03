package com.blog.entity;

import java.util.Date;

public class blog_tb_talk  {
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
    private String TalkContent;

    public String getTalkContent() {
		return TalkContent;
	}

	public void setTalkContent(String value) {
		this.TalkContent = value;
	}


     /**
	 *
	 * @return
	 */
    private String TalkText;

    public String getTalkText() {
		return TalkText;
	}

	public void setTalkText(String value) {
		this.TalkText = value;
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
    private Date TalkDatetime;

    public Date getTalkDatetime() {
		return TalkDatetime;
	}

	public void setTalkDatetime(Date value) {
		this.TalkDatetime = value;
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
    private Boolean IsTemp;

    public Boolean getIsTemp() {
		return IsTemp;
	}

	public void setIsTemp(Boolean value) {
		this.IsTemp = value;
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


