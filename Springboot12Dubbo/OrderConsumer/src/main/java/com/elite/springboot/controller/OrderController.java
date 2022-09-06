package com.elite.springboot.controller;

import com.elite.springboot.service.IOrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    /**
     * 引入接口直接调用
     */
    @DubboReference
    IOrderService orderService;


    @GetMapping("/getOrderInfo")
    public String getOrderInfo(){
        return orderService.getOrderInfo();
    }

}
