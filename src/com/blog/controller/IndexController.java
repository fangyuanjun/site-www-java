package com.blog.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.common.Config;
import com.blog.common.Utility;
import com.blog.entity.blog_tb_blog;
import com.blog.ibll.IBllBlog;
import com.blog.model.*;
import com.blog.viewmodel.*;

@RequestMapping("/")
public class IndexController {

	@Autowired
	private HttpServletRequest request;

	private IBllBlog bllblog;

	public void setBllblog(IBllBlog bllblog) {
		this.bllblog = bllblog;
	}

	private String getIndex(int page, String tagID, int year, int month,
			String categoryID, IndexViewModel model, Map<String, Object> map)
			throws Exception {
		BaseViewModel basemodel = ControllerHelper.GetBaseViewModel(bllblog,
				request);
		
		if (basemodel.getBlog().getBlogIsDisabled()) {
			request.setAttribute("msg", "文博客被禁用");
			return "/result";
		}

		if (page == 0) {
			page = 1;
		}

		int pageSize = Integer.parseInt(Config.getAppSetting("pageSize"));
		int showPageSize=Integer.parseInt(Config.getAppSetting("showPageSize"));
		
		String monthStr = "";
		model = bllblog.getArticlePage(basemodel.getBlog().getBlogID() + "",
				page, pageSize, categoryID, tagID, year, month);

		Pager pager = new Pager();
		pager.setRecordCount(model.getRecordCount());
		pager.setPageSize(pageSize);
		pager.setMaxShowPageSize(showPageSize);
		pager.setPageIndex(page);

		String domain = basemodel.getBlog().getBlogDomain();
		String basePath = Utility.getBasePath(request,domain);
		

		if (tagID != null && !tagID.equals("")) {
			pager.setUrlFormat(basePath + "/tag-" + tagID + "-%s.html");
		}

		else if (year > 0 && month > 0) {
			pager.setUrlFormat(basePath + "/month-" + monthStr + "-%s.html");
		}

		else if (categoryID != null && !categoryID.equals("")) {
			pager.setUrlFormat(basePath + "/cate-" + categoryID + "-%s.html");
		} else {
			pager.setUrlFormat(basePath + "/page-%s.html");
		}

		model.setPagerCollection(pager.getCollection());

		for (ArticleModel m : model.getTopArticles()) {
			m.setBasePath(basePath);
		}

		for (ArticleModel m : model.getIndexArticles()) {
			m.setBasePath(basePath);
		}

		for (CategoryModel c : model.getCategorys()) {
			c.setBasePath(basePath);
		}

		for (TagModel c : model.getTags()) {
			c.setBasePath(basePath);
		}

		for (ArticleModel m : model.getNewArticles()) {
			m.setBasePath(basePath);
		}

		for (ArticleModel m : model.getRandomArticles()) {
			m.setBasePath(basePath);
		}

		for (MonthModel m : model.getMonths()) {
			m.setBasePath(basePath);
		}

		for (ArticleModel m : model.getMainArticlePics()) {
			m.setBasePath(basePath);
		}
		
		String subtitle = basemodel.getBlog().getBlogSubTitle();
		if (subtitle != null && !subtitle.equals("")) {
			basemodel.setTitle(basemodel.getTitle() + " - " + subtitle);
		}
		map.put("basemodel", basemodel);
		map.put("model", model);

		return "/themes/" + basemodel.getThemeName() + "/main";
	}

	// @RequestMapping(value={"/","/page-1.html"})
	@RequestMapping(value={"/","/index.html"})
	public String index(IndexViewModel model, Map<String, Object> map)
			throws Exception {
		return getIndex(1, null, 0, 0, null, model, map);
	}

	@RequestMapping("/page-{page}.html")
	public String index(@PathVariable(value = "page") Integer page,
			IndexViewModel model, Map<String, Object> map) throws Exception {
		int p = 1;
		if (page != null) {
			p = page;
		}
		return getIndex(p, null, 0, 0, null, model, map);
	}

	@RequestMapping("/tag-{tagID}-{page}.html")
	public String index(@PathVariable(value = "tagID") String tagID,
			@PathVariable(value = "page") int page, IndexViewModel model,
			Map<String, Object> map) throws Exception {

		return getIndex(page, tagID, 0, 0, null, model, map);
	}

	@RequestMapping("/cate-{categoryid}-{page}.html")
	public String categoryIndex(
			@PathVariable(value = "categoryid") String categoryid,
			@PathVariable(value = "page") int page, IndexViewModel model,
			Map<String, Object> map) throws Exception {

		return getIndex(page, null, 0, 0, categoryid, model, map);
	}

	@RequestMapping("/month-{monthstr:\\d{6}}-{page}.html")
	public String monthIndex(@PathVariable(value = "monthstr") String monthstr,
			@PathVariable(value = "page") int page, IndexViewModel model,
			Map<String, Object> map) throws Exception {
		String y = monthstr.substring(0, 4);
		String m = monthstr.substring(4);

		return getIndex(page, null, Integer.parseInt(y), Integer.parseInt(m),
				null, model, map);
	}
}
