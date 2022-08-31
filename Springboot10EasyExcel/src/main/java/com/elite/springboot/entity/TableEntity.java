package com.elite.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * 实体表信息
 */
@Data
@TableName("`table_entity`")
public class TableEntity {

    @TableId(value = "table_id", type = IdType.AUTO)
    private Integer tableId;
    //表名
    @TableField(value = "table_name")
    private String tableName;
    //表注释
    @TableField(value = "table_comment")
    private String tableComment;
    //数据库名
    @TableField(value = "db_name")
    private String databaseName;
    //数据库类型 ORACLE,MSSQL,MYSQL
    @TableField(value = "db_type")
    private String databaseType;

    //数据库SCHEMA
    @TableField(value = "table_schema")
    private String tableSchema;

    //实体列名字
    private List<ColumnEntity> tableColumns;

}
