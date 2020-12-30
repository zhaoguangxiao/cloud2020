package com.atguigu.springcloudalibaba.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceHandler implements PaymentService {

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<>(8888, "PaymentServiceHandler 服务熔断", new Payment(id, null));
    }
}
