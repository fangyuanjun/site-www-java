package com.blog.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.common.Utility;
import com.blog.ibll.IBllBlog;
import com.blog.model.ArticleModel;
import com.blog.model.CategoryModel;
import com.blog.model.MenuModel;
import com.blog.model.MonthModel;
import com.blog.viewmodel.BaseViewModel;
import com.blog.viewmodel.SitemapViewModel;

@RequestMapping("/")
public class SitemapController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;
	
	private IBllBlog bllblog;

	public void setBllblog(IBllBlog bllblog) {
		this.bllblog = bllblog;
	}

	
	@RequestMapping("/sitemap.xml")
	public void showXml() throws Exception {

		BaseViewModel basemodel = ControllerHelper.GetBaseViewModel(bllblog,
				request);
		String domain = basemodel.getBlog().getBlogDomain();
		String basePath = Utility.getBasePath(request,domain);
		SitemapViewModel model = bllblog.GetSitemap(basemodel.getBlog()
				.getBlogID() + "");

		for (MenuModel m : model.getMenu()) {
			m.setBasePath(basePath);
		}

		for (ArticleModel m : model.getArticle()) {
			m.setBasePath(basePath);
		}

		for (CategoryModel m : model.getCategory()) {
			m.setBasePath(basePath);
		}

		for (MonthModel m : model.getMonth()) {
			m.setBasePath(basePath);
		}

		SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd");
		String currentdate = si.format(new java.util.Date());

		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n");

		for (MenuModel m : model.getMenu()) {
			sb.append("<url>\n");
			sb.append("<loc>" + m.getMenuUrl() + "</loc>\n");
			sb.append("<lastmod>" + currentdate + "</lastmod>\n");
			sb.append("<changefreq>daily</changefreq>\n");
			sb.append("<priority>0.9</priority>\n");
			sb.append("</url>\n");
		}

		for (CategoryModel m : model.getCategory()) {
			sb.append("<url>\n");
			sb.append("<loc>" + m.getUrl() + "</loc>\n");
			sb.append("<lastmod>" + currentdate + "</lastmod>\n");
			sb.append("<changefreq>daily</changefreq>\n");
			sb.append("<priority>0.8</priority>\n");
			sb.append("</url>\n");
		}

		for (MonthModel m : model.getMonth()) {
			sb.append("<url>\n");
			sb.append("<loc>" + m.getUrl() + "</loc>\n");
			sb.append("<lastmod>" + m.getYyyy() + "-" + m.getMm()
					+ "-28</lastmod>\n");
			sb.append("<changefreq>daily</changefreq>\n");
			sb.append("<priority>0.7</priority>\n");
			sb.append("</url>\n");
		}

		for (ArticleModel m : model.getArticle()) {
			sb.append("<url>\n");
			sb.append("<loc>" + m.getArticleUrl() + "</loc>\n");
			sb.append("<lastmod>"
					+ new SimpleDateFormat("yyyy-MM-dd").format(m
							.getArticleDatetime()) + "</lastmod>\n");
			sb.append("<changefreq>never</changefreq>\n");
			sb.append("<priority>0.5</priority>\n");
			sb.append("</url>\n");
		}

		sb.append("</urlset>\n");

		response.setContentType("text/xml;charset=utf-8"); 
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.write(sb.toString());
		out.close();

	}
}
