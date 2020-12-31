package com.atguigu.snowflake.controller;

import com.atguigu.snowflake.write.IdGeneratorSnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnowflakeController {

    @Autowired
    private IdGeneratorSnowFlake idGeneratorSnowFlake;


    @GetMapping("/snowflake")
    public long snowFlake() {
        return new IdGeneratorSnowFlake().snowflake();
    }
}
