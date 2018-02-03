package com.blog.common;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.*;

public class XmlHelper {

	public static void main(String[] args) throws Exception {

	}

	public static String GetXmlSql(String id) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();

		Document doc = builder.parse(new File(com.kecq.common.Path
				.getFullPathRelateClass("../../../sql.xml", XmlHelper.class)));
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();

		XPathExpression expr = xpath.compile("/db/sql[@id='"+id+"']");
		NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

		return nodes.item(0).getTextContent();
	}

}
