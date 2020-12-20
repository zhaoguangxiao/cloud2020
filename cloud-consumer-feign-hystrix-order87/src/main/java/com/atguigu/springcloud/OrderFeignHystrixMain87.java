package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OrderFeignHystrixMain87 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixMain87.class, args);
    }
}
