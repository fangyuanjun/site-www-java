package com.blog.bll;

import com.blog.entity.blog_tb_Visit;
import com.blog.ibll.IBllVisit;
import com.blog.idal.IDalVisit;

public class BllVisit implements IBllVisit{

	private IDalVisit dal;
	
	public void setDal(IDalVisit dal) {
		this.dal = dal;
	}

	@Override
	public int addVisit(blog_tb_Visit entity) throws Exception {
		// TODO Auto-generated method stub
		return dal.addVisit(entity);
	}

}
