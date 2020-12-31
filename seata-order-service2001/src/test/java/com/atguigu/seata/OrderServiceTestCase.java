package com.atguigu.seata;

import com.atguigu.seata.domain.Order;
import com.atguigu.seata.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SeataOrderMain2001.class)
public class OrderServiceTestCase {

    @Autowired
    private OrderService orderService;


    @Test
    public void createOrder() {
        Order order = new Order();
        order.setUserId(111L);
        order.setProductId(112L);
        order.setStatus(0);
        order.setCount(5);
        order.setMoney(new BigDecimal(2.6));
        int id = orderService.createOrder(order);
        System.out.println(id);
    }


}