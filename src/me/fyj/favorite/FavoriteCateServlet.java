package me.fyj.favorite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kecq.Servlet.ServletAbstract;

public class FavoriteCateServlet  extends ServletAbstract{

	@Override
	public String GetTableName() {
		// TODO Auto-generated method stub
		return "my_tb_favoritecate";
	}

	@Override
	public String GetPrimaryKey() {
		// TODO Auto-generated method stub
		return "cateID";
	}

	@Override
	public String GetUserIDKey() {
		// TODO Auto-generated method stub
		return "userID";
	}

	@Override
	public String[] GetSelectColumns() {
		// TODO Auto-generated method stub
		return new String[]{"cateID","blogID","cateName","UPDATE_DATE","ADD_DATE"};
	}

	@Override
	public boolean BeforeDo(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return true;
	}

}
