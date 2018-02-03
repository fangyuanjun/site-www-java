package com.blog.viewmodel;

import java.util.List;

import com.blog.model.AlbumModel;

    public class AlbumViewModel
    {

        public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
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

		public List<AlbumModel> getAlbumCollection() {
			return albumCollection;
		}

		public void setAlbumCollection(List<AlbumModel> albumCollection) {
			this.albumCollection = albumCollection;
		}

		public String title ;


        public  String keywords ;

 
        public  String description ;

        /**
         * 相册集合
         */
        public List<AlbumModel> albumCollection;
    }
