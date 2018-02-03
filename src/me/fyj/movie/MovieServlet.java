package me.fyj.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kecq.Servlet.ServletAbstract;

public class MovieServlet extends ServletAbstract {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String GetTableName() {
		// TODO Auto-generated method stub
		return "my_tb_movie";
	}

	@Override
	public String GetPrimaryKey() {
		// TODO Auto-generated method stub
		return "movieID";
	}

	@Override
	public String[] GetSelectColumns() {
		// TODO Auto-generated method stub
		String[] columns = new String[] { "movieID", "movieName","country", "year", "movieClass", "movieActor","fileName", "ADD_DATE","UPDATE_DATE" };
		return columns;
	}
	
	
	
	@Override
	public boolean BeforeDo(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		//List<String> list = new ArrayList<String>();
		//list.add(ids);
		//list.add(request.getSession().getAttribute("userID").toString());
		return true;
	}

	@Override
	public String GetUserIDKey() {
		// TODO Auto-generated method stub
		return "userID";
	}

}
