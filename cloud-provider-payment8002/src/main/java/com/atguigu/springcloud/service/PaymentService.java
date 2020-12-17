package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

public interface PaymentService {

    int add(Payment payment);

    Payment getPaymentById(long id);
}
