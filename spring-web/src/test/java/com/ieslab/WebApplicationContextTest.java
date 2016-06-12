package com.ieslab;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.FrameworkServlet;

public class WebApplicationContextTest {
	private WebApplicationContext webApplicationContext;
	private ContextLoaderListener contextLoaderListener;
	// DispatcherServle的初始化
	private FrameworkServlet frameworkServlet;
}
