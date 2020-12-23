package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeBuilder) {

        RouteLocatorBuilder.Builder routes = routeBuilder.routes();
        //http://news.baidu.com/guonei
        routes.route("path-route-news", r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei")).build();



        routes.route("path-route-guoji", r -> r.path("/guoji")
                .uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }

}
