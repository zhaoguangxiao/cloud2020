package com.atguigu.seata.service.impl;

import com.atguigu.seata.dao.StorageDao;
import com.atguigu.seata.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;


    @Override
    public void decrStorage(Long productId, Integer count) {
        storageDao.decrStroage(productId, count);
    }
}
