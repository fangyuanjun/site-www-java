package com.blog.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.entity.blog_tb_album;
import com.blog.entity.blog_tb_article;
import com.blog.entity.blog_tb_photo;
import com.blog.ibll.IBllArticle;
import com.blog.ibll.IBllBlog;
import com.blog.idal.IDalAlbum;
import com.blog.idal.IDalFiles;
import com.blog.idal.MybatisHelper;
import com.blog.model.AlbumModel;
import com.blog.viewmodel.AlbumViewModel;
import com.blog.viewmodel.BaseViewModel;
import com.blog.viewmodel.PhotoShowViewModel;

@RequestMapping("/")
public class AlbumController {

	@Autowired
	private HttpServletRequest request;
	
	
	private IBllBlog bllblog;

	public void setBllblog(IBllBlog bllblog) {
		this.bllblog = bllblog;
	}
	
	private IBllArticle articlebll;

	public void setArticlebll(IBllArticle articlebll) {
		this.articlebll = articlebll;
	}

	@RequestMapping(value={"/Album","/album"})
	public String album(AlbumViewModel model, Map<String, Object> map)
			throws Exception {
		
		BaseViewModel basemodel = ControllerHelper.GetBaseViewModel(bllblog,
				request);
		
		SqlSession session=MybatisHelper.getSession();
		IDalAlbum dal=session.getMapper(IDalAlbum.class);
		List<AlbumModel> list=dal.queryAlbum(basemodel.getBlog().getUserID()+"");
		session.close();
		
		model = new AlbumViewModel();
		for(AlbumModel album :list)
		{
			List<String> plist=new ArrayList<String>();
			plist.add(album.getCoverUrl());
			album.setPhotos(plist);
		}
		
		model.setAlbumCollection(list);
		model.setTitle("相册 - "+basemodel.getTitle());

		 map.put("basemodel", basemodel);
	     map.put("model", model);
	     
        return "/themes/album/album";
	}
	
	
	@RequestMapping(value={"/Album/PhotoShow/{albumID}","/album/photoshow/{albumID}"})
	public String photoShow(@PathVariable(value = "albumID") String albumID,PhotoShowViewModel model, Map<String, Object> map) throws Exception
	{
		BaseViewModel basemodel= ControllerHelper.GetBaseViewModel2(bllblog, request);
		
         model = new PhotoShowViewModel();
      
         SqlSession session=MybatisHelper.getSession();
 		IDalAlbum dal=session.getMapper(IDalAlbum.class);
 		List<blog_tb_photo> list=dal.queryPhotos(albumID);
 		
 		blog_tb_album album = dal.getAlbumEntity(albumID);
 		 session.close();
 		 
         model.setPhotoCollection(list);

         model.setTitle ( album.getDisplay() + "-" + basemodel.getTitle());
         if(list.size()>0)
         {
        	 model.setCurrentUrl(list.get(0).getUrl());
        	 model.setCurrentThumbUrl(list.get(0).getThumbUrl());
         }
         
   
         map.put("basemodel", basemodel);
	     map.put("model", model);
         
	     return "/themes/album/photoshow";
	}
	
	@RequestMapping(value={"/Album/ArtilePhotoShow","/album/artilephotoshow"})
	public String articlePhotoShow(PhotoShowViewModel model, Map<String, Object> map) throws Exception
	{
		String articleID=request.getParameter("articleID");
		String uri=URLDecoder.decode(request.getParameter("uri"), "utf8");
		
		BaseViewModel basemodel= ControllerHelper.GetBaseViewModel2(bllblog, request);
		blog_tb_article article=articlebll.GetSingle(articleID);
		
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
		
        model = new PhotoShowViewModel();
     
        SqlSession session=MybatisHelper.getFilesSession();
		IDalFiles dal=session.getMapper(IDalFiles.class);
		List<blog_tb_photo> list=dal.getArticlePhotos(articleID);

		 session.close();
		 
		 if(list==null||list.size()==0){
			 request.setAttribute("msg", "没有查询到文章图片");
				return "/result";
		 }
		 
        model.setPhotoCollection(list);

        for(blog_tb_photo p:list)
        {
        	if(p.getThumbUrl()==null||p.getThumbUrl().equals(""))
        	{
        		p.setThumbUrl(p.getUrl());
        	}
        	
        	if(p.getThumbUrl().equals(uri)||p.getUrl().equals(uri))
        	{
        		model.setCurrentThumbUrl(p.getThumbUrl());
        		model.setCurrentUrl(p.getUrl());
        	}
        }
        
        if(list.size()>0)
        {
        	 if(model.getCurrentThumbUrl()==null)
             {
             	model.setCurrentThumbUrl(list.get(0).getThumbUrl());
             }
        	 
        	 if(model.getCurrentUrl()==null)
             {
             	model.setCurrentUrl(list.get(0).getUrl());
             }
        }
       
        
        model.setTitle (article.getArticleTitle() + " - 查看图片 - " + basemodel.getTitle());

  
        map.put("basemodel", basemodel);
	     map.put("model", model);
        
	     return "/themes/album/photoshow";
	}
	

	@RequestMapping(value={"/Exif","/exif"})
	@ResponseBody
	public String exif() throws Exception
	{
		return "";
	}
}
