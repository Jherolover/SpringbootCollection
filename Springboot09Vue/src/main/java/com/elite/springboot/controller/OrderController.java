package com.elite.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elite.springboot.common.R;
import com.elite.springboot.entity.Order;
import com.elite.springboot.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author elite
 * @since 2022-08-22
 */
@RestController
@RequestMapping("/springboot/order")
@Api(tags = "订单接口")
public class OrderController {

    @Autowired
    IOrderService orderService;

    /**
     * 获取订单列表
     */
    @ApiOperation(value = "获取订单列表")
    @GetMapping("/getOrderList")
    public R getOrderList(){
        List<Order> orderList = orderService.list();
        return R.ok(orderList);
    }
    /**
     * 分页获取订单列表
     */
    @ApiOperation(value = "分页获取订单列表")
    @PostMapping("/getOrderListByPage/{currentPage}/{PageSize}")
    public R getOrderListPage(@PathVariable("currentPage")Integer currentPage,
                              @PathVariable("PageSize") Integer PageSize,
                              @RequestBody Order order){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        IPage<Order> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(PageSize);
        //订单ID
        //queryWrapper.eq("order_id",order.getOrderId());
       queryWrapper.eq("order_no",order.getOrderNo());
        IPage<Order> Orders = orderService.page(page, queryWrapper);
        return R.ok(Orders);
    }
    /**
     * 通过订单ID获取订单信息
     */
    @ApiOperation(value = "通过订单ID获取订单信息")
    @GetMapping("/getOrderById/{order_id}")
    public R getOrderById(@PathVariable("order_id") Integer order_id){
        Order order = orderService.getById(order_id);
        return R.ok(order);
    }
    /**
     * 保存订单信息
     */
    @ApiOperation(value = "保存订单信息")
    @PostMapping("/saveOrder")
    public R saveOrder(@RequestBody Order order){
        boolean save = orderService.save(order);
        if (save){
            return R.ok(null);
        }
        return R.fail();
    }
    /**
     * 更新订单信息
     */
    @ApiOperation(value = "更新订单信息")
    @PutMapping("/updateOrder")
    public R updateOrder(@RequestBody Order order){
        Wrapper<Order> updateWrapper = new UpdateWrapper<>();
        boolean success = orderService.update(updateWrapper);
        if (success){
            return R.ok(null);
        }
        return R.fail();
    }
    /**
     * 删除订单信息
     */
    @ApiOperation(value = "删除订单信息")
    @DeleteMapping("/delOrderById")
    public R delOrderById(@PathVariable("order_id") Integer order_id){
        boolean success = orderService.removeById(order_id);
        if (success){
            return R.ok(null);
        }
        return R.fail();
    }
}
