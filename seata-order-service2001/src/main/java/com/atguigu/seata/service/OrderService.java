package com.atguigu.seata.service;

import com.atguigu.seata.domain.Order;
/**
 * 订单service
 */
public interface OrderService {

    //添加订单
    int createOrder(Order order);

    //修改订单状态
    int updateOrderBystatus(Long userId, Integer status);


}
