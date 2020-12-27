package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ConsumerStreamMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerStreamMain8802.class, args);
    }
}
