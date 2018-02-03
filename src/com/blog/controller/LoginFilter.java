package com.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	private FilterConfig config;

	/**
	 * Default constructor.
	 */
	public LoginFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.config = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		String url = request.getRequestURL().toString();
		String basePath = request.getScheme()
				+ "://"
				+ request.getServerName()
				+ (request.getServerPort() == 80 ? "" : ":"
						+ request.getServerPort()) + request.getContextPath();
		// 登录页面
		String loginUrl = basePath + this.config.getInitParameter("loginUrl");

		// 不拦截的页面，中间用逗号隔开
		String noFilterFile = this.config.getInitParameter("noFilter");
		for (String s : noFilterFile.split(",")) {
			//如果是后綴名
			if (s.contains("*")) {  
               if(request.getServletPath().startsWith(s.substring(0,s.indexOf("*")))&&
            		   request.getServletPath().endsWith(s.substring(s.indexOf("*")+1)))
               {
            		chain.doFilter(request, response);
					return;
               }
			} else {
				if (url.startsWith(basePath + s)) {
					chain.doFilter(request, response);
					return;
				}
			}
		}

		// 要拦截的页面
		String filterPath = this.config.getInitParameter("filter");
		for (String s : filterPath.split(",")) {
			//如果是后綴名
			if (s.contains("*")) {  
               if(request.getServletPath().startsWith(s.substring(0,s.indexOf("*")))&&
            		   request.getServletPath().endsWith(s.substring(s.indexOf("*")+1)))
               {
            		if (session.getAttribute("userID") == null) {
            			 PrintWriter out = response.getWriter();
           			     out.print("not login");
           			     out.close();
           			     return;
					}
               }
			} else {
				if (url.startsWith(basePath + s)) {
					if (session.getAttribute("userID") == null) {
						HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(response);
						wrapper.sendRedirect(loginUrl+ "?back="+ URLEncoder.encode(request.getRequestURL().toString(), "utf-8"));
						return;
					}
				}
			}
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = fConfig;
	}

}
