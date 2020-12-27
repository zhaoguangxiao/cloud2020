package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.SendProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;


@Slf4j
@EnableBinding(Source.class)  //定义消息的推送管道
public class SendProviderServiceImpl implements SendProviderService {

    @Resource
    private MessageChannel output;  //消息发送管道


    @Override
    public String send() {
        String uuid = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(uuid).build());
        log.info("------------uuid-------------" + uuid);
        return null;
    }
}
