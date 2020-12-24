package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class CloudConfigMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigMain3344.class, args);
    }
}
