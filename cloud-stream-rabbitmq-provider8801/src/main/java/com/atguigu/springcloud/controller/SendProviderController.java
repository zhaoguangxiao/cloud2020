package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.SendProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class SendProviderController {


    @Resource
    public SendProviderService sendProviderService;

    @GetMapping("/stream/send")
    public String sendMessage() {
        return sendProviderService.send();
    }


}
