package com.kecq.common;

import it.sauronsoftware.base64.Base64;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class JsonHelper {

	public static List<Map<String, Object>> jsonToMap(String json) {
		return jsonToMap(json, false);
	}
	
/**
 * 将Map<String, Object> map  转换成json格式
 * @param map
 * @param isToBase64   是否将内容base64编码
 * @return
 */
	public static String MapToJson(Map<String, Object> map, boolean isToBase64) {
		String json = "{";
		for (Object o : map.keySet()) {
			Object value=map.get(o);
			if (isToBase64&&value!=null&&(!value.toString().equals(""))) {
				json += "\"" + o + "\":\"" +Base64.encode(map.get(o).toString(),"UTF-8") + "\",";
			} else {
				json += "\"" + o + "\":\"" + map.get(o) + "\",";
			}
		}
		json = json.substring(0, json.lastIndexOf(","));
		json = json + "}";

		return json;
	}

	public static List<Map<String, Object>> jsonToMap(String json,
			boolean isBase64) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Pattern p = Pattern.compile("\\{(\".*?\")\\}");
		Pattern p2 = Pattern.compile("\"(.*?)\":\"(.*?)\"");
		Matcher m = p.matcher(json);
		while (m.find()) {
			Matcher m2 = p2.matcher(m.group());
			Map<String, Object> map = new HashMap<String, Object>();
			while (m2.find()) {
				if (isBase64&&(!m2.group(2).equals(""))) {
					map.put(m2.group(1), Base64.decode(m2.group(2), "UTF-8"));
				} else {
					map.put(m2.group(1), m2.group(2));
				}
			}
			list.add(map);
		}

		return list;
	}
	
	public static void main(String []args) throws Exception
	{
		 InputStream st=HttpHelper.DoGet("http://service.ztku.com/service/ValidateCode.aspx");
		  //这个方法会关闭流
		 byte[] buffer=HttpHelper.readInStream(st);
		  byte[] temp=new byte[100];
		  for(int i=0;i<temp.length;i++)
		  {
			  temp[i]=buffer[i];
		  }
		  String str=new String(temp,"utf-8");
		Map<String,Object> map=jsonToMap(str, false).get(0);
		System.out.print(map.get("code"));
	}
	
	public static String ListMapToJson(List<Map<String, Object>> list,boolean isToBase64)
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		 sb.append("\"rows\":[");
		 for(Map<String, Object> map :list)
		 {
			 sb.append("{");
			 String json="";
				for (Object o : map.keySet()) {
					Object value=map.get(o);
					if (isToBase64&&value!=null&&(!value.toString().equals(""))) {
						json += "\"" + o + "\":\"" +Base64.encode(map.get(o).toString(),"UTF-8") + "\",";
					} else {
						json += "\"" + o + "\":\"" + map.get(o) + "\",";
					}
				}
				
				json = json.substring(0, json.lastIndexOf(","));
				sb.append(json);
				sb.append("},");
		 }
		 
		 String temp=sb.toString();
		 String result=temp.substring(0,temp.length()-1)+"]}";
		 
		 return result;
	}
}
