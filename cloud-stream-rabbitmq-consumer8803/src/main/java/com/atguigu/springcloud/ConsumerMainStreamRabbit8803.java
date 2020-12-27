package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ConsumerMainStreamRabbit8803 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMainStreamRabbit8803.class, args);
    }
}
