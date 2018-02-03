package com.blog.idal;

import com.blog.entity.blog_tb_comment;

public interface IDalComment {

	/**
	 * 插入评论
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public int insert(blog_tb_comment entity) throws Exception;
}
