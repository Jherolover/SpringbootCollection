package com.elite.springboot.shcedule;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
@Configuration
@EnableScheduling
public class SimpleSchedule {
    //每五秒执行一次
    @Scheduled(cron="*/5 * * * * ?")
    public void schedule(){
        System.out.println("执行定时任务..."+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
