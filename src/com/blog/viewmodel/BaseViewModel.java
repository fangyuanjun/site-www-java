package com.blog.viewmodel;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.common.Config;
import com.blog.entity.blog_tb_blog;
import com.blog.model.*;
import com.kecq.common.HttpHelper;
import com.kecq.common.StringEx;

public class BaseViewModel {

	@Autowired
	private HttpServletRequest request;

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String tongjiHtml;

	public void setTongjiHtml(String value) {
		this.tongjiHtml = value;
	}

	/**
	 * 统计代码
	 * 
	 * @return
	 */
	public String getTongjiHtml() {
		return tongjiHtml;
	}

	/**
	 * 主题
	 */
	private String themeName;

	/**
	 * 博客信息
	 */
	private blog_tb_blog blog;

	public String getRegisterUrl() {

		return StringEx.trimEnd(Config.getPassportRootUrl(), "/") + "/Register";
	}

	public String getLoginUrl() throws UnsupportedEncodingException {
		return StringEx.trimEnd(Config.getPassportRootUrl(), "/")
				+ "/Login?BackURL="
				+ URLEncoder.encode("http://" + request.getServerName()
						+ "/AuthJump?ref=" + HttpHelper.getFullUrl(request),
						"utf8");

	}

	public String getQQLoginUrl() throws UnsupportedEncodingException {
		return StringEx.trimEnd(Config.getPassportRootUrl(), "/")
				+ "/Login/LoginByQQ?BackURL="
				+ URLEncoder.encode("http://" + request.getServerName()
						+ "/AuthJump?ref=" + HttpHelper.getFullUrl(request),
						"utf8");

	}

	public String getLogoutUrl() throws UnsupportedEncodingException {
		return StringEx.trimEnd(Config.getPassportRootUrl(), "/")
				+ "/Login/Logout?BackURL="
				+ URLEncoder.encode(
						"http://" + request.getServerName()
								+ "/AuthJump?action=logout&ref="
								+ HttpHelper.getFullUrl(request), "utf8");
	}

	public String getSearchUrl() {

		return "http://so.fyj.me/";

	}

	private String faviconIcon;

	private int messageCount;

	private String keywords;

	private String description;

	/**
	 *  博客链接
	 */
	private String blogUrl;

	private List<MenuModel> menus;

	/**
	 * 友情链接
	 */
	private List<LinkModel> linkCollection;

	private String sitemapUrl;

	public String getRssUrl() {

		return this.blogUrl + "/Rss";

	}

	/**
	 * 总文章数
	 */
	private int totalArticleCount;

	/**
	 * 总文章点击次数
	 */
	private int totalArticleViewCount;

	/**
	 * 总文章评论次数
	 */
	private int totalArticleCommentCount;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public blog_tb_blog getBlog() {
		return blog;
	}

	public void setBlog(blog_tb_blog blog) {
		this.blog = blog;
	}

	public String getFaviconIcon() {
		return faviconIcon;
	}

	public void setFaviconIcon(String faviconIcon) {
		this.faviconIcon = faviconIcon;
	}

	public int getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBlogUrl() {
		return blogUrl;
	}

	public void setBlogUrl(String blogUrl) {
		this.blogUrl = blogUrl;
	}

	public List<MenuModel> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuModel> menus) {
		this.menus = menus;
	}

	public List<LinkModel> getLinkCollection() {
		return linkCollection;
	}

	public void setLinkCollection(List<LinkModel> linkCollection) {
		this.linkCollection = linkCollection;
	}

	public String getSitemapUrl() {
		return sitemapUrl;
	}

	public void setSitemapUrl(String sitemapUrl) {
		this.sitemapUrl = sitemapUrl;
	}

	public int getTotalArticleCount() {
		return totalArticleCount;
	}

	public void setTotalArticleCount(int totalArticleCount) {
		this.totalArticleCount = totalArticleCount;
	}

	public int getTotalArticleViewCount() {
		return totalArticleViewCount;
	}

	public void setTotalArticleViewCount(int totalArticleViewCount) {
		this.totalArticleViewCount = totalArticleViewCount;
	}

	public int getTotalArticleCommentCount() {
		return totalArticleCommentCount;
	}

	public void setTotalArticleCommentCount(int totalArticleCommentCount) {
		this.totalArticleCommentCount = totalArticleCommentCount;
	}
}
