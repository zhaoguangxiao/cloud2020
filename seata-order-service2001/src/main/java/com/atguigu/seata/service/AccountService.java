package com.atguigu.seata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

/**
 * 用户service
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    //减余额
    //int decrAccount(@PathVariable("userId") Long userId, @PathVariable("used") BigDecimal used);
}
