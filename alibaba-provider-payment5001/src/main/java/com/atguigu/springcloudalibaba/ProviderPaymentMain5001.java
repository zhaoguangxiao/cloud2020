package com.atguigu.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderPaymentMain5001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentMain5001.class, args);
    }
}
