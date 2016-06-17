#[Servlet基础及相关](http://blog.csdn.net/zjf280441589/article/details/51247469)
##[Servlet](http://blog.csdn.net/zjf280441589/article/details/51247469)
+ Http请求(Brower)及响应(WebServer)语法
+ Tomcat(WebServer)
+ Servlet
	+ HttpServletRequest
		+ 对于每一个HTTP请求, Servlet容器会在调用`service()`方法时创建Request实例并传递给`service()`的形参, HttpServletRequest是Request在HTTP环境下的实例,其封装了有关请求的信息:
			+ 封装请求头信息
			+ 封装请求正文数据(GET没有正文)
			+ 提供请求转发/包含功能：(Request提供了getRequestDispatcher()来获取一个`RequestDispatcher`, 并由其提供请求转发/请求包含功能；**请求转发/请求包含都是由多个Servlet协作完成一个请求, 因此需要从一个Servlet中跳到另一个Servlet中**)
				+ 请求转发`forward`: 原Servlet只会保留设置的响应头信息
				+ 请求包含`include`: 原Servlet既会保留响应头, 还会保留响应体内容
				+ **注意** 请求转发时, 可能会因为原Servlet设置了过多的响应体内容导致抛出异常`java.lang.IllegalStateException: Cannot forward after response has been committed`
			+ 作为域对象, 可以传递数据

##Filter
