package com.elite.springboot.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elite.springboot.entity.SysJob;
import com.elite.springboot.mapper.SysJobMapper;
import com.elite.springboot.service.ISysJobService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务表 服务实现类
 * </p>
 */
@Service
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements ISysJobService {

    @Autowired
    BaseMapper baseMapper;

    @Autowired
    private Scheduler scheduler;


    //添加任务
    @Override
    public void saveSysJob(SysJob job){
        //根据状态是否加入定时任务
        if("1".equals(job.getJobStatus())){
            // 定时器添加
            this.addSysJob(job.getJobClass().trim(), job.getJobCron().trim(), job.getJobParams());
        }
        //保存数据库
        baseMapper.insert(job);
    }

    //更新任务
    @Override
    public void updateSysJob(SysJob job){
        //根据状态是否加入定时任务
        if("1".equals(job.getJobStatus())){
            // 定时器添加
            this.addSysJob(job.getJobClass().trim(), job.getJobCron().trim(), job.getJobParams());
        }else{
            //停止定时任务
            this.stopSysJob(job);
        }
        //保存数据库
        baseMapper.updateById(job);
    }

    //删除任务
    @Override
    public void delSysJob(SysJob job){
        this.stopSysJob(job);
        //数据库删除
        baseMapper.deleteById(job.getJobId());
    }

    //启动任务
    @Override
    public void restartSysJob(SysJob job){
         //先停止
         this.stopSysJob(job);
         //在添加任务
         this.addSysJob(job.getJobClass(),job.getJobCron(),job.getJobParams());
    }

    //停止任务
    @Override
    public void stopSysJob(SysJob job){
        try {
            String jobClassName = job.getJobClass();
            //删除触发器
            scheduler.pauseTrigger(TriggerKey.triggerKey(jobClassName));
            scheduler.unscheduleJob(TriggerKey.triggerKey(jobClassName));
            scheduler.deleteJob(JobKey.jobKey(jobClassName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //更新任务状态
        this.updateSysJob(job);
    }
    /**
     * 添加定时任务
     * */
    private void addSysJob(String jobClassName, String cronExpression, String parameter) {
        try {
            // 启动调度器
            scheduler.start();
            // 构建job信息
            JobDetail jobDetail = JobBuilder.newJob(getClass(jobClassName).getClass()).withIdentity(jobClassName).usingJobData("parameter", parameter).build();
            // 表达式调度构建器(即任务执行的时间)
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
            // 按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName).withSchedule(scheduleBuilder).build();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch(Exception e) {
            e.printStackTrace();
      }
    }

    private static Job getClass(String classname) throws Exception {
        Class<?> class1 = Class.forName(classname);
        return (Job) class1.newInstance();
    }


}