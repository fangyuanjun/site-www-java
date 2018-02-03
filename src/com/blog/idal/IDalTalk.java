package com.blog.idal;

import java.util.List;

import com.blog.entity.blog_tb_talk;

public interface IDalTalk {
  
	public List<blog_tb_talk> query(String userID);
}
