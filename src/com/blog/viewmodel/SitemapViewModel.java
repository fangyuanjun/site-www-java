package com.blog.viewmodel;

import java.util.List;

import com.blog.model.ArticleModel;
import com.blog.model.CategoryModel;
import com.blog.model.MenuModel;
import com.blog.model.MonthModel;

public class SitemapViewModel {

	private List<MenuModel>  menu;
	
	private List<CategoryModel> category;
	
	private List<MonthModel> month;
	
	private List<ArticleModel> article;
	
	public List<CategoryModel> getCategory() {
		return category;
	}

	public void setCategory(List<CategoryModel> category) {
		this.category = category;
	}

	public List<MonthModel> getMonth() {
		return month;
	}

	public void setMonth(List<MonthModel> month) {
		this.month = month;
	}

	public List<ArticleModel> getArticle() {
		return article;
	}

	public void setArticle(List<ArticleModel> article) {
		this.article = article;
	}

	public List<MenuModel> getMenu() {
		return menu;
	}

	public void setMenu(List<MenuModel> menu) {
		this.menu = menu;
	}

	
}
