package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @GetMapping(value = "/provider/hystrix/{id}")
    public String getThreadNameOk(@PathVariable("id") Long id) {
        String result = paymentService.getThreadNameOk(id);
        log.info("******" + result);
        return result;
    }

    @GetMapping("/provider/hystrix/timeout")
    public String timeOutError() {
        String timeOutError = paymentService.timeOutError();
        log.info("******" + timeOutError);
        return timeOutError;
    }
}
