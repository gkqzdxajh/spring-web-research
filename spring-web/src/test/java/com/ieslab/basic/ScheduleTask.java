package com.ieslab.basic;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/** 
 * 文件名: ScheduleTask <p>
 * 功能说明: 调度任务类. <p> 
 * 创建时间: 2016年6月16日 上午11:36:06 <p> 
 * @author 郭凯强
 * @version 0.0.1 
 * @since JDK 1.7  
 */
@Component
public class ScheduleTask {
	@Scheduled(cron = "*/5 * * * * *")
	public void myTask() {
		System.out.println(new Date());
	}
}
