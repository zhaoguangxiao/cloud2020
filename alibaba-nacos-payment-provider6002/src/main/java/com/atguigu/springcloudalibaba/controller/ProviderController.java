package com.atguigu.springcloudalibaba.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String port;


    @GetMapping(value = "/payment/{id}")
    public String echo(@PathVariable Integer id) {
        return port + "Hello Nacos Discovery " + id;
    }

}
