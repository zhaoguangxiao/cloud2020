package com.atguigu.seata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 库存service
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    //减库存方法
    //int decrStorage(@PathVariable("productId") Long productId, @PathVariable("count") Integer count);


}
