package com.atguigu.springcloudalibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RefreshScope  //支持Nacos 动态刷新
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;


    @GetMapping(value = "/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

}
