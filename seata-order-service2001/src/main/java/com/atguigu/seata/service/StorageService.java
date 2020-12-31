package com.atguigu.seata.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 库存service
 */
@FeignClient(value = "seata-stroage-service")
public interface StorageService {

    //减库存方法
    @PostMapping("/storage/decr")
    CommonResult<Object> decrStorage(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);


}
