package com.atguigu.seata.dao;


import com.atguigu.seata.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {


    int insertOrder(Order order);

    int updateOrderBystatus(@Param("userId") Long userId,@Param("status") Integer status);
}
