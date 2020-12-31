package com.atguigu.service;

import com.atguigu.seata.AccountSeataMain2003;
import com.atguigu.seata.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountSeataMain2003.class)
public class AccountServiceTestCase {

    @Autowired
    private AccountService accountService;


    @Test
    public void decrAccount() {
        accountService.decrAccount(1L, new BigDecimal(20));
    }

}
