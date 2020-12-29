package com.atguigualibaba.sentinel.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

public class CustomerHandler {

    public static CommonResult blockException1(BlockException blockException) {
        return new CommonResult(444, "CustomerHandler blockException1");
    }


    public static CommonResult blockException2(BlockException blockException) {
        return new CommonResult(333, "CustomerHandler blockException2");
    }
}
