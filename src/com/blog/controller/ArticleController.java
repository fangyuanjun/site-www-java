package com.blog.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blog.common.Config;
import com.blog.common.Utility;
import com.blog.entity.blog_tb_article;
import com.blog.ibll.IBllArticle;
import com.blog.ibll.IBllBlog;
import com.blog.model.ArticleModel;
import com.blog.viewmodel.BaseViewModel;
import com.blog.viewmodel.ShowViewModel;

@RequestMapping("/")
public class ArticleController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpSession session;

	private IBllArticle articlebll;

	public void setArticlebll(IBllArticle articlebll) {
		this.articlebll = articlebll;
	}

	private IBllBlog bllblog;

	public void setBllblog(IBllBlog bllblog) {
		this.bllblog = bllblog;
	}

	@RequestMapping("/artic-{articleID}.html")
	public String index(@PathVariable(value = "articleID") String articleID,
			ShowViewModel model, Map<String, Object> map) throws Exception {
		blog_tb_article article = articlebll.GetSingle(articleID);
		if (article == null) {
			request.setAttribute("msg", "文章不存在");
			return "/result";
		}

		if (article.getArticleIsDelete()) {
			request.setAttribute("msg", "文章被删除");
			return "/result";
		}

		
		if (articlebll.isArticleDisabled(articleID)) {
			request.setAttribute("msg", "文章、分类或博客被禁用");
			return "/result";
		}

		BaseViewModel basemodel = ControllerHelper.GetBaseViewModel(bllblog,
				request);
		String domain = basemodel.getBlog().getBlogDomain();
		String basePath = Utility.getBasePath(request,domain);
		
		
		if (article.getArticlePassword() != null
				&& !article.getArticlePassword().equals("")) {
			if (session.getAttribute("Autharticle") == null
					|| !session.getAttribute("Autharticle").toString()
							.contains(articleID)) {
				// return "forward:/somePage";
				return "redirect:"
						+ basePath
						+ "/articlePassword?articleID="
						+ articleID
						+ "&BackUrl="
						+ URLEncoder.encode(basePath + "/artic-"
								+ articleID + ".html", "utf8");
			}
		}

		model = articlebll.GetArticleByID(articleID, null);

		if(model.getBeforeArticle()!=null)
		{
			model.getBeforeArticle().setBasePath(basePath);
		}
		
		if(model.getAfterArticle()!=null)
		{
			model.getAfterArticle().setBasePath(basePath);
		}
		
		ArticleModel current=model.getCurrentArticle();
		current.setBasePath(basePath);
		if(Config.isLazyloadPic)
		{
			String content=current.getArticleContent();
			content=Utility.ReplaceImgLazyload(content);
			current.setArticleContent(content);
		}
		
		basemodel.setTitle(current.getArticleTitle()+" - "+basemodel.getTitle());
		 
		map.put("basemodel", basemodel);
		map.put("model", model);

		String ip=Utility.getRemortIP(request);
		articlebll.UpdateExtend(articleID, ip, "");
		
		return "/themes/" + basemodel.getThemeName() + "/article";
	}
	
	
	@RequestMapping(value={"/articlePassword","/ArticlePassword"})
	public String articlePassword() throws Exception {
		
		BaseViewModel basemodel = ControllerHelper.GetBaseViewModel(bllblog,
				request);
		return "/themes/" + basemodel.getThemeName() + "/articlePassword";
	}
	
	@RequestMapping(value={"/articlePassword","/ArticlePassword"},method=RequestMethod.POST)
	public String articlePasswordPost() throws Exception {
		String articleID=request.getParameter("articleID");
		String articlePassword=request.getParameter("articlePassword");
		String backUrl=URLDecoder.decode(request.getParameter("BackUrl"), "utf-8");
		
		if(articlePassword==null||articlePassword.trim().equals(""))
		{
			request.setAttribute("msg", "请输入文章密码");
			return "/result";
		}
		
		blog_tb_article article = articlebll.GetSingle(articleID);
		if (article == null) {
			request.setAttribute("msg", "文章不存在");
			return "/result";
		}
		
		if(!article.getArticlePassword().equals(request.getParameter("articlePassword")))
				{
			request.setAttribute("msg", "文章密码错误");
			return "/result";
				}
		
		  request.getSession().setAttribute("Autharticle", request.getSession().getAttribute("Autharticle")+","+articleID);

		return "redirect:"+backUrl;
	}
}
