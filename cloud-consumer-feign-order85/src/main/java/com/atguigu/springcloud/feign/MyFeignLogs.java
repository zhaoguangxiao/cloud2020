package com.atguigu.springcloud.feign;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFeignLogs {

    @Bean
    public Logger.Level feignLoggerLeave() {
        return Logger.Level.FULL;
    }
}
