package com.blog.viewmodel;

import java.util.List;

import com.blog.entity.blog_tb_photo;
    public class PhotoListViewModel
    {
        /**
         * 标题
         */
        private String title;

        /**
         * 图片列表
         */
        private List<blog_tb_photo> photoCollection;


       /**
        * 关键字
        */
        private String keywords ;

       /**
        * 描述
        */
        private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<blog_tb_photo> getPhotoCollection() {
		return photoCollection;
	}

	public void setPhotoCollection(List<blog_tb_photo> photoCollection) {
		this.photoCollection = photoCollection;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    }
