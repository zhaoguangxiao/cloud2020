package com.atguigu.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {


    void decrAccount(@Param("userId") Long userId, @Param("moeny") BigDecimal moeny);
}
