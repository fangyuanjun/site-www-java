package com.blog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.entity.blog_tb_talk;
import com.blog.ibll.IBllBlog;
import com.blog.idal.IDalTalk;
import com.blog.idal.MybatisHelper;
import com.blog.model.MenuModel;
import com.blog.viewmodel.BaseViewModel;
import com.blog.viewmodel.TalkViewModel;

@RequestMapping("/")
public class TalkController {

	@Autowired
	private HttpServletRequest request;
	

	private IBllBlog bllblog;

	public void setBllblog(IBllBlog bllblog) {
		this.bllblog = bllblog;
	}
	
	@RequestMapping(value={"/Talk","/talk"})
	public String node(TalkViewModel model, Map<String, Object> map)
			throws Exception {
		
		BaseViewModel basemodel = ControllerHelper.GetBaseViewModel(bllblog,
				request);

		SqlSession session=MybatisHelper.getSession();
		IDalTalk dal=session.getMapper(IDalTalk.class);
		List<blog_tb_talk> list=dal.query(basemodel.getBlog().getUserID()+"");
		session.close();
		
		 model=new TalkViewModel();
		 model.setTalkCollection(list);

		 basemodel.setTitle("碎言碎语-" + basemodel.getTitle());
		 for(MenuModel item:basemodel.getMenus())
		 {
			if(item.getMenuUrl().toLowerCase().endsWith("talk")) 
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

	    return "/themes/" + basemodel.getThemeName() + "/talk";
	}
	
}
