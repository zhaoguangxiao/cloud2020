package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String server_port;


    @GetMapping(value = "/payment/consul")
    public Object getPaymentConsul() {
        log.info("consul port" + server_port);
        return server_port + UUID.randomUUID().toString();
    }

}
