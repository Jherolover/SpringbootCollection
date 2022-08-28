package com.elite.springboot;


import com.elite.springboot.entity.Order;
import com.elite.springboot.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Unit test for simple App.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    @Resource
    OrderMapper orderMapper;

    //保存数据
    @Test
    public void saveOrder(){
        Order order = new Order();
        order.setOrder_no(1);
        order.setProduct_id(1);
        order.setUser_id(1);
        order.setOrder_num(2);
        order.setOrder_amt(BigDecimal.valueOf(0));
        order.setOrder_status("下单");
        order.setPay_status("未支付");
        order.setCreate_user("user1");
        order.setUpdate_user("user2");

        orderMapper.saveOrder(order);

    }
    //更新订单
    @Test
    public void updateOrder(){
        Order order = new Order();
        order.setOrder_id(1);
        order.setOrder_status("已发货");
        order.setPay_status("支付完成");
        orderMapper.updateOrder(order);
    }
    //删除订单
    @Test
    public void delOrder(){
        orderMapper.delOrder(2);
    }
    //获取订单
    @Test
    public void getOneOrder(){
        Order oneOrder = orderMapper.getOneOrder(1);
        System.out.println(oneOrder);
        //Order(order_id=1, order_no=1, product_id=1, user_id=1, order_num=2,
        // order_amt=0.00, order_status=已发货, pay_status=支付完成, create_time=2022-08-21, update_time=2022-08-21, create_user=user1, update_user=user2)

    }
    //获取所有的订单
    @Test
    public void getAllOrder(){
        List<Order> orderList = orderMapper.getAllOrder();
        for(Order order:orderList){
            System.out.println(order);
        }
        //Order(order_id=1, order_no=1, product_id=1, user_id=1, order_num=2, order_amt=0.00, order_status=已发货, pay_status=支付完成, create_time=2022-08-21, update_time=2022-08-21, create_user=user1, update_user=user2)
        //Order(order_id=2, order_no=2, product_id=2, user_id=1, order_num=2, order_amt=10.00, order_status=已发货, pay_status=支付, create_time=2022-08-21, update_time=2022-08-21, create_user=user1, update_user=user2)
    }
}
