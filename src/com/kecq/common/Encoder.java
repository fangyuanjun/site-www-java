package com.kecq.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoder {

private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',  '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' }; 

private static String getFormattedText(byte[] bytes) { 
         int len = bytes.length; 
         StringBuilder buf = new StringBuilder(len * 2); 
         // 把密文转换成十六进制的字符串形式 
         for (int j = 0; j < len; j++) {          buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]); 
             buf.append(HEX_DIGITS[bytes[j] & 0x0f]); 
         } 

         return buf.toString(); 
     } 

public static String getMd5String(String str) throws NoSuchAlgorithmException {
	   MessageDigest md = MessageDigest.getInstance("MD5");
	   md.update(str.getBytes());
	   return getFormattedText(md.digest());
	 }

public static String getSha1String(String str) throws NoSuchAlgorithmException {
	   MessageDigest md = MessageDigest.getInstance("SHA1");
	   md.update(str.getBytes());
	   return getFormattedText(md.digest());
	 }

public static void main(String args[]) throws NoSuchAlgorithmException
{
	System.out.print(getSha1String("123456"));
}
}
