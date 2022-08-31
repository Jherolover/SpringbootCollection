package com.elite.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * 接收前台传入的参数
 */
@Data
public class TableEntityVo {

    //数据库名
    private String dbName;

    //数据库类型
    private String dbType;

    //数据库SCHEMA
    private String schema;

    //sheetNum的个数
    private Integer sheetNum;


}
