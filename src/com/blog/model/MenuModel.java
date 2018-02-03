package com.blog.model;


import com.kecq.common.StringEx;

public class MenuModel {
	private String menuID;
	private String parentID;
	private String menuName;
	private String menuDisplay;
	private String menuUrl;
	private String menuPic;
	private int menuOrder;
	private String menuTarget;
	private boolean isActive;
	private String basePath;
	
	
	public String getMenuID() {
		return menuID;
	}

	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuDisplay() {
		return menuDisplay;
	}

	public void setMenuDisplay(String menuDisplay) {
		this.menuDisplay = menuDisplay;
	}

	public String getMenuPic() {
		return menuPic;
	}

	public void setMenuPic(String menuPic) {
		this.menuPic = menuPic;
	}

	public int getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getMenuTarget() {
		return menuTarget;
	}

	public void setMenuTarget(String menuTarget) {
		this.menuTarget = menuTarget;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}



	public String getMenuUrl() throws Exception {

		if (menuUrl != null && !menuUrl.equals("")) {
			if (!menuUrl.startsWith("http")) {
				if (basePath != null && !basePath.equals("")) {
					return basePath + "/"
							+ StringEx.trimStart(menuUrl, "/");
				}

				return "/" + StringEx.trimStart(menuUrl, "/");
			}
		}

		return menuUrl;
	}

	public void setMenuUrl(String value) {
		menuUrl = value;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	
}
