package com.kecq.common;

public class StringEx {

	/** ÒÆ³ýÄ©Î²µÄ×Ö·û */
	public static String trimEnd(String str,String trim)
	{
	String st=str;
	if(st.lastIndexOf(trim)!=-1&&(st.lastIndexOf(trim)==(st.length()-1)))
	{
		st=str.substring(0,str.length()-trim.length());
	 while(st.lastIndexOf(trim)==(st.length()-1))
	 {
		st=st.substring(0,st.length()-trim.length());
	 }
	}
	return st;
	}
	/** ÒÆ³ý¿ªÊ¼µÄ×Ö·û */
	public static String trimStart(String str,String trim)
	{

	String st=str;
	if(st.lastIndexOf(trim)!=-1&&(st.indexOf(trim)==0))
	{
		st=str.substring(trim.length(),str.length());
	while(st.indexOf(trim)==0)
	 {
		st=st.substring(trim.length(),st.length());
	 }
	}
	return st;
	}
	/** ÒÆ³ý¿ªÊ¼ºÍÄ©Î²µÄ×Ö·û */
	public static String trim(String str,String trim)
	{
		return trimStart(trimEnd(str,trim),trim);
	}

	public static String byte2hex(byte[] b) {
		  StringBuffer hs = new StringBuffer(b.length);
		  String stmp = "";
		  int len = b.length;
		  for (int n = 0; n < len; n++) {
		   stmp = Integer.toHexString(b[n] & 0xFF);
		   if (stmp.length() == 1)
		    hs = hs.append("0").append(stmp);
		   else {
		    hs = hs.append(stmp);
		   }
		  }
		  return String.valueOf(hs);
		 }
}
