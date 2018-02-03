package com.blog.idal;

import java.util.List;

import com.blog.entity.blog_tb_photo;

public interface IDalFiles {
   
	/**
	 * 获取文章的图片
	 * @param articleID
	 * @return
	 */
	public List<blog_tb_photo> getArticlePhotos(String articleID);
}
