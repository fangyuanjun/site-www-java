package com.blog.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.blog.entity.blog_tb_blog;
import com.blog.ibll.IBllBlog;
import com.blog.model.ArticleModel;
import com.blog.model.MenuModel;
import com.blog.viewmodel.BaseViewModel;
import com.blog.viewmodel.IndexViewModel;
import com.kecq.common.HttpHelper;

@Controller
// 如果在xml中注解了该类 则不需要在这里写@Controller 否则会报错
@RequestMapping("/test")
public class TestController {

	@Autowired
	private HttpServletRequest request;

	private IBllBlog bllblog;

	@RequestMapping("/index2")
	public String hello() {
		return "/themes/v3/shared/_Layout";
	}

	@RequestMapping("/index3")
	public void hello2() {

	}

	@RequestMapping("/index4")
	@ResponseBody
	public String hello4() throws UnsupportedEncodingException {

		String url = HttpHelper.getFullUrl(request);

		// return request.getRequestURI(); // /Blog/mvc/index4

		return url;
	}

	@RequestMapping("/show1.html")
	public ModelAndView show1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/themes/v3/shared/_Layout");
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value-1");
		map.put("key2", "value-2");

		mav.addObject(map);

		return mav;
	}

	@RequestMapping("/show3.html")
	public String show3(HttpServletRequest request,
			HttpServletResponse response, blog_tb_blog blog, Map model) {
		blog = new blog_tb_blog();
		blog.setBlogID(10000);
		blog.setBlogName("博客");
		model.put("blog", blog);
		request.setAttribute("b", blog);
		return "/themes/v3/shared/_Layout";
	}

	// @RequestMapping(value="/json",produces="application/json;charset=utf-8")
	@RequestMapping("/json")
	@ResponseBody
	public ModelAndView json() throws Exception {
		Map map = new HashMap();
		map.put("result", "success");

		ArticleModel model = new ArticleModel();
		model.setArticleID(1111);
		model.setArticleDatetime(new Date());

		// return new Result(1,"测试").toString();
		return new ModelAndView(new MappingJackson2JsonView(), "article", model);
		// return model;
	}

	// @RequestMapping(value="/xml",produces="text/xml;charset=utf-8")
	@RequestMapping("/xml")
	@ResponseBody
	public String xml() throws Exception {

		return "";
	}
}
