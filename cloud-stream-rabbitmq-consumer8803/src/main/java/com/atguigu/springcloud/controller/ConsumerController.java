package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableBinding(Sink.class)
public class ConsumerController {

    @Value("${server.port}")
    private String serverPort;



    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者2号------------>接收到消息是: " + message.getPayload() + "端口号为 : " + serverPort);
    }

}
