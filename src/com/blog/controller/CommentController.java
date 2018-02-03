package com.blog.controller;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.common.Result;
import com.blog.common.Utility;
import com.blog.entity.blog_tb_article;
import com.blog.entity.blog_tb_comment;
import com.blog.ibll.IBllArticle;
import com.blog.ibll.IBllComment;
import com.blog.model.CommentPostModel;


@RequestMapping("/")
public class CommentController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpSession session;
	
	
	private IBllComment commentbll;
	
	private IBllArticle articlebll;

	public void setArticlebll(IBllArticle articlebll) {
		this.articlebll = articlebll;
	}

	public void setCommentbll(IBllComment commentbll) {
		this.commentbll = commentbll;
	}
	
	// method={RequestMethod.GET,RequestMethod.POST}
	@RequestMapping(value = { "/CommentPost/Comment", "/commentpost/comment" }, method = RequestMethod.POST)
	@ResponseBody
	public String Comment(CommentPostModel model) throws Exception {
		String articleID = model.getArticleID();
		String commentContent = model.getCommentContent();
		if(commentContent==null||commentContent.equals(""))
		{
			return new Result(-99, "回复内容不能为空").toString();
		}
		
		if(!commentbll.isAllowCommentContent(commentContent))
		{
			return new Result(-98, "回复内容有危险性").toString();
		}
		
		if(session.getAttribute("commentStartDate")!=null)
		{
			Date commentStartDate=(Date)session.getAttribute("commentStartDate");
			long second= (new Date().getTime()-commentStartDate.getTime())/1000;
			if(second<30)
			{
				return new Result(-97, (30-second)+"秒后才能回复").toString();
			}
		}
		
		
		blog_tb_article article = articlebll.GetSingle(articleID);

		if (article == null) {
			return new Result(-1, "文章不存在").toString();
		}

		if (article.getArticleIsDelete()) {
			return new Result(-2, "文章被删除").toString();
		}

		if (articlebll.isArticleDisabled(articleID)) {
			return new Result(-3, "文章、分类或博客被禁用").toString();
		}

		
	    blog_tb_comment entity =new blog_tb_comment();

        //int floor = Utility.CommentBll.GetMaxFloor(articleID);
        entity.setFloor(0);
        entity.setCommentState(0);
        entity.setSupportCount(0);
        entity.setAgainstCount(0);
        entity.setCommentIP(Utility.getRemortIP(request));
        entity.setCommentContent (commentContent);
        entity.setCommentText(model.getCommentText());
        entity.setArticleID ( Integer.parseInt(articleID));
        //entity.userID = Utility.UserID;
        //entity.userName = Utility.UserName;
        entity.setADD_DATE(new Date());
        entity.setUPDATE_DATE(entity.getADD_DATE());
		entity.setCommentID(UUID.randomUUID().toString().replace("-", ""));
		commentbll.insert(entity);
		session.setAttribute("commentStartDate",new Date());
		
		return new Result(1, "回复成功").toString();
	}

}
