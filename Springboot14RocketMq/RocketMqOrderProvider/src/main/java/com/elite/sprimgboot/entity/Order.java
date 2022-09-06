package com.elite.sprimgboot.entity;

/**
 * 订单
 */

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author elite
 * @since 2022-08-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Order implements Serializable {


    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 订单号
     */
    private Integer orderNo;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 订单产品数量
     */
    private Integer orderNum;

    /**
     * 订单金额
     */
    private BigDecimal orderAmt;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 支付状态
     */
    private String payStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新人
     */
    private String updateUser;
}