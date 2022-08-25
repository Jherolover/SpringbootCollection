package com.elite.springboot.service.impl;

import com.elite.springboot.entity.Order;
import com.elite.springboot.mapper.OrderMapper;
import com.elite.springboot.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author elite
 * @since 2022-08-22
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
