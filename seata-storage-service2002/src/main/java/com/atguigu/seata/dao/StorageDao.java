package com.atguigu.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {


    public void decrStroage(@Param("productId") Long productId, @Param("count") Integer count);

}
