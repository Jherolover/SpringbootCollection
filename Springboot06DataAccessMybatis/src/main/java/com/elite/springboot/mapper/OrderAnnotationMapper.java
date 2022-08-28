package com.elite.springboot.mapper;

import com.elite.springboot.entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 使用注解进行
 */
public interface OrderAnnotationMapper {
    //保存数据
    @Insert("INSERT INTO `order`(`order_no`,`product_id`,`user_id`,`order_num`,`order_amt`,`order_status`,`pay_status`,`create_user`,`update_user`)\n" +
            " VALUES( #{order_no},#{product_id},#{user_id},#{order_num},#{order_amt},#{order_status},#{pay_status},#{create_user},#{update_user})")
    void insertOrder(Order order);

    //更新订单
    @Update("update `order` set  order_status = #{order_status} where order_id= #{order_id}")
    void updateOrderStatusById(Order order);

    //删除订单
    @Delete("DELETE FROM `order` WHERE order_id= #{order_id}")
    void delOrderById(Integer order_id);

    //获取订单
    @Select("select * from `order` where order_id= #{order_id}")
    Order getOneOrderById(Integer order_id);

    //获取所有的订单
    @Select("select * from `order`")
    List<Order> getAllOrder();
}
