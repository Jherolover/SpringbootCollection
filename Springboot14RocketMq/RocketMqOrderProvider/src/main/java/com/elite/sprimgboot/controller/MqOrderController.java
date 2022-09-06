package com.elite.sprimgboot.controller;

import com.elite.sprimgboot.entity.Order;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 推送订单消息
 */
@RestController
public class MqOrderController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("/sendOrderMessage")
    public String sendOrderMessage() {
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
        rocketMQTemplate.syncSend("order-topic",order.toString(),6000);
        return order.toString();
    }
}
