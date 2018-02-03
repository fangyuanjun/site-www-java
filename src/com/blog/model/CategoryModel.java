package com.blog.model;


public class CategoryModel {

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public int getBlogID() {
		return blogID;
	}

	public void setBlogID(int blogID) {
		this.blogID = blogID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDisplay() {
		return categoryDisplay;
	}

	public void setCategoryDisplay(String categoryDisplay) {
		this.categoryDisplay = categoryDisplay;
	}

	public int getCategoryOrderWeight() {
		return categoryOrderWeight;
	}

	public void setCategoryOrderWeight(int categoryOrderWeight) {
		this.categoryOrderWeight = categoryOrderWeight;
	}

	public String getCategoryPic() {
		return categoryPic;
	}

	public void setCategoryPic(String categoryPic) {
		this.categoryPic = categoryPic;
	}

	public String getCategoryKeywords() {
		return categoryKeywords;
	}

	public void setCategoryKeywords(String categoryKeywords) {
		this.categoryKeywords = categoryKeywords;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryDomain() {
		return categoryDomain;
	}

	public void setCategoryDomain(String categoryDomain) {
		this.categoryDomain = categoryDomain;
	}

	public boolean isCategoryIsDisabled() {
		return categoryIsDisabled;
	}

	public void setCategoryIsDisabled(boolean categoryIsDisabled) {
		this.categoryIsDisabled = categoryIsDisabled;
	}

	public String getThemeID() {
		return themeID;
	}

	public void setThemeID(String themeID) {
		this.themeID = themeID;
	}

	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public CategoryModel[] getChildren() {
		return children;
	}

	public void setChildren(CategoryModel[] children) {
		this.children = children;
	}


	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	private int categoryID;
	private int parentID;
	private int blogID;
	private String categoryName;
	private String categoryDisplay;
	private int categoryOrderWeight;
	private String categoryPic;
	private String categoryKeywords;
	private String categoryDescription;
	private String categoryDomain;
	private boolean categoryIsDisabled;
	private String themeID;

	private String state;

	private String iconCls;

	private CategoryModel[] children;

	private String basePath;

	/**
	 * 拥有的文章总数
	 */
	private int ArticleCount;

	private String url;

	public String getUrl() {
		if (url != null && !url.equals("")) {
			return url;
		}

		if (categoryDomain != null && !categoryDomain.equals("")) {
			return "http://" + categoryDomain;
		}

		if (basePath != null && !basePath.equals("")) {
			return  basePath + "/cate-" + categoryID + "-1.html";
		}

		return "/cate-" + categoryID + "-1.html";
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

}
