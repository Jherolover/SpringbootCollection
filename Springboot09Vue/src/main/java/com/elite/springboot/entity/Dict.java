package com.elite.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author elite
 * @since 2022-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("`dict`")
public class Dict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "dict_id", type = IdType.AUTO)
    private Integer dictId;

    /**
     * 字典类别
     */
    @TableField("dict_type")
    private Integer dictType;

    /**
     * 代码值
     */
    @TableField("dict_code")
    private String dictCode;

    /**
     * 代码名称
     */
    @TableField("dict_name")
    private String dictName;

    /**
     * 父节点
     */
    @TableField("dict_parent")
    private Integer dictParent;

    /**
     * 字典状态
     */
    @TableField("dict_status")
    private String dictStatus;

    /**
     * 创建人
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    @TableField("update_by")
    private String updateBy;


}
