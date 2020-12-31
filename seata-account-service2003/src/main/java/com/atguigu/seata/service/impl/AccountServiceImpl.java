package com.atguigu.seata.service.impl;

import com.atguigu.seata.dao.AccountDao;
import com.atguigu.seata.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param moeny  花了多少钱
     */
    @Override
    public void decrAccount(Long userId, BigDecimal moeny) {
        log.info("----->AccountServiceImpl 正在扣减账户余额");
        //模拟超时异常,,全局事务回滚
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decrAccount(userId, moeny);
        log.info("----->AccountServiceImpl 账户余额扣减完毕  ^_^");
    }
}
