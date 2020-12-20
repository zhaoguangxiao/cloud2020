package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private PayService payService;


    @GetMapping(value = "/order/provider/hystrix/{id}")
    public String getThreadNameOk(@PathVariable("id") Long id) {
        return payService.getThreadNameOk(id);
    }

    @GetMapping("/order/provider/hystrix/timeout")
    public String timeOutError() {
        return payService.timeOutError();
    }
}
