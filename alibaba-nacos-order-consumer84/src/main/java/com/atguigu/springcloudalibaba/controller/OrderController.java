package com.atguigu.springcloudalibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class OrderController {

    @Value("${server-url.nacos-user-service}")
    private String serverUrl;


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/order/payment/{id}")
    public String order(@PathVariable Integer id) {
        return restTemplate.getForObject(serverUrl + "/payment/" + id, String.class);
    }

}
