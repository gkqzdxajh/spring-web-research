package com.ieslab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * 文件名: ScheduleTaskTest <p>
 * 功能说明: 调度任务测试，不能使用JUnit来测试，其仅执行一个方法，方法执行完之后就结束了.<p>
 * cron:计划任务，是任务在约定的时间执行已经计划好的工作，这是表面的意思。在Linux中，我们经常用到 cron 服务器来完成这项工作。cron服务器可以根据配置文件约定的时间来执行特定的作务 <p>  <p> 
 * 创建时间: 2016年6月16日 下午1:47:45 <p> 
 * @author 郭凯强
 * @version 0.0.1 
 * @since JDK 1.7  
 */
public class ScheduleTaskTest {
	public static void main(String[] args) {
		/*//JDK1.7的写法
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml")) {
			boolean containsBean = context.containsBean("ScheduleTask");
			System.out.println("applicationName=" + context.getApplicationName());
			System.out.println("containsBean=" + containsBean);
		}*/
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-beans.xml");
		System.out.println("applicationName="+context.getApplicationName());
	}
}
