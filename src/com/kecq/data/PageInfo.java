package com.kecq.data;



public class PageInfo {

	/** ����  0��ʾ����  ����0��ʾ����   Ĭ�Ͻ���*/
	private int order;
	/** ���������  */
	private String sortColumnName;
	/** ����������  ��0��ʼ    ��Ϊ���ܶ�������Ϊ0�Ľ�������   -1 ��ʾû�����������*/
	private int sortColumnIndex=-1;
	/** ��ǰҳ   ��1��ʼ     Ĭ��Ϊ1*/
	private int pageNow=1;
	/** ÿҳ��ʾ������   Ĭ��10��*/
	private int pageShow=10;
	/** �Ƿ���Ե�ǰҳ���ݽ�������  Ĭ��ȫ���������� */
	private boolean isOnlySortCurrentPage=false;
	/** sql���  */
	private String sql;
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	/** ���������  */
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
