package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String getThreadNameOk(Long id) {
        return Thread.currentThread().getName() + " :是操作线程 --->线程id为: " + Thread.currentThread().getId() + " is success getThreadNameOk() method";
    }

    //------------服务降级----------------
    //超过三秒就是报错 执行另外一个保底的方法 fallbackTimeOutError
    @HystrixCommand(fallbackMethod = "fallbackTimeOutError", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public String timeOutError() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int a = 10 / 0;
        return "timeOutError() method is error O(∩_∩)O哈哈~";
    }


    public String fallbackTimeOutError() {
        return "timeOutError() method is error o(╥﹏╥)o";
    }


    //------------服务熔断----------------

    @Override
    @HystrixCommand(fallbackMethod = "fusingMethodHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败率到达多少跳闸
    })
    public String fusingMethod(Long id) {
        if (id < 0) throw new RuntimeException("id 不能为负数");
        //类似于 UUID.randomUUID().toString()
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功 流水号为 : " + uuid;
    }

    public String fusingMethodHandler(Long id) {
        return "熔断器已经执行 ---- fusingMethodHandler ---  id不能为负数";
    }
}
