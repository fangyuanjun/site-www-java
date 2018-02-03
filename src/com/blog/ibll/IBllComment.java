package com.blog.ibll;

import com.blog.entity.blog_tb_comment;

public interface IBllComment {

	/**
	 * 是否为允许的评论内容
	 * @param commentContent
	 * @return
	 */
    boolean isAllowCommentContent(String commentContent);
    
	/**
	 * 插入评论
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public int insert(blog_tb_comment entity) throws Exception;
}
