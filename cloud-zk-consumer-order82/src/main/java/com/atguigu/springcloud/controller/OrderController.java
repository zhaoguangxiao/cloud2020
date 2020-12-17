package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    static final String Zookeeper_path = "http://cloud-provider-payment";

    @GetMapping(value = "/order/payment/discovery")
    public String PaymentInfo() {
        return restTemplate.getForObject(Zookeeper_path + "/payment/discovery", String.class);
    }


}
