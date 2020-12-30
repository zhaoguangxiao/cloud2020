package com.atguigu.springcloudalibaba.service;

import com.atguigu.springcloud.entities.Payment;

public interface PaymentService {
    Payment findByKey(Long id);
}
