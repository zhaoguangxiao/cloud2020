package com.atguigu.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloudalibaba.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private PaymentService paymentService;


    @Autowired
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String server_url;

    @GetMapping("order/fallback/{id}")
    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "fallbackHandler", exceptionsToIgnore = IllegalArgumentException.class)
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(server_url + "/payment/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException id 为空");
        }
        return result;
    }

    public CommonResult<Payment> fallbackHandler(@PathVariable("id") Long id, Throwable throwable) {
        return new CommonResult<>(555, id + "兜底的 fallbackHandler method loading  ...." + throwable.getMessage());
    }


    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException exception) {
        return new CommonResult<>(444, id + "兜底的 blockHandler method loading ***" + exception.getMessage());
    }


    @GetMapping("/order/payment/{id}")
    public CommonResult<Payment> payment(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }
}
