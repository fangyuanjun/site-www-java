package com.blog.bll;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.blog.entity.blog_tb_comment;
import com.blog.ibll.IBllComment;
import com.blog.idal.IDalComment;

public class BllComment implements IBllComment {

	
	private IDalComment dal;
	public void setDal(IDalComment dal)
	{
		this.dal=dal;
	}
	
	
	@Override
	public boolean isAllowCommentContent(String commentContent) {
		// TODO Auto-generated method stub

		String[] htmltaglist = { "html", "script", "link", "img" };

		for (String s : htmltaglist) {
			Pattern pattern = Pattern.compile("<\\s*?" + s);
			Matcher m = pattern.matcher(commentContent.toLowerCase());
			if (m.find()) {
				return false;
			}
		}

		String sqlwordlist[] = { "select", "update", "delete", "drop", "html",
				"script", "create", "table" };
		for (String s : sqlwordlist) {
			Pattern pattern = Pattern.compile(s);
			Matcher m = pattern.matcher(commentContent.toLowerCase());
			if (m.find()) {
				return false;
			}

		}

		return true;
	}

	@Override
	public int insert(blog_tb_comment entity) throws Exception {
		// TODO Auto-generated method stub
		return dal.insert(entity);
	}

}
