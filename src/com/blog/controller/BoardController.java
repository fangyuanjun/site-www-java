package com.blog.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.common.Config;
import com.blog.common.Result;
import com.blog.common.Utility;
import com.blog.entity.blog_tb_article;
import com.blog.entity.blog_tb_board;
import com.blog.entity.blog_tb_comment;
import com.blog.entity.blog_tb_talk;
import com.blog.ibll.IBllArticle;
import com.blog.ibll.IBllBlog;
import com.blog.ibll.IBllComment;
import com.blog.idal.IDalBoard;
import com.blog.idal.IDalTalk;
import com.blog.idal.MybatisHelper;
import com.blog.model.ArticleModel;
import com.blog.model.BoardPostModel;
import com.blog.model.CommentPostModel;
import com.blog.viewmodel.BaseViewModel;
import com.blog.viewmodel.BoardViewModel;
import com.blog.viewmodel.NoteViewModel;

@RequestMapping("/")
public class BoardController {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpSession session;
	
	private IBllBlog bllblog;

	public void setBllblog(IBllBlog bllblog) {
		this.bllblog = bllblog;
	}
	
	
private IBllComment commentbll;
	
	public void setCommentbll(IBllComment commentbll) {
		this.commentbll = commentbll;
	}
	
	
	@RequestMapping(value={"/Board","/board"})
	public String board(BoardViewModel model, Map<String, Object> map)
			throws Exception {
		
		BaseViewModel basemodel = ControllerHelper.GetBaseViewModel(bllblog,
				request);

		SqlSession session=MybatisHelper.getSession();
		IDalBoard dal=session.getMapper(IDalBoard.class);
		List<blog_tb_board> list=dal.query();
		session.close();
		
	
		 model=new BoardViewModel();
		 model.setCollection(list);
         model.setTitle("留言板 - "+basemodel.getBlog().getBlogTitle());
		 
		 map.put("basemodel", basemodel);
	     map.put("model", model);

	    return "/themes/" + basemodel.getThemeName() + "/board";
	}
	
	
	@RequestMapping(value = { "/BoardPost/Comment", "/boardpost/comment" }, method = RequestMethod.POST)
	@ResponseBody
	public String boardPost(BoardPostModel model) throws Exception {
	
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
		

	    blog_tb_board entity =new blog_tb_board();

	    
	    entity.setID(UUID.randomUUID().toString().replace("-", ""));
        entity.setMark(commentContent);
        entity.setSupportCount(0);
        entity.setAgainstCount(0);
        entity.setIP(Utility.getRemortIP(request));
   
        //entity.userID = Utility.UserID;
        entity.setState(0);
        entity.setADD_DATE(new Date());
        entity.setUPDATE_DATE(entity.getADD_DATE());
		
        SqlSession sqlsession=MybatisHelper.getSession();
		IDalBoard dal=sqlsession.getMapper(IDalBoard.class);
		dal.insert(entity);
		sqlsession.commit();
		sqlsession.close();
		
		session.setAttribute("commentStartDate",new Date());
		
		return new Result(1, "回复成功").toString();
	}
	
	
	@RequestMapping(value = { "/BoardPost/Zhichi", "/boardpost/zhichi" }, method = RequestMethod.POST)
	@ResponseBody
	public String zhichi(BoardPostModel model) throws Exception {
	
		String id=request.getParameter("id");
		String state=request.getParameter("state");
		if(id==null||id.equals(""))
		{
			return new Result(-99, "id不能为空").toString();
		}
		
		if(state==null||state.equals(""))
		{
			return new Result(-99, "state不能为空").toString();
		}
		

        SqlSession sqlsession=MybatisHelper.getSession();
		IDalBoard dal=sqlsession.getMapper(IDalBoard.class);
		
		if(state.equals("0"))
		{
			dal.updateAgainstCount(id);
		}
		else
		{
			dal.updateSupportCount(id);
		}
	
		sqlsession.commit();
		sqlsession.close();

		return new Result(1, "操作成功").toString();
	}
	
	
	public static void main(String args[]){
		SqlSession session=MybatisHelper.getSession();
		IDalBoard dal=session.getMapper(IDalBoard.class);
		blog_tb_board entity=new blog_tb_board();
		entity.setID(UUID.randomUUID().toString().replace("-", ""));
		entity.setID("e26ad33aab0c4abebc6f8be5984ae660");
		entity.setPID("pid");
		entity.setADD_DATE(new Date());
		entity.setAgainstCount(0);
		entity.setSupportCount(0);
		entity.setState(0);
		
		
		int result=dal.delete("e26ad33aab0c4abebc6f8be5984ae660");
		session.commit();
		System.out.print(result);
		session.close();
	}
}
