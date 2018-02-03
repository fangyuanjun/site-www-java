package com.kecq.data;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kecq.common.GetString;


public class Fenye {




	/**
	 * ���캯��
	 */
	public Fenye() {

	}

	/**
	 * ���캯��
	 * 
	 * @param request
	 * @param sql
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public Fenye(HttpServletRequest request,  MyDataTable dt)
			throws NumberFormatException, Exception {
		initPageData(request, dt);
	}
	public final static String PAGE = "page";
	public final static String PAGESHOW = "pageshow";
	public final static String SORT = "sort";
	public final static String ORDER = "order";
	private HttpServletRequest request;
	private int order;
	private String sortColumn;
	private HashMap<Integer, String> hm = new HashMap<Integer, String>();
	private String httpFile; // �ļ�
	private int countTotal = 0; // ���ݿ��¼����
	private int pageNow = 1; // ��ǰ��ʾҳ��
	private int pageShow = 20; // ÿҳ��ʾ����
	private String other; // ������ַ������
	private int pageTotal; // ��ҳ��
    private MyDataTable myDataTable;
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public HashMap<Integer, String> getHm() {
		return hm;
	}

	public void setHm(HashMap<Integer, String> hm) {
		this.hm = hm;
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getCountTotal() {
		return countTotal;
	}

	public void setCountTotal(int countTotal) {
		this.countTotal = countTotal;
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

	public String getHttpFile() {
		return httpFile;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public void setHttpFile(String httpFile) {
		this.httpFile = httpFile;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}



	/**
	 * ��ʼ������
	 * 
	 * @param request
	 * @param count
	 *            --���ݿ��¼����
	 * @throws Exception
	 * @throws NumberFormatException
	 */
	public void initPageData(HttpServletRequest request, MyDataTable dt)
			throws NumberFormatException, Exception {
		
		this.setRequest(request);
		this.initRequest(request);
	    this.setMyDataTable(dt);
		
		if (pageShow < 0) // ������������ҳ��
			pageShow = 20;
		if(dt==null||dt.getRows()==null)
			this.setCountTotal(0);
		else
		this.setCountTotal(dt.getRows().size()); // ����������
		
		
		
		
		if ((countTotal % pageShow) == 0)
			this.setPageTotal(countTotal / this.getPageShow());
		else
			this.setPageTotal(countTotal / this.getPageShow() + 1);
           

		if (pageNow > pageTotal) // ���������ҳ��������ҳ�����򽫵�ǰҳ��Ϊ1
			pageNow = pageTotal;
		this.setPageNow(pageNow); // ���õ�ǰҳ��
    
		
        
	}
   
