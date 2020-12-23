package com.atguigu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class PaymentHystrixMain8007 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8007.class, args);
    }


    /** 此配置为了服务监控而配置,与服务容错本身无关,springcloud 升级后的坑
     *  servletRegistrationBean 因为springboot的默认路径不是/hystrix.stream
     *  只要在自己的项目中配置上下面这段代码即可
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
