package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PayServiceFallbackHandler implements PayService{


    @Override
    public String getThreadNameOk(Long id) {
        return " PayServiceFallbackHandler  fallback  getThreadNameOk o(╥﹏╥)o";
    }

    @Override
    public String timeOutError() {
        return " PayServiceFallbackHandler  fallback  timeOutError o(╥﹏╥)o";
    }
}