	public void initRequest(HttpServletRequest request) throws UnsupportedEncodingException
	{
		String str = request.getServletPath();
		String httpFile = str.substring(str.lastIndexOf('/') + 1,
				str.length());
		int pageNow = 1;
		if (request.getParameter(PAGE) != null) {
			try {
				pageNow = Integer.parseInt(request.getParameter(PAGE));
			} catch (Exception e) {
             
			}
		}
		
		if(pageNow<1)  
			pageNow=1;
       
		this.setPageNow(pageNow);
		int pageShow = 20;
		if (request.getParameter(PAGESHOW) != null) {
			try {
				pageShow = Integer.parseInt(request.getParameter(PAGESHOW));
			} catch (Exception e) {

			}
		}
		
		this.setPageShow(pageShow); // ����ÿҳ��ʾ����
		this.setHttpFile(httpFile); // �����ļ�
		String other = "";
		Enumeration<?> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			String paraValue = URLEncoder.encode(request.getParameter(paraName),"utf-8");
				
			if ((!paraName.equals(PAGE)) && (!paraName.equals(PAGESHOW)))
				other += ("&" + paraName + "=" + paraValue);
		}
		this.setOther(other); // ������ҳ������ַ������
	}
	public MyDataTable getMyDataTable() {
		return myDataTable;
	}

	public void setMyDataTable(MyDataTable myDataTable) {
		this.myDataTable = myDataTable;
	}

	/**
	 * ����һ���������кŵ�ӳ�� 
	 * 
	 * @param key
	 * @param value
	 */
	public void putSortColName(int key, String value) {
		hm.put(key, value);
		
	}

	/**
	 * ��ȡPageInfo ����
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public PageInfo getPageInfo()
			throws NumberFormatException, Exception {
		PageInfo pi = new PageInfo();
		int order=(request.getParameter(ORDER)==null)?0:Integer.parseInt(request.getParameter(ORDER));
		int sort=(request.getParameter(SORT)==null)?-1:Integer.parseInt(request.getParameter(SORT));
		if(sort==-1)
			pi.setSortColumnIndex(-1);
		else
		{
		// ����������
		this.setSortColumn(hm.get(sort));
		}
					// ��������ʽ
		this.setOrder(order);
			
		pi.setPageNow(pageNow);
		pi.setPageShow(pageShow);
		pi.setOrder(order);
		pi.setSortColumnName(sortColumn);
		pi.setMyDataTable(this.getMyDataTable());
		
		return pi;
	}

	/**
	 * ҳ�������ַ���
	 * 
	 * @return
	 */
	public String pageHref() {
		String str = "";
		if (pageTotal <= 5) {
			for (int i = 1; i < 6 && i <= pageTotal; i++) {
				if (i == pageNow)
					str += "<font color=red>[" + pageNow + "]</font>";
				else
					str += " <A href=" + httpFile + "?" + PAGE + "=" + i + "&"
							+ PAGESHOW + "=" + pageShow + other
							+ "><font color=green>[" + i + "]</font></A> ";
			}
		} else {
			if (pageTotal - pageNow < 5) {
				str += "<font color=red>[...]</font>";
				for (int i = pageTotal - 4; i <= pageTotal; i++) {
					if (i == pageNow)
						str += "<font color=red>[" + pageNow + "]</font>";
					else
						str += " <A href=" + httpFile + "?" + PAGE + "=" + i
								+ "&" + PAGESHOW + "=" + pageShow + other
								+ "><font color=green>[" + i + "]</font></A> ";
				}
			} else {
				if (pageNow != 1)
					str += "<font color=red>[...]</font>";
				str += "<font color=red>[" + pageNow + "]</font>";
				for (int i = pageNow + 1; i < pageNow + 5 && i <= pageTotal; i++)
					str += " <A href=" + httpFile + "?" + PAGE + "=" + i + "&"
							+ PAGESHOW + "=" + pageShow + other
							+ "><font color=green>[" + i + "]</font></A> ";
				str += "<font color=red>[...]</font>";
			}
		}
		return str;

	}

	/**
	 * ��ȡ��ҳ��ҳ��ʾ�ַ���
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String PageFooter() throws SQLException {

		String str = "";
		String otherURL = httpFile + "?" + PAGESHOW + "=" + pageShow + other;
		str += "<br><br><br><br><br><div align='center'>��<font  color='red'>"
				+ pageNow + "/" + pageTotal + "</font>ҳ&nbsp";
		str += this.pageHref();
		if (pageNow > 1)
			str += " <A href=" + httpFile + "?" + PAGE + "=1&" + PAGESHOW + "="
					+ pageShow + other + "><font color=green>��һҳ</font></A> ";
		else
			str += " ��һҳ ";

		if (pageNow > 1)
			str += " <A href=" + httpFile + "?" + PAGE + "=" + (pageNow - 1)
					+ "&" + PAGESHOW + "=" + pageShow + other
					+ "><font color=green>��һҳ</font></A> ";
		else
			str += " ��һҳ ";

		if (pageNow < pageTotal)
			str += " <A href=" + httpFile + "?" + PAGE + "=" + (pageNow + 1)
					+ "&" + PAGESHOW + "=" + pageShow + other
					+ "><font color=green>��һҳ</font></A> ";
		else
			str += " ��һҳ ";

		if (pageTotal > 1 && pageNow != pageTotal)
			str += " <A href=" + httpFile + "?" + PAGE + "=" + pageTotal
					+ other + "&" + PAGESHOW + "=" + pageShow
					+ "><font color=green>���ҳ</font></A>";
		else
			str += " ���ҳ </font>";
		String url = httpFile + "?page=1" + other + "&pageshow=";
		List<String> names=new ArrayList<String>();
		names.add("10");
		names.add("20");
		names.add("30");
		names.add("50");
		names.add("100");
		
		
		str += "&nbsp;��<font color='red'>"
				+ countTotal
				+ "</font>����¼&nbsp;ÿҳ��ʾ<select onchange=\"location.href='"
				+ url
				+ "'+this.value\">"
				+ GetString.getSelect(names, pageShow + "")
				+ "</select>��&nbsp;&nbsp;"
				+ "ת��<input id='pageGoto' size=2 "
				+ "onKeypress='if (event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;'> ҳ"
				+ "&nbsp;<input type='button' value='GO' onclick='gotoPage()'>";
		str += "\n<script type='text/javascript'>\n";
		str += "function gotoPage(){\n";
		str += "var page=document.getElementById('pageGoto').value;\n";
		str += "if(page.length==0) alert('��תҳ������Ϊ��!');\n";
		str += "else {\n" + "if(page<=0)\n" + "alert('��תҳ������Ϊ������!');\n"
				+ "else\n" + "{\n" + "if(page>" + pageTotal + ") \n"
				+ "alert('��תҳ�����ܴ�����ҳ��!'); \n" + "else  \n"
				+ "{location.href=\'" + otherURL + "&page=\'+page;\n" + "}\n"
				+ "}\n" + "}\n" + "}</script>\n</div>";

		return str;
	}
	
	public String getFristPageString()
	{
		return httpFile + "?" + PAGE + "=1&" + PAGESHOW + "="
		+ pageShow + other;
	}
	
	public String getLastPageString()
	{
		return httpFile + "?" + PAGE + "=" + pageTotal
		+ other + "&" + PAGESHOW + "=" + pageShow;
	}
	
	public String getUpPageString()
	{
		return httpFile + "?" + PAGE + "=" + (pageNow - 1)
		+ "&" + PAGESHOW + "=" + pageShow + other;
	}
	
	public String getNextPageString()
	{
		return httpFile + "?" + PAGE + "=" + (pageNow + 1)
		+ "&" + PAGESHOW + "=" + pageShow + other;
	}
	
	public String getPageString(int page)
	{
		return httpFile + "?" + PAGE + "=" + page
		+ "&" + PAGESHOW + "=" + pageShow + other;
		
	}
	public String getPageString()
	{
		return httpFile + "?" + PAGESHOW + "=" + pageShow + other+"&"+PAGE+"=";
		
	}
	public String getPageShowString(int pageShow)
	{
		return httpFile + "?page=1" + other + "&pageshow="+pageShow;
	}
	
	public String getPageShowString()
	{
		return httpFile + "?page=1" + other + "&pageshow=";
	}

}
