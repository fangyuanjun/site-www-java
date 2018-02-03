/**
 * GetString.java
 * 2010/4/27
 */
package com.kecq.common;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;

/**
 * 返回一些字符串
 * 
 * @author 方远均
 * 
 */
public class GetString {

	/**
	 * 计算百分比
	 * 
	 * @param dividend
	 *            -被除数
	 * @param divisor
	 *            -除数
	 * @return
	 */
	public static String getPercent(double dividend, double divisor) {

		double source = dividend / divisor;
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(2);
		return nf.format(source);
	}

	/**
	 * 产生指定长度的随机数字字符串
	 * 
	 * @param patStr
	 *            -从该字符串的每个字母产生
	 * @param length
	 *            -产生字符串的长度
	 * @return
	 */
	public static String randomString(String patStr, int length) {
		Random randGen = null;
		char[] numbersAndLetters = null;
		Object initLock = new Object();
		if (length < 1) {
			return null;
		}
		if (randGen == null) {
			synchronized (initLock) {
				if (randGen == null) {
					randGen = new Random();
					numbersAndLetters = (patStr).toCharArray();
				}
			}
		}
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(10)];
		}
		return new String(randBuffer);
	}

	/**
	 * 将输入库中的正文换行\n转成<br>
	 * 
	 * @param temp
	 * @return
	 */
	public static String getBr(String temp) {
		String content = "";
		if (temp != null) {
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) == '\n')
					content += "<br>";
				else
					content += temp.charAt(i);
			}
		}
		return content;
	}

	/**
	 * 获取系统时间
	 * 
	 * @return
	 */
	public static String getDataTime() {
		SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return si.format(new java.util.Date());
	}

	/**
	 * 获取网页基本地址
	 * 
	 * @param request
	 * @return
	 */
	/*public static String getBasePath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/";
	}
*/


	/**
	 * 将字符串数组生成一个网页形式的下拉选项，选项的值就是显示的值
	 * 
	 * @param name
	 * @return
	 */
	public static String getSelect(String name[]) {
		String str = "";
		for (int i = 0; i < name.length; i++) {
			str += "<option value=" + name[i] + ">" + name[i] + "</option>";
		}
		return str;
	}

	/**
	 * 将字符串数组生成一个网页形式的下拉选项,并选择一项,选项的值就是显示的值
	 * 
	 * @param name
	 * @param selectValue
	 *            被选择的项
	 * @return
	 */
	public static String getSelect(List<String> names, String selectValue) {
		String str = "";
		if(selectValue==null)
			selectValue="";
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equals(selectValue))
				str += "<option value=" + names.get(i) + "  selected='selected'>"
						+ names.get(i) + "</option>";
			else
				str += "<option value=" +names.get(i) + ">" +names.get(i) + "</option>";
		}
		return str;
	}

	/**
	 * 将字符串数组生成一个网页形式的下拉选项，并有为参数选项值
	 * 
	 * @param name
	 *            显示的选项
	 * @param value
	 *            选项值
	 * @return
	 */
	public static String getSelect(List<String> names, List<String> values) {
		String str = "";
		for (int i = 0; i < names.size(); i++) {
			str += "<option value=" + values.get(i) + ">" + names.get(i) + "</option>";
		}
		return str;
	}

	/**
	 * 将字符串数组生成一个网页形式的下拉选项，并有为参数选项值,选择一项
	 * 
	 * @param name
	 *            显示的选项
	 * @param value
	 *            选项值
	 * @param selectValue
	 *            选择的项
	 * @return
	 */
	public static String getSelect(List<String> names, List<String> values,
			String selectValue) {
		if(selectValue==null)
			selectValue="";
		String str = "";
		for (int i = 0; i < names.size(); i++) {
			if (values.get(i).equals(selectValue))
				str += "<option value=" + values.get(i) + "  selected='selected'>"
						+ names.get(i) + "</option>";
			else
				str += "<option value=" + values.get(i) + ">" + names.get(i)
						+ "</option>";
		}
		return str;
	}

	public static String getChaxunSelect(String selectedValue) {
		String str = "";
		if(selectedValue==null)
			selectedValue="";
		
		if(selectedValue.equals("&lt")||selectedValue.equals("<"))
		str+="<option value=\"&lt\" selected='selected'>小于</option>";
		else
			str+="<option value=\"&lt\" >小于</option>";
		
		if(selectedValue.equals("&gt=")||selectedValue.equals(">"))
			str+="<option value=\"&gt\" selected='selected'>大于</option>";
			else
				str+="<option value=\"&gt\" >大于</option>";
		
		if(selectedValue.equals("&lt=")||selectedValue.equals("<="))
			str+="<option value=\"&lt=\" selected='selected'>小于等于</option>";
			else
				str+="<option value=\"&lt=\" >小于等于</option>";
		
		if(selectedValue.equals("&gt=")||selectedValue.equals(">="))
			str+="<option value=\"&gt=\" selected='selected'>大于等于</option>";
			else
				str+="<option value=\"&gt=\" >大于等于</option>";
		
		if(selectedValue.equals("="))
			str+="<option value=\"=\" selected='selected'>等于</option>";
			else
				str+="<option value=\"=\" >等于</option>";
		
		if(selectedValue.equals("!="))
			str+="<option value=\"!=\" selected='selected'>不等于</option>";
			else
				str+="<option value=\"!=\" >不等于</option>";
		
		if(selectedValue.equals("like"))
			str+="<option value=\"like\" selected='selected'>像</option>";
			else
				str+="<option value=\"like\" >像</option>";
		return str;
	}
	/**
	 * 获取IP地址
	 * 
	 * @param request
	 * @return
	 */
	/*public static String getIpAddress(HttpServletRequest request) {
		return request.getLocalAddr();
	}*/

	
	
	/** 取得A时间减去B时间后的毫秒数  */
	public static long getPoorSeconds(Date a,Date b){
	    Calendar timea = Calendar.getInstance();
	    Calendar timeb = Calendar.getInstance();
	    timea.setTime(a);
	    timeb.setTime(b);
	    return timea.getTimeInMillis() - timeb.getTimeInMillis();
	}
	
	public static String FilterSql(String sql)
	{
		sql=sql.replaceAll("(?i)(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)", "");
		sql=sql.replaceAll("'", "");
		sql=sql.replaceAll(",", "");

       return sql;
	}
	
}
