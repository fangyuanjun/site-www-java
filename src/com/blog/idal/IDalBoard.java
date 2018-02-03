package com.blog.idal;

import java.util.List;

import com.blog.entity.blog_tb_board;


public interface IDalBoard {

	public List<blog_tb_board> query();
	
	public  int  insert(blog_tb_board entity); 
	
	//public  int  update(blog_tb_board entity); 
	
	public  int  delete(String id); 
	
	public int updateAgainstCount(String id);
	
	public int updateSupportCount(String id);
}
