package com.elite.springboot.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SysJob1 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("执行定时任务SysJob1..."+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
