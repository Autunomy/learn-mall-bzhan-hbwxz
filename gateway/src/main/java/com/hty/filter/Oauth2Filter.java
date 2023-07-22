package com.hty.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author hty
 * @date 2023-07-22 17:13
 * @email 1156388927@qq.com
 * @description
 * @other 更多请看www.autunomy.top
 */

public class Oauth2Filter implements GlobalFilter, Ordered {

    //调用check token 接口


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {



        return null;
    }

    //用来给filter进行排序的
    @Override
    public int getOrder() {
        return 0;
    }
}
