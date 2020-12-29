package com.atguigualibaba.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigualibaba.sentinel.myhandler.CustomerHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RateLimitController {


    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource", blockHandler = "byResourceHandler")
    public CommonResult getResource() {
        return new CommonResult(200, "按资源名称进行限流", new Payment(2020L, "sentinel001"));
    }


    public CommonResult byResourceHandler(BlockException blockException) {
        return new CommonResult(444, blockException.getClass().getCanonicalName() + "服务不可用");
    }

    @GetMapping(value = "/byurl")
    @SentinelResource(value = "byurl")
    public CommonResult getUrl() {
        return new CommonResult(200, "按资源url进行限流", new Payment(2020L, "sentinel002"));
    }


    @GetMapping(value = "/customer")
    @SentinelResource(value = "customer",
            blockHandlerClass = CustomerHandler.class,
            blockHandler = "blockException2")
    public CommonResult customerException() {
        return new CommonResult(200, "ok-----");
    }
}
