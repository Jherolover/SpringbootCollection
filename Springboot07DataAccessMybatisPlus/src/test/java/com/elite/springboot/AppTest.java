package com.elite.springboot;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.elite.springboot.entity.Order;
import com.elite.springboot.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 测试订单类
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    @Resource
    OrderMapper orderMapper;

    /**
     * 保存订单
     */
    @Test
    public void SaveOrder() {
        Order order = new Order();
        order.setOrder_no(3);
        order.setProduct_id(3);
        order.setUser_id(3);
        order.setOrder_num(2);
        order.setOrder_amt(BigDecimal.valueOf(30));
        order.setOrder_status("下单");
        order.setPay_status("未支付");
        order.setCreate_user("plus");
        order.setUpdate_user("plus");
        //调用新增订单方法Insert
        orderMapper.insert(order);
    }

    /**
     * 更新订单数据
     */
    @Test
    public void UpdateOrder() {
        Order order = new Order();
        order.setOrder_id(6);
        order.setOrder_status("发货");
        order.setPay_status("支付");
        int count = orderMapper.updateById(order);
        if (count > 0){
            System.out.println("更新成功!");
        }else{
            System.out.println("更新失败");
        }
    }
    /**
     * 根据订单ID获取订单 SELECT order_id,order_no,product_id,user_id,order_num,
     * order_amt,order_status,pay_status,create_time,update_time,create_user,update_user FROM `order` WHERE order_id=?
     *
     */
    @Test
    public void GetOrder() {
        Order order = orderMapper.selectById(5);
        System.out.println(order);
    }
    /**
     * 获取订单列表
     * SELECT order_id,order_no,product_id,user_id,order_num,order_amt,order_status,
     * pay_status,create_time,update_time,create_user,update_user FROM `order`
     */
    @Test
    public void GetOrderList() {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        //可以指定查询的条件
        //QueryWrapper(LambdaQueryWrapper) 和 UpdateWrapper(LambdaUpdateWrapper) 的父类
        //可以指定条件
        //queryWrapper.ge("order_no","2");//大于等于 >=
        //le
        //like
        //nolike 等具体参考 https://baomidou.com/pages/10c804/#abstractwrapper
        List<Order> orderList = orderMapper.selectList(queryWrapper);
        for( Order order :orderList){
            System.out.println(order);
        }
    }
    /**
     * 删除订单
     */
    @Test
    public void DelOrder() {
        int count = orderMapper.deleteById(7);
        if (count > 0 ){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }
    }
}
