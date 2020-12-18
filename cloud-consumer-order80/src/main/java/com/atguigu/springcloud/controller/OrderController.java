package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    //static final String PATH_URL = "http://localhost:8001";
    static final String PATH_URL = "http://CLOUD-PROVIDER-SERVICE";

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PATH_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PATH_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getForEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PATH_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful())
            return entity.getBody();
        return new CommonResult<Payment>(400, "查询实现一点意外");
    }

    @GetMapping(value = "/consumer/postEntity/create")
    public CommonResult<Payment> postEntity(Payment payment) {
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PATH_URL + "/payment/create", payment, CommonResult.class);
        log.info(entity.getHeaders().getAccessControlAllowOrigin());
        if (entity.getStatusCode().is2xxSuccessful())return entity.getBody();
        return new CommonResult<Payment>(400, "添加实现一点意外");
    }



}
