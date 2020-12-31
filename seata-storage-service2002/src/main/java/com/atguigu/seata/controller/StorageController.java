package com.atguigu.seata.controller;

import com.atguigu.seata.domain.Storage;
import com.atguigu.seata.service.StorageService;
import com.atguigu.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StorageController {


    @Autowired
    private StorageService storageService;


    @PostMapping("/storage/decr")
    public CommonResult<Storage> decrStorage(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrStorage(productId, count);
        return new CommonResult<Storage>(200, "库存扣减成功");
    }


}
