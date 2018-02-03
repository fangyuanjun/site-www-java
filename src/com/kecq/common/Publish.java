/**
 * Publish.java
 * 2010-6-5
 */
package com.kecq.common;



/**
 * 
 * @author 方远均
 * @version 1.0
 */
public class Publish {
	/**
	 * 降字符串数组转换成整型数组
	 * @param s
	 * @return
	 */
	public static int [] convertStringArrayToIntArray(String []s){
		int []a=new int[s.length];
		for(int i=0;i<s.length;i++)
			a[i]=Integer.parseInt(s[i]);
		return a;
	}
	
	/**
	 * 将整型数组转换成字符串数组
	 * @param a
	 * @return
	 */
	public static String [] convertIntArrayToStringArray(int []a){
		String []s=new String[a.length];
		for(int i=0;i<a.length;i++)
			s[i]=a[i]+"";
		return s;
	}
	

	
}
