package com.blog.model;


    public class CommentTagModel
    {
        private String commentid ;

        private String backgroundColor;

        private int supportCount;

        private String commentText ;

		public String getCommentid() {
			return commentid;
		}

		public void setCommentid(String commentid) {
			this.commentid = commentid;
		}

		public String getBackgroundColor() {
			return backgroundColor;
		}

		public void setBackgroundColor(String backgroundColor) {
			this.backgroundColor = backgroundColor;
		}

		public int getSupportCount() {
			return supportCount;
		}

		public void setSupportCount(int supportCount) {
			this.supportCount = supportCount;
		}

		public String getCommentText() {
			return commentText;
		}

		public void setCommentText(String commentText) {
			this.commentText = commentText;
		}
    }
