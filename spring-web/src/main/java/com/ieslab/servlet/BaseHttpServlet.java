package com.ieslab.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * 文件名: BaseHttpServlet <p>
 * 功能说明: Request/Response向下转型总会成功:因为在调用service()方法时,Servlet容器总会预计使用HTTP,从而直接创建并传递HttpServletRequest/HttpServletResponse实例. <p> 
 * 创建时间: 2016年6月16日 下午7:24:04 <p> 
 * @author 郭凯强
 * @version 0.0.1 
 * @since JDK 1.7  
 */
@WebServlet(asyncSupported = true, displayName = "display-baseWebServlet", description = "base httpservlet by guokaiqiang", initParams = {
		@WebInitParam(name = "owner", value = "gkq"), @WebInitParam(name = "goddess", value = "ljl") }, loadOnStartup = 0, name = "baseHttpServlet", urlPatterns = {
		"/base/*", "/first/web/*" })
public class BaseHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// super.init();
		System.out.println("在第一次请求该Servlet(默认)或容器启动时, Servlet容器就会调用init(), 且只调用一次");
	}

	@Override
	public void destroy() {
		// super.destroy();
		System.out.println("销毁Servlet时(卸载应用/关闭容器时), 调用该方法");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseHttpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request-1:获取请求头
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			System.out.println(headerName + "=" + request.getHeader(headerName));
		}
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getContextPath());
		System.out.println(request.getDateHeader("date"));
		// request-2:获取请求参数?
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
		// request-3:请求转发/包含=Request提供了getRequestDispatcher()来获取一个RequestDispatcher,
		// 并由其提供请求转发/请求包含功能
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(request, response);
		// request-4:域对象传递数据
		request.setAttribute("myname", "gkq");
		Enumeration<String> attrNames = request.getAttributeNames();
		while (attrNames.hasMoreElements()) {
			String attrName = (String) attrNames.nextElement();
			System.out.println(attrName + "---" + request.getAttribute(attrName));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
	}
}
