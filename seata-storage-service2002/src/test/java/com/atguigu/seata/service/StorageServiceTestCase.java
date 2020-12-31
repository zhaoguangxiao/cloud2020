package com.atguigu.seata.service;

import com.atguigu.seata.StorageSeataMain2002;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StorageSeataMain2002.class)
public class StorageServiceTestCase {


    @Autowired
    private StorageService storageService;


    @Test
    public void decrStorage() {
        storageService.decrStorage(1L, 2);
    }
}
