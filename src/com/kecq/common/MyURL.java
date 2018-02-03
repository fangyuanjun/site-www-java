package com.kecq.common;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

public class MyURL {

	private String currentURL;
	private String requestURL;
	private HashMap<String,String> parameterMap=new HashMap<String,String>();
	
	

	public String getCurrentURL() {
		return currentURL;
	}

	public void setCurrentURL(String currentURL) {
		this.currentURL = currentURL;
	}

	public String getRequestURL() {
		return requestURL;
	}

	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}

	public HashMap<String, String> getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(HashMap<String, String> parameterMap) {
		this.parameterMap = parameterMap;
	}

	/**
	 * 获取网页全部地址  包括参数 如果参数含中文字符获取的是utf-8的百分号形式
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public   MyURL(HttpServletRequest request) throws UnsupportedEncodingException {
		String canshu = "";
		Enumeration<?> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			String paraValue=java.net.URLDecoder.decode(request.getParameter(paraName),"utf-8");
			if(!parameterMap.containsKey(paraName))
			{
				parameterMap.put(paraName, paraValue);
			}
			canshu += (paraName + "=" + paraValue + "&");
		}
        requestURL=request.getRequestURL().toString();
		String fullUrl = request.getRequestURL().toString();
		if (canshu.length() != 0)
			fullUrl = fullUrl + "?" + canshu.substring(0, canshu.length() - 1);
          
		currentURL= fullUrl;
	}
	
	public MyURL(String url)
	{
	currentURL=url;	
	if(url.indexOf("?")!=-1)
	 {
	 requestURL=url.substring(0, url.indexOf("?"));
	 }
	else
		requestURL=url;
	}
	
	public  void addParameter(String key,String value)
	{
		
			parameterMap.put(key, value);
		
		setCurrentURL();
	}
	
	public void removeParameter(String key)
	{
		parameterMap.remove(key);
		setCurrentURL();
		
	}
	
	private  void setCurrentURL()
	{
		String canshu = "";
		//Iterator<?> i = parameterMap.entrySet().iterator();
		Iterator<?> i = parameterMap.keySet().iterator();
		while(i.hasNext()){
			
		    Object o = i.next();
		   
		    canshu += (o + "=" + parameterMap.get(o) + "&");
		    
		}
		if (canshu.length() != 0)
		{
			canshu=canshu.substring(0,canshu.length()-1);	
		currentURL=requestURL+"?"+canshu;
		}
		else
			currentURL=requestURL;
	}
}
