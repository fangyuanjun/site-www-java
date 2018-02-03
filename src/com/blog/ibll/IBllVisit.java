package com.blog.ibll;

import com.blog.entity.blog_tb_Visit;

public interface IBllVisit {

	/**
	 * 添加统计
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public int addVisit(blog_tb_Visit entity) throws Exception;
}
