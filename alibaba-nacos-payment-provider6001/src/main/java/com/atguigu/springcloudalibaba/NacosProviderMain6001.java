package com.atguigu.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosProviderMain6001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain6001.class, args);
    }
}
