package com.blog.model;


    public class LinkModel
    {
        private String linkID ;
        private int blogID;
        private String linkName ;
        private String linkUrl ;
        private String linkPic ;
        private int linkOrder ;
        private boolean menuIsDisabled ;
		public String getLinkID() {
			return linkID;
		}
		public void setLinkID(String linkID) {
			this.linkID = linkID;
		}
		public int getBlogID() {
			return blogID;
		}
		public void setBlogID(int blogID) {
			this.blogID = blogID;
		}
		public String getLinkName() {
			return linkName;
		}
		public void setLinkName(String linkName) {
			this.linkName = linkName;
		}
		public String getLinkUrl() {
			return linkUrl;
		}
		public void setLinkUrl(String linkUrl) {
			this.linkUrl = linkUrl;
		}
		public String getLinkPic() {
			return linkPic;
		}
		public void setLinkPic(String linkPic) {
			this.linkPic = linkPic;
		}
		public int getLinkOrder() {
			return linkOrder;
		}
		public void setLinkOrder(int linkOrder) {
			this.linkOrder = linkOrder;
		}
		public boolean isMenuIsDisabled() {
			return menuIsDisabled;
		}
		public void setMenuIsDisabled(boolean menuIsDisabled) {
			this.menuIsDisabled = menuIsDisabled;
		}

    }
