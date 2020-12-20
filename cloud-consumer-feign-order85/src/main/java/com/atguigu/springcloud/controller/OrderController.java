package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/payment/{id}")
    public CommonResult<Payment> getFeign(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }


    @GetMapping(value = "/consumer/payment/timeout")
    public String timeout() {
        return paymentService.timeout();
    }

}
