package com.atguigu.seata.controller;

import com.atguigu.seata.domain.Order;
import com.atguigu.seata.service.OrderService;
import com.atguigu.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {


    @Autowired
    private OrderService orderService;


    @PostMapping("/order/create")
    public CommonResult<Order> createOrder(@RequestBody Order order) {
        int serviceOrder = orderService.createOrder(order);
        return new CommonResult<>(200, "订单插入成功" + serviceOrder);
    }

    @PostMapping("/order/status")
    public CommonResult<Order> updateByStatus(@RequestParam("userId") Long userId, @RequestParam("status") Integer status) {
        int bystatus = orderService.updateOrderBystatus(userId, status);
        return new CommonResult<>(200, "订单状态修改成功" + bystatus);
    }


}
