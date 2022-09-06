package com.elite.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elite.springboot.entity.SysJob;

/**
 * <p>
 * 系统任务服务类 实现任务的增删改查
 * </p>
 */
public interface ISysJobService extends IService<SysJob> {

    //添加任务
    void saveSysJob(SysJob job);

    //更新任务
    void updateSysJob(SysJob job);

    //删除任务
    void delSysJob(SysJob job);

    //启动任务
    void restartSysJob(SysJob job);

    //停止任务
    void stopSysJob(SysJob job);
}