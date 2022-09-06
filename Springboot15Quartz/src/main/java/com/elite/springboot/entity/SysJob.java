package com.elite.springboot.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Data
@TableName("`sys_job`")
public class SysJob implements Serializable {
    @TableId(value = "job_id",type = IdType.AUTO )
    private Integer jobId;
    //任务类
    @TableField(value = "job_class")
    private String jobClass;
    //定时任务表达式
    @TableField(value = "job_cron")
    private String jobCron;
    //任务参数
    @TableField(value = "job_params")
    private String jobParams;
    //任务描述
    @TableField(value = "job_desc")
    private String jobDesc;
    //任务状态 1 正常 0 停止
    private String jobStatus;
    //是否逻辑删除
    @TableLogic
    @TableField(value = "del_flag")
    private String delFlag;
    //创建人
    @TableField(value = "create_by")
    private String createBy;
    //创建时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private String createTime;
    //更新人
    @TableField(value = "update_by")
    private String updateBy;
    //更新时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private String updateTime;
}
