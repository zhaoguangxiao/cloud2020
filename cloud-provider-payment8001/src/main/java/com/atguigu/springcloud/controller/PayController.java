package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Slf4j
@RestController
public class PayController {

    @Resource
    private PaymentService paymentService;


    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;


    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> insert(@RequestBody Payment payment) {
        int result = paymentService.add(payment);
        log.info("插入结果为------" + result);
        if (result > 0)
            return new CommonResult<Payment>(200, "插入成功" + port, payment);
        return new CommonResult<Payment>(400, "插入失败" + port);
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果为------" + payment);
        if (null != payment)
            return new CommonResult<Payment>(200, "查询成功" + port, payment);
        return new CommonResult<Payment>(400, "查询失败" + port);
    }


    @GetMapping(value = "/payment/discovery")
    public Object getDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance each : instances) {
            System.out.println(each.getHost());
            System.out.println(each.getPort());
            System.out.println(each.getServiceId());
        }
        return discoveryClient;
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentService(HttpServletRequest httpServletRequest) {
        log.info(httpServletRequest.getHeader("username") + "---------" + port);
        return port;
    }


    @GetMapping(value = "/payment/timeout")
    public String timeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }


    @GetMapping(value = "/payment/zipkin")
    public String zipkin() {
        return "端口为: " + port + " ------------- > zipkin success";
    }
}
