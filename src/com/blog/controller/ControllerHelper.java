package com.blog.controller;

import javax.servlet.http.HttpServletRequest;

import com.blog.common.Config;
import com.blog.common.Utility;
import com.blog.entity.blog_tb_blog;
import com.blog.ibll.IBllBlog;
import com.blog.model.MenuModel;
import com.blog.viewmodel.BaseViewModel;

public class ControllerHelper {

	private static String getSiteVistCode(HttpServletRequest request)
	{
		//return "<script type=\"text/javascript\" src=\"http://service.kecq.com/visit\" ></script>";
		
		return "<script type=\"text/javascript\" src=\"visit\" ></script>";
	}
	
	
	public static BaseViewModel GetBaseViewModel(IBllBlog bllblog,
			HttpServletRequest request) throws Exception {

		blog_tb_blog blog = bllblog.getSingleBlogByDomain(request
				.getServerName());
		BaseViewModel model = bllblog.getBlogViewModel(blog.getBlogID() + "");
		model.setBlog(blog);

		String domain = blog.getBlogDomain();
		String basePath = Utility.getBasePath(request,domain);
		
		model.setBlogUrl(basePath);
		model.setSitemapUrl(basePath + "/sitemap.xml");

		model.setKeywords(blog.getBlogKeywords());
		model.setDescription(blog.getBlogDescription());
		model.setThemeName(blog.getThemeID());
		model.setTitle(blog.getBlogTitle());
		if (blog.getBlogSubTitle() != null && !blog.getBlogSubTitle().equals("")) {
			model.setTitle(model.getTitle() + " - " + blog.getBlogSubTitle());
		}

		if (model.getMenus().size() > 0) {
			model.getMenus().get(0).setIsActive(true);
		}

		for (MenuModel menu : model.getMenus()) {
			menu.setBasePath(basePath);
		}

		String tongjiHtml = "";
		if (Config.getVisitMode() == "js") {
			// 如果是远程IP地址或者本地访问也统计则返回统计代码 否则返回空字符串
			if (Utility.getIsRemote(request) || Config.getisTongjiLocal()) {
				tongjiHtml = (blog.getTongji()==null?"":blog.getTongji()) + getSiteVistCode(request);
			}
		}
		model.setTongjiHtml(tongjiHtml);

		return model;
	}
	
	public static BaseViewModel GetBaseViewModel2(IBllBlog bllblog,
			HttpServletRequest request) throws Exception
	{
		blog_tb_blog blog = bllblog.getSingleBlogByDomain(request
				.getServerName());
		BaseViewModel model = new BaseViewModel();
		model.setBlog(blog);

		String domain = blog.getBlogDomain();
		String basePath = Utility.getBasePath(request,domain);
		
		model.setBlogUrl(basePath);

		model.setSitemapUrl(basePath + "/sitemap.xml");

		model.setKeywords(blog.getBlogKeywords());
		model.setDescription(blog.getBlogDescription());
		model.setThemeName(blog.getThemeID());
		model.setTitle(blog.getBlogTitle());
		if (blog.getBlogSubTitle() == null || blog.getBlogSubTitle() == "") {
			model.setTitle(model.getTitle() + " - " + blog.getBlogSubTitle());
		}

		String tongjiHtml = "";
		if (Config.getVisitMode() == "js") {
			// 如果是远程IP地址或者本地访问也统计则返回统计代码 否则返回空字符串
			if (Utility.getIsRemote(request) || Config.getisTongjiLocal()) {
				tongjiHtml = (blog.getTongji()==null?"":blog.getTongji()) + getSiteVistCode(request);
			}
		}
		model.setTongjiHtml(tongjiHtml);

		return model;
	}
}
