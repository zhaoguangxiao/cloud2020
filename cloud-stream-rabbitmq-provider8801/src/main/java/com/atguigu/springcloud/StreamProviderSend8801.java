package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StreamProviderSend8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamProviderSend8801.class, args);
    }
}
