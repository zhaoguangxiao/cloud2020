package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String getThreadNameOk(Long id) {
        return Thread.currentThread().getName()+" :是操作线程 --->线程id为: "+Thread.currentThread().getId()+" is success getThreadNameOk() method";
    }

    @Override
    public String timeOutError() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "timeOutError() method is error";
    }
}
