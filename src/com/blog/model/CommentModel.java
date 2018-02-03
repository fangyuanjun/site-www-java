package com.blog.model;

public class CommentModel extends com.blog.entity.blog_tb_comment {
	private String commentID;
	
	private String author;

	private String mark;

	private String commentContent2;

	public String getAuthor() {
		return author;
	}

	public String getCommentID() {
		return commentID;
	}

	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getCommentContent2() {
		return commentContent2;
	}

	public void setCommentContent2(String commentContent2) {
		this.commentContent2 = commentContent2;
	}

}
