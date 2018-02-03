package com.blog.idal;

import com.blog.entity.blog_tb_Visit;

public interface IDalVisit {

	/**
	 * 添加统计
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public int addVisit(blog_tb_Visit entity) throws Exception;
}
