package com.atguigu.springcloudalibaba.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloudalibaba.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PaymentServiceImpl implements PaymentService {


    //模拟调用数据库
    public static HashMap<Long, Payment> hashMap = new HashMap<>();


    static {
        hashMap.put(1L, new Payment(1L, IdUtil.simpleUUID()));
        hashMap.put(2L, new Payment(2L, IdUtil.simpleUUID()));
        hashMap.put(3L, new Payment(3L, IdUtil.simpleUUID()));
    }

    @Override
    public Payment findByKey(Long id) {
        return hashMap.get(id);
    }

}
