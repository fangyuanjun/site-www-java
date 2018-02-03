package com.blog.ip;

import java.io.IOException;

import com.blog.common.XmlHelper;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		IPSeeker seeker = IPSeeker.getInstance();
//		String ip ="222.222.137.194";//放入要测试的ip地址
//		String ip1="218.69.2.106";
//	
//		        System.out.println("address:"+seeker.getAddress(ip1));
//		        System.out.println("area:"+seeker.getArea(ip1));
//		        System.out.println("country:"+seeker.getCountry(ip1));
		
		
		
	 String s = IPSeeker.class.getResource(
					"QQWry.dat").toString();
		 
		 System.out.print(s);
		  
	}

}
