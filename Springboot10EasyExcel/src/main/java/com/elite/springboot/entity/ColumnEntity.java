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
import lombok.Value;

/**
 * 列信息实体类
 */
@Data
@TableName("`column_entity`")
public class ColumnEntity {
    @TableId(value = "column_id", type = IdType.AUTO)
    @ExcelProperty(value="序号")
    private Integer columnId;
    //表的ID
    @ExcelProperty(value="表名ID")
    @TableField("table_id")
    private Integer tableId;
    //列名
    @ExcelProperty(value="列名")
    @TableField("column_name")
    private String columnName;
    //列注释
    @ExcelProperty(value="列注释")
    @TableField("column_desc")
    private String ColumnDesc;
    //类型
    @ExcelProperty(value="数据类型")
    @TableField("column_type")
    private String columnType;
    //长度
    @ExcelProperty(value="长度")
    @TableField("column_len")
    private String columnLen;
    //精度
    @ExcelProperty(value="精度")
    @TableField("precision")
    private String precision;
    //是否主键 Y true 都默认是主键
    @ExcelProperty(value="是否主键")
    @TableField("isPrimaryKey")
    private String isPrimaryKey;
    //是否允许为空 Y true 不允许为空
    @ExcelProperty(value="是否允许为空")
    @TableField("isNotNull")
    private String isNotNull;
    //是否索引列，方便进行生成建表语句的时候进行生成索引
    @ExcelProperty(value="是否索引列")
    @TableField("isIdxCol")
    private String isIdxCol;
}
