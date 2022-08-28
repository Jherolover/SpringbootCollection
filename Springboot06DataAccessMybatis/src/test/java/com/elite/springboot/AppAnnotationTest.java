package com.elite.springboot;

import com.elite.springboot.entity.Order;
import com.elite.springboot.mapper.OrderAnnotationMapper;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 注解sql测试
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppAnnotationTest {

    @Resource
    OrderAnnotationMapper orderAnnotationMapper;

    /**
     * 保存订单
     */
    @Test
    public void InserOrder(){
        Order order = new Order();
//        order.setOrder_no(2);
//        order.setProduct_id(2);
//        order.setUser_id(1);
//        order.setOrder_num(2);
//        order.setOrder_amt(BigDecimal.valueOf(20));
//        order.setOrder_status("下单");
//        order.setPay_status("未支付");
//        order.setCreate_user("annotation");
//        order.setUpdate_user("annotation");
        order.setOrder_no(4);
        order.setProduct_id(1);
        order.setUser_id(1);
        order.setOrder_num(2);
        order.setOrder_amt(BigDecimal.valueOf(20));
        order.setOrder_status("下单");
        order.setPay_status("支付");
        order.setCreate_user("annotation");
        order.setUpdate_user("annotation");
        orderAnnotationMapper.insertOrder(order);
    }

    /**
     * 更新订单状态
     */
    @Test
    public void updateOrderStatusById(){
        Order order = new Order();
        order.setOrder_id(3);
        order.setOrder_status("取消下单");
        orderAnnotationMapper.updateOrderStatusById(order);
    }
    /**
     * 查询订单
     */
    @Test
    public void getOneOrderById(){

        Order order = orderAnnotationMapper.getOneOrderById(3);
        System.out.println(order);
        //Order(order_id=3, order_no=2, product_id=2, user_id=1, order_num=2, order_amt=20.00, order_status=取消下单, pay_status=未支付, create_time=2022-08-21, update_time=2022-08-21, create_user=annotation, update_user=annotation)
    }
    /**
     * 查询所有订单
     */
    @Test
    public void getAllOrder(){
        List<Order> allOrder = orderAnnotationMapper.getAllOrder();
        for (Order order :allOrder){
            System.out.println(order);
        }
        //Order(order_id=1, order_no=1, product_id=1, user_id=1, order_num=2, order_amt=0.00, order_status=已发货, pay_status=支付完成, create_time=2022-08-21, update_time=2022-08-21, create_user=user1, update_user=user2)
        //Order(order_id=3, order_no=2, product_id=2, user_id=1, order_num=2, order_amt=20.00, order_status=取消下单, pay_status=未支付, create_time=2022-08-21, update_time=2022-08-21, create_user=annotation, update_user=annotation)
        //Order(order_id=4, order_no=4, product_id=1, user_id=1, order_num=2, order_amt=20.00, order_status=下单, pay_status=支付, create_time=2022-08-21, update_time=2022-08-21, create_user=annotation, update_user=annotation)
        //Order(order_id=5, order_no=4, product_id=1, user_id=1, order_num=2, order_amt=20.00, order_status=下单, pay_status=支付, create_time=2022-08-21, update_time=2022-08-21, create_user=annotation, update_user=annotation)
    }

    /**
     *删除订单
     */
    @Test
    public void delOrderById(){
        orderAnnotationMapper.delOrderById(5);
    }

}
