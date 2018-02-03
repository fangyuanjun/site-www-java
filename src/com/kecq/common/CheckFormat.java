/**
 * CheckFormat.java
 * 2010/6/13
 */
package com.kecq.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 格式检验 
 * @author 方远均
 * @version 1.0
 */
public  class CheckFormat{
 
	/**
	 * 检验字符串是否是数字组成
	 * @param str
	 * @return
	 */
	public static  boolean isNumFormat(String str){
	     Pattern pattern = Pattern.compile("[0-9]*");
	     return pattern.matcher(str).matches();   
	}
	/**
	 * 检验一个字符串是否是字母和数字组成
	 * @param str
	 * @return
	 */
	public static  boolean isEngNumFormat(String str){
	     Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
	     return pattern.matcher(str).matches();   
	}
	
	/**
	 * 检验一个字符串是否是字母,数字,下划线组成
	 * @param str
	 * @return
	 */
	public static  boolean isEng_NumFormat(String str){
	     Pattern pattern = Pattern.compile("^\\w+$");    
	     return pattern.matcher(str).matches();   
	}
	  /**
	   * 检验是否是汉字
	   * @param str
	   * @return
	   */
	  public static boolean isHanziFormat(String str)
	  {
		  String patStr="[^\\x00-\\x80]";   //能检测到地址栏包含汉字参数
		  //String patStr="[\\u4e00-\\u9fa5]";  //不能检测到地址栏是否包含汉字参数
		  return isFormatByPattern(patStr,str);
	  }
	  
	/**
	 * 根据参数pat正则表达式判断参数str是否符合要求
	 * @param pat
	 * @param str
	 * @return
	 */
	public static boolean isFormatByPattern(String pat,String str){
		 boolean tag = true;
	      
	        final Pattern pattern = Pattern.compile(pat);
	        final Matcher mat = pattern.matcher(str);
	        if (!mat.matches()) {    //!mat.find()
	            tag = false;
	        }
	        return tag;
	}
	/**
	 * 检验是否为邮箱格式
	 * @param email
	 * @return
	 */
	public static  boolean isEmailFormat(String email)
    {
        final String pattern = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return isFormatByPattern(pattern, email);
    }
	
	/**
	 * 检验是否为身份证号码
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public static boolean  isCidFormat(String cid) throws Exception {
		
   String[] aCity = new String[] { null, null, null, null, null, null, null,
	 null, null, null, null, "北京", "天津", "河北", "山西", "内蒙古", null, null, null,
		 null, null, "辽宁", "吉林", "黑龙江", null, null, null, null, null, null, null,
		"上海", "江苏", "浙江", "安微", "福建", "江西", "山东", null, null, null, "河南", "湖北",
		"湖南", "广东", "广西", "海南", null, null, null, "重庆", "四川", "贵州", "云南", "西藏",
		 null, null, null, null, null, null, "陕西", "甘肃", "青海", "宁夏", "***", null,
		null, null, null, null, "台湾", null, null, null, null, null, null, null,
		 null, null, "香港", "澳门", null, null, null, null, null, null, null, null,
		"国外" };
   if(aCity[Integer.parseInt(cid.substring(0, 2))] == null) {
      return false;
   }
   int sum = 1;
   for (int k = 0; k < cid.length() - 1; k++) {
       // 加权因子常数
       int[] i = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
       sum += (Integer.parseInt(cid.substring(k,k+1))) * i[k];
   }
  // 校验码常数
   String s = "210X9876543";
   String jiaoyan = s.substring(sum % 11, (sum % 11 + 1));
   if (cid.substring(17).equals(jiaoyan)) 
      return true;
        else   
        	return false;
	}
	
	/**
	 * 检验是否为日期yyyy-mm-dd格式
	 * @param dayTime
	 * @return
	 */
    public static  boolean isDayFormat(String dayTime){  

        String pat = "((^((1[8-9]\\d{2})|([2-9]\\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|" +
        		"(^((1[8-9]\\d{2})|([2-9]\\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|" +
        		"([2-9]\\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|" +
        		"(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])" +
        		"(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|" +
        		"(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))";   
        return isFormatByPattern(pat, dayTime);  
    }  
    
	/**
	 * 检验是否是IP地址
	 * @param str
	 * @return
	 */
	public static  boolean isIpFormat(String str){
		String pat="^([01]?[0-9][0-9]|[01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\." +
				"([01]?[0-9][0-9]|[01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\.([01]?[0-9][0-9]|[01]?[0-9]?" +
				"[0-9]|2[0-4][0-9]|25[0-5])\\.([01]?[0-9][0-9]|[01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])$";
	     return isFormatByPattern(pat, str);   
	}
    
	/**
	 * 检验是否是整数
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str){
		String pat="^-?\\d+$";
		return isFormatByPattern(pat, str);
	}
	
	/**
	 * 检验是否是正整数
	 * @param str
	 * @return
	 */
	public static boolean isPositiveInteger(String str){
		String pat="^[0-9]*[1-9][0-9]*$";
		return isFormatByPattern(pat, str);
	}
	
	/**
	 * 检验一个字符串是否为空串  null,只包含空格的字符串都认为是空串
	 * @param str
	 * @return
	 */
  public static boolean isNullStr(String str)
  {
	  if(str==null)
		  return true;
	  else
	  {
		  int count=0;
		 for(int i=0;i<str.length();i++)
		 {
			String  temp=str.substring(i,i+1);
			if(temp.indexOf(" ")!=-1)
				count++;
		 }
		 if(count==str.length())
			 return true;
		 else
			 return false;
	  }
  }
  
  /**
   * 检验一个字符串是否包含汉字
   * @param str
   * @return
   */
  public static boolean isImportHanzi(String str)
  {
	  //String patStr="[^\\x00-\\x80]";   //能检测到地址栏包含汉字参数
	  //String patStr="[\\u4e00-\\u9fa5]";  //不能检测到地址栏是否包含汉字参数
	  boolean flag=false;
	  for(int i=0;i<str.length();i++)
	  {
		  if(isHanziFormat(str.substring(i, i+1)))
		  {
			  flag=true;
			  break;
		  }
	  }
	  
	  return flag;
  }
  
}
