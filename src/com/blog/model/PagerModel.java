package com.blog.model;

public class PagerModel {

	/**
	 * 文本
	 */
    private String text ;

   /**
    * 链接
    */
    private String url ;

    /**
     * 是否当前页
     */
    private boolean isCurrent ;

    /**
     * 是否禁用
     */
    private boolean isDisabled ;

    /**
     * 是否上一页
     */
    private boolean isPrev ;

    /**
     * 是否下一页
     */
    private boolean isNext ;

   public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public boolean isCurrent() {
		return isCurrent;
	}

	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}

	public boolean isDisabled() {
		return isDisabled;
	}

	public void setDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public boolean isPrev() {
		return isPrev;
	}

	public void setPrev(boolean isPrev) {
		this.isPrev = isPrev;
	}

	public boolean isNext() {
		return isNext;
	}

	public void setNext(boolean isNext) {
		this.isNext = isNext;
	}

	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	public boolean isLast() {
		return isLast;
	}

	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}

/**
    * 是否首页
    */
    private boolean isFirst ;

    /**
     * 是否尾页
     */
    private boolean isLast ;
}
