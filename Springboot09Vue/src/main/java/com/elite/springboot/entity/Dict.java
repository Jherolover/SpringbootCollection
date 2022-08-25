package com.elite.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
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
    private Integer dictType;

    /**
     * 代码值
     */
    private String dictCode;

    /**
     * 代码名称
     */
    private String dictName;

    /**
     * 父节点
     */
    private Integer dictParent;

    /**
     * 字典状态
     */
    private String dictStatus;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private String updateBy;


}
