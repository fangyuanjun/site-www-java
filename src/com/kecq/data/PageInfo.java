package com.kecq.data;



public class PageInfo {

	/** 排序  0表示降序  大于0表示升序   默认降序*/
	private int order;
	/** 排序的列名  */
	private String sortColumnName;
	/** 排序的列序号  从0开始    因为可能对列序列为0的进行排序   -1 表示没有输入列序号*/
	private int sortColumnIndex=-1;
	/** 当前页   从1开始     默认为1*/
	private int pageNow=1;
	/** 每页显示的条数   默认10条*/
	private int pageShow=10;
	/** 是否仅对当前页数据进行排序  默认全部数据排序 */
	private boolean isOnlySortCurrentPage=false;
	/** sql语句  */
	private String sql;
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	/** 排序的数据  */
	private MyDataTable MyDataTable;
    public String getSortColumnName() {
		return sortColumnName;
	}
	public void setSortColumnName(String sortColumnName) {
		this.sortColumnName = sortColumnName;
	}
	public int getSortColumnIndex() {
		return sortColumnIndex;
	}
	public void setSortColumnIndex(int sortColumnIndex) {
		this.sortColumnIndex = sortColumnIndex;
	}
	public boolean isOnlySortCurrentPage() {
		return isOnlySortCurrentPage;
	}
	public void setOnlySortCurrentPage(boolean isOnlySortCurrentPage) {
		this.isOnlySortCurrentPage = isOnlySortCurrentPage;
	}
	

	public MyDataTable getMyDataTable() {
		return MyDataTable;
	}
	public void setMyDataTable(MyDataTable myDataTable) {
		MyDataTable = myDataTable;
	}
	public int getOrder() {
		return order;
	}


	public void setOrder(int order) {
		this.order = order;
	}

	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageShow() {
		return pageShow;
	}
	public void setPageShow(int pageShow) {
		this.pageShow = pageShow;
	}

}
