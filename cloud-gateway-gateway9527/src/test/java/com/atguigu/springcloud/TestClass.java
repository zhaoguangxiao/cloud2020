package com.atguigu.springcloud;

import java.time.ZonedDateTime;

public class TestClass {
    public static void main(String[] args) {
        //默认时区
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
