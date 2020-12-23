package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PayServiceFallbackHandler.class)
public interface PayService {


    @GetMapping(value = "/provider/hystrix/{id}")
    public String getThreadNameOk(@PathVariable("id") Long id);

    @GetMapping("/provider/hystrix/timeout")
    public String timeOutError();

}
