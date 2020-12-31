package com.atguigu.seata.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 用户service
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    //减余额
    @PostMapping("/account/decr")
    CommonResult<Object> decrAccount(@RequestParam("userId") Long userId, @RequestParam("moeny") BigDecimal moeny);

}
