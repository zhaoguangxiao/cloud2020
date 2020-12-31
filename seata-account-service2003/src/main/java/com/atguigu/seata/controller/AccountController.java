package com.atguigu.seata.controller;

import com.atguigu.seata.service.AccountService;
import com.atguigu.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostMapping("/account/decr")
    CommonResult<Object> decrAccount(@RequestParam("userId") Long userId, @RequestParam("moeny") BigDecimal moeny) {
        accountService.decrAccount(userId, moeny);
        return new CommonResult<>(200, "用户余额扣减成功");
    }

}
