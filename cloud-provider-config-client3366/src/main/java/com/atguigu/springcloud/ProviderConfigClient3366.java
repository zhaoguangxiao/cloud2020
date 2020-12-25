package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProviderConfigClient3366 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderConfigClient3366.class, args);
    }
}
