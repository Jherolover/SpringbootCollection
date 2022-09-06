package com.elite.springboot;

import static org.junit.Assert.assertTrue;

import com.elite.springboot.entity.SysJob;
import com.elite.springboot.service.ISysJobService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest 
{
    @Autowired
    ISysJobService sysJobService;
    /**
     * 添加任务
     */
    @Test
    public void addJob()
    {
        SysJob sysJob = new SysJob();
        sysJob.setJobClass("com.elite.springboot.task.SysJob1");
        sysJob.setJobCron("*/2 * * * * ?");
        sysJob.setJobParams("");
        sysJob.setJobDesc("2秒中一次定时执行任务sysjob1");
        sysJob.setJobStatus("1"); //正常
        sysJobService.saveSysJob(sysJob);
    }
}
