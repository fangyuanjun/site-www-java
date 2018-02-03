package com.blog.viewmodel;

import java.util.List;

import com.blog.model.ArticleModel;
    public class NoteViewModel 
    {
        private List<ArticleModel> listArticleCollection ;

		public List<ArticleModel> getListArticleCollection() {
			return listArticleCollection;
		}

		public void setListArticleCollection(List<ArticleModel> listArticleCollection) {
			this.listArticleCollection = listArticleCollection;
		}

    }
