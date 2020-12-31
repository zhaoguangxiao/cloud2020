package com.atguigu.seata.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan({"com.atguigu.seata.dao"})
@Configuration
public class MybatisConfig {

}
