package com.atguigualibaba.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String getTestA() {
        log.info(Thread.currentThread().getName() + "......testA");
        return "--------testA";
    }


    @GetMapping("/testB")
    public String getTestB() {
        return "--------testB";
    }

    @GetMapping("/hotkey")
    @SentinelResource(value = "hotkey", blockHandler = "deal_hotkey")
    public String timeOut(@RequestParam(value = "p1", required = false) String p1,
                          @RequestParam(value = "p2", required = false) String p2) {
        return "-----/hotkey";
    }

    public String deal_hotkey(String p1, String p2, BlockException blockException) {
        return "-----/deal_hotkey";
    }

}
