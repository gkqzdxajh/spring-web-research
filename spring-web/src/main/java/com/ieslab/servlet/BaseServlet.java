package com.ieslab.servlet;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/** 
 * 文件名: BaseServlet <p>
 * 功能说明: Servlet容器(如Tomcat)会把Servlet类加载到内存并生成唯一实例,当有请求到来时调用其方法. <p> 
 * <ul>
 * 	<li>&lt;url-pattern/&gt;用来指定Servlet的访问路径,<b>必须以/开头</b>
 * 	<li>&lt;load-on-startup/*gt;元素: 让容器在启动时就创建该Servlet实例(调用init()方法),注意此元素的值必须是>=0的整数,它代表容器启动时创建Servlet实例的顺序.
 * </ul>
 * 创建时间: 2016年6月16日 下午6:52:49 <p> 
 * @author 郭凯强
 * @version 0.0.1 
 * @since JDK 1.7  
 */
public class BaseServlet implements Servlet {
	/* 1.参考源码：http://blog.csdn.net/zjf280441589/article/details/51247469#t13 */
	/**将init()方法中的ServletConfig赋给一个实例变量, 使他可以通过getServletConfig()来获取.*/
	// private GenericServlet genericServlet;
	/**提供了对HTTP协议的支持.覆盖了GenericServlet的service()方法,并新增了接受HttpServletRequest/HttpServletResponse参数的service()方法*/
	// private HttpServlet httpServlet;
	
	/* 2.实现javax.servlet.Servlet接口 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("在第一次请求该Servlet(默认)或容器启动时, Servlet容器就会调用init(), 且只调用一次");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("每次请求Servlet都会调用该方法");
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("销毁Servlet时(卸载应用/关闭容器时), 调用该方法");
	}
}
