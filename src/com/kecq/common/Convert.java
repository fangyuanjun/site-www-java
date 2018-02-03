package com.kecq.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Convert {

	/** 如果obj为null或者""或者为字符串(不区分大小写)"null"或者转换失败都返回0* true 返回1 false 返回0 */
	public static int toInt(Object obj)
	{
	
			if(obj==null||obj.toString().equals("")||obj.toString().equalsIgnoreCase("null"))
				return 0;
			if(obj.toString().equalsIgnoreCase("true"))
				return 1;
			if(obj.toString().equalsIgnoreCase("false"))
				return 0;
		try
		{
		return Integer.parseInt(obj.toString());
		}
		catch(Exception ex)
		{
			return 0;
		}
	}
	
	/** 如果obj为null或者""或者为字符串(不区分大小写)"null"或者转换失败都 返回0*/
	public static double toDouble(Object obj)
	{
		if(obj==null||obj.toString().equals("")||obj.toString().equalsIgnoreCase("null"))
			return 0;
		try
		{
		return Double.parseDouble(obj.toString());
		}
		catch(Exception ex)
		{
			return 0;
		}
	}
	
	/**如果obj为null或者""或者为字符串(不区分大小写)"null"  返回false  
	 * 大于0的数字返回true,小于等于0的数字返回false
	 * obj为字符串true返回true 为字符串false 返回false
	 * */
	public static boolean toBoolean(Object obj)
	{
		if(obj==null||obj.toString().equals("")||obj.toString().equalsIgnoreCase("null"))
			return false;
		try
		{
			int value=Integer.parseInt(obj.toString());
			return (value>0);
		}
		catch(Exception ex)
		{
			return Boolean.parseBoolean(obj.toString());
		}
	}
	
	/**yyyy-MM-dd HH:mm:ss格式  如果转换失败 返回 1901-01-01 00:00:00
	 * @throws ParseException */
	public static Date toDateTime(Object obj) throws ParseException
	{
//		if(obj instanceof Date)
//		{
//			SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			return si.format(new java.util.Date());
//		}
		try
		{
		SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    return si.parse(obj.toString());
		}
		catch(Exception ex)
		{
			Date da=new Date();
			da.setYear(1901);
			da.setMonth(1);
			da.setDate(1);
			da.setHours(0);
			da.setMinutes(0);
			da.setSeconds(0);
			return da;
		}
	}
	
	/** 转换为时间字符串  yyyy-MM-dd HH:mm:ss格式 如果转换失败 返回 1901-01-01 00:00:00*/
	public static String toDateTimeString(Object obj)
	{
		try
		{
		if(obj instanceof Date)
		{
			
			SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return si.format(new java.util.Date());
			
		}
		else
		{
		return obj.toString();
		}
		}
		catch(Exception ex)
		{
			return "1901-01-01 00:00:00";
		}
	}
	
	public static String toString(Object obj)
	{
		if(obj==null)
			return null;
		if(obj.toString().equalsIgnoreCase("null"))
			return "";
		
		if(obj instanceof Date)
		{
		SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return si.format((Date)obj);
		}
		return obj+"";
	}
	public static void main(String args[]) throws ParseException
	{
		
		System.out.print(toDateTime("hjghjghj"));
	}
}
