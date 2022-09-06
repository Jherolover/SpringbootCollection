package com.elite.springboot.service.impl;

import com.elite.springboot.entity.Order;
import com.elite.springboot.service.IOrderService;
import org.apache.dubbo.config.annotation.DubboService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 提供方实现接口并暴露服务
 */
@DubboService
public class IOrderServiceImpl implements IOrderService {
    /**
     * 发送订单信息
     * @return
     */
    @Override
    public String getOrderInfo() {
        Order order = new Order();
        order.setOrderId(1);
        order.setOrderNo(1);
        order.setProductId(1);
        order.setUserId(1);
        order.setOrderNum(5);
        order.setOrderAmt(new BigDecimal("100.0"));
        order.setOrderStatus("下单");
        order.setPayStatus("未支付");
        order.setCreateUser("elite");
        order.setCreateTime(LocalDateTime.now());

        return order.toString();
    }
}
