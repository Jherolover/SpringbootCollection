package com.elite.springboot.mapper;

import com.elite.springboot.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 科室映射类
 */
//@Mapper
public interface OrderMapper {

    //保存数据
    void saveOrder(Order order);

    //更新订单
    void updateOrder(Order order);

    //删除订单
    void delOrder(Integer order_id);

    //获取订单
    Order getOneOrder(Integer order_id);

    //获取所有的订单
    List<Order> getAllOrder();

}
