package com.elite.springboot.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 订单表
 */
@Data
@Getter
@Setter
public class Order {
    //订单ID
    private Integer order_id;
    //订单号
    private Integer order_no;
    //商品编号
    private Integer product_id;
    //用户
    private Integer user_id;
    //'订单产品数量'
    private Integer order_num ;
    //'订单金额'
    private BigDecimal order_amt ;
    //订单状态 0待确认，1已确认，2已收货，3已取消，4已完成，5已作废
    private String order_status;
    //支付状态 0待支付，1已支付，2部分支付，3已退款，4拒绝退款
    private String pay_status;
    //创建时间
    private Date create_time;
    //更新时间
    private Date update_time;
    //创建用户
    private String create_user;
    //更新用户
    private String update_user;
}
