package com.atguigu.seata.service;

public interface StorageService {

    void decrStorage(Long productId, Integer count);

}
