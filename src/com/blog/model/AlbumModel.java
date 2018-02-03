package com.blog.model;

import java.util.List;


    public class AlbumModel
    {
        private String display ;

        private int photoCount ;

        private String id ;

        private List<String> photos;

        private String coverUrl;
        
		public String getCoverUrl() {
			return coverUrl;
		}

		public void setCoverUrl(String coverUrl) {
			this.coverUrl = coverUrl;
		}

		public String getDisplay() {
			return display;
		}

		public void setDisplay(String display) {
			this.display = display;
		}

		public int getPhotoCount() {
			return photoCount;
		}

		public void setPhotoCount(int photoCount) {
			this.photoCount = photoCount;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public List<String> getPhotos() {
			return photos;
		}

		public void setPhotos(List<String> photos) {
			this.photos = photos;
		}

		
    }
