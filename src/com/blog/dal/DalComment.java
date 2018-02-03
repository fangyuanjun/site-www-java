package com.blog.dal;

import com.blog.entity.blog_tb_article;
import com.blog.entity.blog_tb_comment;
import com.blog.idal.IDalComment;
import com.kecq.data.EntityHelperG;

public class DalComment extends DalBase implements IDalComment{

	@Override
	public int insert(blog_tb_comment entity) throws Exception {
		EntityHelperG<blog_tb_comment> h = new EntityHelperG<blog_tb_comment>(
				blog_tb_article.class, "blog_tb_comment", true,
				this.getIDbHelper(), "commentID");
	
		return h.insert(entity);
	}

}
