package com.elite.springboot.entity;

import lombok.Data;

import java.util.List;

/**
 * 实体表信息
 *
 */
@Data
public class TableEntity {
    //表名
    private String tableName;
    //表注释
    private String tableComment;
    //数据库名
    private String databaseName;
    //数据库类型 ORACLE,MSSQL,MYSQL
    private String databaseType;
    //实体列名字
    private List<ColumnEntity> tableColumns;

}
