package me.fyj.user;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kecq.common.HttpHelper;
import com.kecq.common.JsonHelper;

/**
 * Servlet implementation class ValCodeServlet
 */
@WebServlet("/valcode.do")
public class ValCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  HttpSession session = request.getSession();
		  PrintWriter out = response.getWriter();
		  try
		  {
		  InputStream st=HttpHelper.DoGet("http://ac.ztku.com/service/ValidateCode.aspx");
		  //这个方法会关闭流
		 byte[] buffer=HttpHelper.readInStream(st);
		  byte[] temp=new byte[100];
		  for(int i=0;i<temp.length;i++)
		  {
			  temp[i]=buffer[i];
		  }
		  String str=new String(temp,"utf-8");
		  Map<String,Object> map=JsonHelper.jsonToMap(str, false).get(0);
		  str=map.get("code").toString();
		  session.setAttribute("valcode", str);
		 
			response.setContentType("image/gif");
			// 设置页面不缓存
			  response.setHeader("Pragma", "No-cache");
			  response.setHeader("Cache-Control", "no-cache");
			  response.setDateHeader("Expires", 0);
			  
		  InputStream buffin = new ByteArrayInputStream(buffer,100,buffer.length); 
		  // 创建内存图像
		  BufferedImage image = ImageIO.read(buffin); 
		  response.reset();
		// 输出图象到页面
		  OutputStream os=response.getOutputStream();  
		  ImageIO.write(image, "GIF", os);
		  os.close();
		  }
		  catch(Exception ex)
		  {
			  out.print(ex.getMessage());
		  }
		  finally
		  {
            out.close();
		  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response); 
	}

}
