package com.blog.idal;

import java.util.List;

import com.blog.entity.blog_tb_album;
import com.blog.entity.blog_tb_photo;
import com.blog.model.AlbumModel;

public interface IDalAlbum {

	/**
	 * 查询用户的相册
	 * @param userID
	 * @return
	 */
	public List<AlbumModel> queryAlbum(String userID);
	
	/**
	 * 查询相册中的图片
	 * @param albumID
	 * @return
	 */
	public List<blog_tb_photo> queryPhotos(String albumID);
	
	/**
	 * 获取单个相册实体
	 * @param albumID
	 * @return
	 */
	public blog_tb_album getAlbumEntity(String albumID);
}
