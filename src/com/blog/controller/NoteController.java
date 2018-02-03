package com.blog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;










import com.blog.common.Utility;
import com.blog.ibll.IBllArticle;
import com.blog.ibll.IBllBlog;
import com.blog.model.ArticleModel;
import com.blog.model.MenuModel;
import com.blog.viewmodel.BaseViewModel;
import com.blog.viewmodel.NoteViewModel;

@RequestMapping("/")
public class NoteController {

	@Autowired
	private HttpServletRequest request;
	
	private IBllArticle articlebll;

	public void setArticlebll(IBllArticle articlebll) {
		this.articlebll = articlebll;
	}

	private IBllBlog bllblog;

	public void setBllblog(IBllBlog bllblog) {
		this.bllblog = bllblog;
	}
	
	@RequestMapping(value={"/Note","/note"})
	public String node(NoteViewModel model, Map<String, Object> map)
			throws Exception {
		
		BaseViewModel basemodel = ControllerHelper.GetBaseViewModel(bllblog,
				request);
		String domain = basemodel.getBlog().getBlogDomain();
		String basePath = Utility.getBasePath(request,domain);
		
		List<ArticleModel> list=articlebll.getArticleList(basemodel.getBlog().getBlogID()+"");
		for(ArticleModel m :list)
		{
			m.setBasePath(basePath);
		}
		
		 model=new NoteViewModel();
		 model.setListArticleCollection(list);

		 basemodel.setTitle("日志-" + basemodel.getTitle());
		 for(MenuModel item:basemodel.getMenus())
		 {
			if(item.getMenuUrl().toLowerCase().endsWith("note")) 
			{
				item.setIsActive(true);
			}
			else
			{
				item.setIsActive(false);
			}
		 }
        
		 map.put("basemodel", basemodel);
	     map.put("model", model);

	    return "/themes/" + basemodel.getThemeName() + "/note";
	}
}
