#SpringMVC构建过程
##使用Jetty
[jetty-maven-plugin插件官方使用说明文档](https://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html)
http://central.maven.org/maven2/org/eclipse/jetty/jetty-project/
注意使用[插件指定jdk1.8](http://stackoverflow.com/questions/26317973/how-to-make-maven-use-jdk1-8-instead-of-jdk1-6)+maven3.3
![](00_jetty-plugin.png)
##使用slf4j转log4j
设计模式：facade模式和adapter模式
[slf4j官方使用文档](http://www.slf4j.org/manual.html)

##分析SpringMVC与Spring
[深入分析Spring 与 Spring MVC容器](http://my.oschina.net/xianggao/blog/523888?fromerr=TKV6Vjjo)
>1. 在Spring MVC中，Spring Context是以父子的继承结构存在的。Web环境中存在一个**ROOT Context**，这个Context是整个应用的根上下文，是其他context的双亲Context。同时++Spring MVC也对应的持有一个独立的Context，它是ROOT Context的子上下文++。
>ROOT Context是在`ContextLoaderListener`中配置的，ContextLoaderListener读取context-param中的contextConfigLocation指定的配置文件，创建ROOT Context。
`org.springframework.web.context.ContextLoader.properties`
将根上下文放置在**servletContext**中的代码`servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, this.context);`
方法：`org.springframework.context.support.AbstractApplicationContext.refresh() `
>2. Spring MVC启动过程大致分为两个过程：
+ ContextLoaderListener初始化，实例化IoC容器，并将此容器实例注册到ServletContext中；
+ DispatcherServlet初始化
DispatcherServlet继承自HttpServlet，关于Spring Context的配置文件加载和创建是在init()方法中进行的，主要的调用顺序是init=>initServletBean=>initWebApplicationContext。
`org.springframework.web.servlet.FrameworkServlet`中的`wac.setParent(parent);`其中，wac即为由DisptcherServlet创建的ApplicationContext，而parent则为有ContextLoaderListener创建的ApplicationContext。
```java
// Publish the context as a servlet context attribute.
String attrName = getServletContextAttributeName();
getServletContext().setAttribute(attrName, wac);
```
方法：`org.springframework.web.servlet.DispatcherServlet.onRefresh(ApplicationContext context)`

##[Spring下载](https://github.com/spring-projects/spring-framework/releases/)
手动构建：https://github.com/spring-projects/spring-framework/wiki/Building-a-distribution-with-dependencies
###Gradle
[下载Gradle](http://gradle.org/gradle-download/)
[下载Groovy](http://groovy-lang.org/download.html)