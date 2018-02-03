package com.blog.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class Utility {

	// public static string UserID
	// {
	// get
	// {
	// if (HttpContext.Current.Session["Token"] != null)
	// {
	// JsonHelper json = new
	// JsonHelper(HttpContext.Current.Session["Token"].ToString());
	// String userID = json.GetValue("userID");
	// return userID;
	// }
	// return null;
	// }
	// }
	//
	// public static string UserName
	// {
	// get
	// {
	// if (HttpContext.Current.Session["Token"] != null)
	// {
	// JsonHelper json = new
	// JsonHelper(HttpContext.Current.Session["Token"].ToString());
	// String userID = json.GetValue("userName");
	// return userID;
	// }
	// return null;
	// }
	// }
	//

	/**
	 * 是否远程
	 * 
	 * @return
	 */
	public static boolean getIsRemote(HttpServletRequest request) {

		// 是否远程IP地址 2015-6-16
		String ip=getRemortIP(request);
		if(ip.equals("0:0:0:0:0:0:0:1"))
		{
			return false;
		}
		
		if(ip.equals("127.0.0.1"))
		{
			return false;
		}
		
		if(ip.equals("::1"))
		{
			return false;
		}
		
		return true;
	}

	/**
	 * 替换延迟加载图片
	 * @param content
	 * @return
	 */
	public static String ReplaceImgLazyload(String content) {
		if (content == null || content.equals("")) {
			return content;
		}

		String reg = "<\\s*?img.+?(src=\"(http://img.kecq.com.+?)\")";
		Pattern pattern = Pattern.compile(reg);
		Matcher m = pattern.matcher(content);
		while (m.find()) {
			String src = m.group(1);
			String img = m.group(2);
			content = content.replace(src,
					" src='http://static.kecq.com/images/common/big-loading.gif' data-original=\""
							+ img + "\"");
		}

		return content;
	}

	public static String getRemortIP(HttpServletRequest request) { 
		if (request.getHeader("x-forwarded-for") == null) { 
		return request.getRemoteAddr(); 
		} 
		return request.getHeader("x-forwarded-for"); 
		} 
	
	
	/**
     * 读取txt文件的内容
     * @param filePath 想要读取的文件路径
     * @return 返回文件内容
     */
    public static String readFileText(String filePath){
    	File file=new File(filePath);
        String result = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result = result + "\n" +s;
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    
    public static String getBasePath(HttpServletRequest request,String domain){
    	String scheme=request.getScheme();
    	int port=request.getServerPort();
    	String portString=":"+port;
    	if(scheme.equals("http")&&port==80)
    	{
    		portString="";
    	}
    	
    	if(scheme.equals("https")&&port==443)
    	{
    		portString="";
    	}

    	String basePath = request.getScheme()+"://"+domain;  
		if(domain==null||domain.equals(""))
		{
			 basePath = request.getScheme()+"://"+request.getServerName()+portString+request.getContextPath();
		}
		
    	return basePath;
    }
    
}
