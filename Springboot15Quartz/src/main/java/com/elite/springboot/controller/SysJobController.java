package com.elite.springboot.controller;

import com.elite.springboot.entity.SysJob;
import com.elite.springboot.service.ISysJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysJobController {

    @Autowired
    ISysJobService sysJobService;
    //添加任务
    @GetMapping("/saveSysJob")
    void saveSysJob(){
        SysJob sysJob = new SysJob();
        sysJob.setJobClass("com.elite.springboot.task.SysJob2");
        sysJob.setJobCron("*/2 * * * * ?");
        sysJob.setJobParams("");
        sysJob.setJobDesc("2秒中一次定时执行任务sysjob2");
        sysJob.setJobStatus("1"); //正常
        sysJobService.saveSysJob(sysJob);
    }

    //更新任务
    @GetMapping("/updateSysJob")
    void updateSysJob(){
        SysJob sysJob = new SysJob();
        sysJob.setJobId(1);
        sysJob.setJobClass("com.elite.springboot.task.SysJob1");
        sysJob.setJobCron("*/3 * * * * ?");
        sysJob.setJobParams("");
        sysJob.setJobDesc("2秒中一次定时执行任务sysjob1");
        sysJob.setJobStatus("1"); //正常
        sysJobService.updateSysJob(sysJob);
    }

    //删除任务
    void delSysJob(SysJob job){

    }

    //启动任务
    void restartSysJob(SysJob job){

    }

    //停止任务
    void stopSysJob(SysJob job){

    }



}
