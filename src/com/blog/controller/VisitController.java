package com.blog.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.common.Utility;
import com.blog.dal.DalVisit;
import com.blog.entity.blog_tb_Visit;
import com.blog.ibll.IBllVisit;
import com.blog.ip.IPSeeker;
import com.blog.model.BoardPostModel;

@RequestMapping("/")
public class VisitController {

	@Autowired
	private HttpServletRequest request;


	@Autowired
	private HttpSession session;

	private IBllVisit bll;

	public void setBll(IBllVisit bll) {
		this.bll = bll;
	}

	//	@RequestMapping(value = { "/Visit", "/visit" },produces="application/javascript;charset=UTF-8")
	
	@RequestMapping(value = { "/Visit", "/visit" })
	@ResponseBody
	public String visit() throws Exception {

		String url = request.getParameter("uri");
		if (url == null || url.equals("")) {
//			String js = "var title = document.title;";
//			js += "var url = encodeURIComponent(document.location.href);";
//			js += "document.write(\"<script type=\\\"text/javascript\\\" src=\\\"http://localhost:8080/Blog/visit?uri=\" + url + \"&title=\" + encodeURIComponent(title) + \"\\\"></script>\");";
		
			 String filePath=	VisitController.class.getResource(
						"visit.js").toString().substring(5);
			 String js=Utility.readFileText(filePath);
			return js;
		} else {
//			String title = new String(request.getParameter("title").getBytes(
//					"iso-8859-1"), "utf8");
	
			//String title=new String(request.getParameter("title").getBytes("ISO-8859-1"),"utf8"); 
			String title=URLDecoder.decode(request.getParameter("title"), "utf8");
			String country = "";
			String city = "";
			String ip = Utility.getRemortIP(request);
			// 如果是远程地址
			if (Utility.getIsRemote(request)) {
				try
				{
					IPSeeker seeker = IPSeeker.getInstance();
					// String address= seeker.getAddress(ip);
					city = seeker.getArea(ip);
					country = seeker.getCountry(ip);
				}
				catch(Exception ex)
				{
					
				}
			}

			//String reffer = request.getHeader("referer");

			String reffer="";
			blog_tb_Visit entity = new blog_tb_Visit();
			entity.setVisitID(UUID.randomUUID().toString().replace("-", ""));
			entity.setADD_DATE(new Date());
			entity.setUPDATE_DATE(new Date());
			entity.setCity(city);
			entity.setCounty(country);
			entity.setVisitUrl(url);
			entity.setReffer(reffer);
			entity.setSessionID(session.getId());
			entity.setUserAgent(request.getHeader("user-agent"));
			entity.setVisitIP(ip);
			entity.setVisitTitle(title);
			
			bll.addVisit(entity);
			
			return "";
		}
	}
	
}
