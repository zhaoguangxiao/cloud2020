package com.atguigu.seata.service.impl;

import com.atguigu.seata.dao.OrderDao;
import com.atguigu.seata.domain.Order;
import com.atguigu.seata.service.AccountService;
import com.atguigu.seata.service.OrderService;
import com.atguigu.seata.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StorageService storageService;


    /**
     * 创订单---> 扣库存 --->减余额 --->修改状态
     *
     * @param order 创建订单
     * @return
     */
    @GlobalTransactional(name = "qwe-create-order", rollbackFor = Exception.class)  //发生什么异常全部回滚
    @Override
    public int createOrder(Order order) {
        log.info("----->开始创建订单");
        int insertOrder = orderDao.insertOrder(order);
        log.info("--->订单微服务开始调用做库存扣减   =" + insertOrder);
        storageService.decrStorage(order.getProductId(), order.getCount());
        log.info("--->库存扣减完成-----开始扣减余额");
        accountService.decrAccount(order.getUserId(), order.getMoney());
        log.info("------->余额扣减完成---开始修改订单状态");
        int bystatus = orderDao.updateOrderBystatus(order.getUserId(), 1);
        log.info("订单状态修改成功");
        return bystatus;
    }

    @Override
    public int updateOrderBystatus(Long userId, Integer status) {
        return orderDao.updateOrderBystatus(userId, status);
    }
}
