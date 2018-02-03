package com.blog.common;

public class Result {

	private int code;
	private String message;
	
	public Result(int code,String message)
	{
	   	this.code=code;
	    this.message=message;			
	}

	@Override
	public String toString() {
		return "{\"code\":\""+code+"\",\"message\":\""+message.replace("\"", "/")+"\"}";
	}
	
	
}
