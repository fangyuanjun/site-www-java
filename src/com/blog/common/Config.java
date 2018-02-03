package com.blog.common;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Config {

	public static String getPassportRootUrl() 
	{
		try {
			return getAppSetting("PassportRootUrl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String getVisitMode()
	{
		return "js";
	}
	
	
	public static boolean getisTongjiLocal()
	{
		return false;
	}
	
//	public static String getSiteVistCode()
//	{
//		return "<script type=\"text/javascript\" src=\"http://service.kecq.com/visit\" ></script>";
		
		//return "<script type=\"text/javascript\" src=\"visit\" ></script>";
	//}
	
	public static boolean isLazyloadPic=true;

	public static boolean isLazyloadPic() {
		return isLazyloadPic;
	}
	
	
	public static String getAppSetting(String key) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();

		Document doc = builder.parse(new File(com.kecq.common.Path
				.getFullPathRelateClass("../../../config.xml", XmlHelper.class)));
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();

		XPathExpression expr = xpath.compile("/configuration/appSettings/add[@key='"+key+"']");
		NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

		return nodes.item(0).getAttributes().getNamedItem("value").getNodeValue();
	}
}
