package com.atguigu.springcloud.service;

public interface PaymentService {

    public String getThreadNameOk(Long id);

    public String timeOutError();

    public String fusingMethod(Long id);
}
