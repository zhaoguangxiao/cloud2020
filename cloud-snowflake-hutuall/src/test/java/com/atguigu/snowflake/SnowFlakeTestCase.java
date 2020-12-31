package com.atguigu.snowflake;

import com.atguigu.snowflake.write.IdGeneratorSnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SnowFlakeMain808.class)
public class SnowFlakeTestCase {

    @Autowired
    private IdGeneratorSnowFlake idGeneratorSnowFlake;

    /**
     * 模拟线程池访问雪花算法
     */
    @Test
    public void ThreadPoolTest() {
        //一池5线程
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                long snowflake = idGeneratorSnowFlake.snowflake();
                System.out.println(snowflake);
            });

        }

        //关闭线程池
        executorService.shutdown();

    }

}
