package me.fyj.favorite;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kecq.Servlet.ServletAbstract;
import com.kecq.data.DbFactory;
import com.kecq.data.IDbHelper;
import com.kecq.data.mongo.MongoHelper;
import com.kecq.flexigrid.Flexigrid;
import com.kecq.index.IndexService;
import com.mongodb.DB;

public class FavoriteServlet  extends ServletAbstract{ 

private void updateMongo(HttpServletRequest request, HttpServletResponse response) throws UnknownHostException
{
	DB db=MongoHelper.GetMongoDB(request);
	IndexService index=new IndexService(db);
	List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();

		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", request.getParameter("id"));
		map.put("userid", request.getParameter("userid"));
		map.put("blogid", request.getParameter("blogid"));
		map.put("classname", request.getParameter("classname"));
		map.put("ishidden", request.getParameter("ishidden"));
		map.put("title", request.getParameter("title"));
		map.put("url", request.getParameter("url"));
		map.put("datetime", request.getParameter("datetime"));
		map.put("content", request.getParameter("content"));
		list.add(map);
	
		String str=	index.Update(list,"id");
		//out.print(str);
}
	
	@Override
	public String GetTableName() {
		// TODO Auto-generated method stub
		return "my_tb_favorite";
	}


	@Override
	public String GetPrimaryKey() {
		// TODO Auto-generated method stub
		return "favoriteID";
	}


	@Override
	public String GetUserIDKey() {
		// TODO Auto-generated method stub
		return "userID";
	}


	@Override
	public String[] GetSelectColumns() {
		// TODO Auto-generated method stub
		return new String[]{"favoriteID","cateID","favoriteIco","favoriteTitle","favoriteUrl","favoriteOrder","ADD_DATE","UPDATE_DATE"};
	}

	@Override
	public boolean BeforeDo(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return true;
	}
}
