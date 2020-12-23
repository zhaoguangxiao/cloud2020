package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PayService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@DefaultProperties(defaultFallback = "orderFallbackHandler")
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private PayService payService;


    @GetMapping(value = "/order/provider/hystrix/{id}")
    public String getThreadNameOk(@PathVariable("id") Long id) {
        return payService.getThreadNameOk(id);
    }


    //@HystrixCommand(fallbackMethod = "timeoutErrorHandler", commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500"))
    @GetMapping("/order/provider/hystrix/timeout")
    @HystrixCommand
    public String timeOutError() {
        int a = 10 / 0;
        return payService.timeOutError();
    }

    public String timeoutErrorHandler() {
        return "我是客户端87,你访问的数据超时,再见拜";
    }


    public String orderFallbackHandler() {
        return "这是 @DefaultProperties(defaultFallback = orderFallbackHandler) 全局配置";
    }
}
