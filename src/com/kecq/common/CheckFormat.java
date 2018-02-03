/**
 * CheckFormat.java
 * 2010/6/13
 */
package com.kecq.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * ��ʽ���� 
 * @author ��Զ��
 * @version 1.0
 */
public  class CheckFormat{
 
	/**
	 * �����ַ����Ƿ����������
	 * @param str
	 * @return
	 */
	public static  boolean isNumFormat(String str){
	     Pattern pattern = Pattern.compile("[0-9]*");
	     return pattern.matcher(str).matches();   
	}
	/**
	 * ����һ���ַ����Ƿ�����ĸ���������
	 * @param str
	 * @return
	 */
	public static  boolean isEngNumFormat(String str){
	     Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
	     return pattern.matcher(str).matches();   
	}
	
	/**
	 * ����һ���ַ����Ƿ�����ĸ,����,�»������
	 * @param str
	 * @return
	 */
	public static  boolean isEng_NumFormat(String str){
	     Pattern pattern = Pattern.compile("^\\w+$");    
	     return pattern.matcher(str).matches();   
	}
	  /**
	   * �����Ƿ��Ǻ���
	   * @param str
	   * @return
	   */
	  public static boolean isHanziFormat(String str)
	  {
		  String patStr="[^\\x00-\\x80]";   //�ܼ�⵽��ַ���������ֲ���
		  //String patStr="[\\u4e00-\\u9fa5]";  //���ܼ�⵽��ַ���Ƿ�������ֲ���
		  return isFormatByPattern(patStr,str);
	  }
	  
	/**
	 * ���ݲ���pat������ʽ�жϲ���str�Ƿ����Ҫ��
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
	 * �����Ƿ�Ϊ�����ʽ
	 * @param email
	 * @return
	 */
	public static  boolean isEmailFormat(String email)
    {
        final String pattern = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return isFormatByPattern(pattern, email);
    }
	
	/**
	 * �����Ƿ�Ϊ���֤����
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public static boolean  isCidFormat(String cid) throws Exception {
		
   String[] aCity = new String[] { null, null, null, null, null, null, null,
	 null, null, null, null, "����", "���", "�ӱ�", "ɽ��", "���ɹ�", null, null, null,
		 null, null, "����", "����", "������", null, null, null, null, null, null, null,
		"�Ϻ�", "����", "�㽭", "��΢", "����", "����", "ɽ��", null, null, null, "����", "����",
		"����", "�㶫", "����", "����", null, null, null, "����", "�Ĵ�", "����", "����", "����",
		 null, null, null, null, null, null, "����", "����", "�ຣ", "����", "***", null,
		null, null, null, null, "̨��", null, null, null, null, null, null, null,
		 null, null, "���", "����", null, null, null, null, null, null, null, null,
		"����" };
   if(aCity[Integer.parseInt(cid.substring(0, 2))] == null) {
      return false;
   }
   int sum = 1;
   for (int k = 0; k < cid.length() - 1; k++) {
       // ��Ȩ���ӳ���
       int[] i = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
       sum += (Integer.parseInt(cid.substring(k,k+1))) * i[k];
   }
  // У���볣��
   String s = "210X9876543";
   String jiaoyan = s.substring(sum % 11, (sum % 11 + 1));
   if (cid.substring(17).equals(jiaoyan)) 
      return true;
        else   
        	return false;
	}
	
	/**
	 * �����Ƿ�Ϊ����yyyy-mm-dd��ʽ
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
	 * �����Ƿ���IP��ַ
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
	 * �����Ƿ�������
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str){
		String pat="^-?\\d+$";
		return isFormatByPattern(pat, str);
	}
	
	/**
	 * �����Ƿ���������
	 * @param str
	 * @return
	 */
	public static boolean isPositiveInteger(String str){
		String pat="^[0-9]*[1-9][0-9]*$";
		return isFormatByPattern(pat, str);
	}
	
	/**
	 * ����һ���ַ����Ƿ�Ϊ�մ�  null,ֻ�����ո���ַ�������Ϊ�ǿմ�
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
   * ����һ���ַ����Ƿ��������
   * @param str
   * @return
   */
  public static boolean isImportHanzi(String str)
  {
	  //String patStr="[^\\x00-\\x80]";   //�ܼ�⵽��ַ���������ֲ���
	  //String patStr="[\\u4e00-\\u9fa5]";  //���ܼ�⵽��ַ���Ƿ�������ֲ���
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
