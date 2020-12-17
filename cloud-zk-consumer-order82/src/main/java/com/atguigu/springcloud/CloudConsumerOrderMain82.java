package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudConsumerOrderMain82 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderMain82.class, args);
    }
}
