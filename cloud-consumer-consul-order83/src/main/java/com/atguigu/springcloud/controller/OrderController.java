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

    private static final String URL = "http://cloud-consul-provider-payment";


    @GetMapping(value = "/order/payment/consul")
    public String order() {
        return restTemplate.getForObject(URL+"/payment/consul", String.class);
    }

}
