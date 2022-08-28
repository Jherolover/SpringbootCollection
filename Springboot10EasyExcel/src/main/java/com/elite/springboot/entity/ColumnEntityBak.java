package com.elite.springboot.entity;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsAutoIncrement;
import com.gitee.sunchenbin.mybatis.actable.annotation.IsKey;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;

/**
 * 列信息实体类
 */
@Data
@TableName("ColumnEntity")
@Table(name="ColumnEntity")
public class ColumnEntityBak {
    @TableId(value = "column_id", type = IdType.AUTO)
    @IsAutoIncrement   //自增
    @IsKey             //actable主键注解
    @Column(name="column_id",comment = "用户ID")//对应数据库字段，不配置name会直接采用属性名作为字段名comment是注解
    @ExcelProperty(value="序号")
    private String columnId;
    //列名
    @ExcelProperty(value="列名")
    @TableField("column_name")
    @Column(name="column_name",comment = "列名")
    private String columnName;
    //列注释
    @ExcelProperty(value="列注释")
    @TableField("column_desc")
    @Column(name="column_desc",comment = "列注释")
    private String ColumnDesc;
    //类型
    @ExcelProperty(value="数据类型")
    @TableField("column_type")
    @Column(name="column_type",comment = "数据类型")
    private String columnType;
    //长度
    @ExcelProperty(value="长度")
    @TableField("column_len")
    @Column(name="column_len",comment = "长度")
    private String columnLen;
    //精度
    @ExcelProperty(value="精度")
    @TableField("precision")
    @Column(name="precision",comment = "精度")
    private String precision;
    //是否主键 Y true 都默认是主键
    @ExcelProperty(value="是否主键")
    @TableField("isPrimaryKey")
    @Column(name="isPrimaryKey",comment = "是否主键")
    private String isPrimaryKey;
    //是否允许为空 Y true 不允许为空
    @ExcelProperty(value="是否允许为空")
    @TableField("isNotNull")
    @Column(name="isNotNull",comment = "是否允许为空")
    private String isNotNull;
    //是否索引列，方便进行生成建表语句的时候进行生成索引
    @ExcelProperty(value="是否索引列")
    @TableField("isIdxCol")
    @Column(name="isIdxCol",comment = "是否索引列")
    private String isIdxCol;
}
