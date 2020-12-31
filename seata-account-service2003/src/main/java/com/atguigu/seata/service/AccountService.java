package com.atguigu.seata.service;

import java.math.BigDecimal;

public interface AccountService {

    void decrAccount(Long userId, BigDecimal moeny);

}
