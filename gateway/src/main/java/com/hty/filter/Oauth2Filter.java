package com.hty.filter;

import com.hty.feign.Oauth2FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;

/**
 * @author hty
 * @date 2023-07-22 17:13
 * @email 1156388927@qq.com
 * @description
 * @other 更多请看www.autunomy.top
 */

@Component
public class Oauth2Filter implements GlobalFilter, Ordered {

    //调用check token 接口
    @Autowired
    @Lazy //滞后加载 防止死锁
    private Oauth2FeignClient oauth2FeignClient;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //path url 校验 放行
        String url = request.getURI().getPath();
        if (url.contains("/user/register")) {
            //放行
            return chain.filter(exchange);
        }
        //校验token  不要bearer前缀
        String token = request.getHeaders().getFirst("Authorization");
        Map<String, Object> tokenResult = oauth2FeignClient.checkToken(token);
        if (!Boolean.valueOf(String.valueOf(tokenResult.get("active")))) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);//设置http状态码为 未认证
            return response.setComplete();//请求结束
        }

        //tracing id 为了以后的日志做准备
        String tracingId = UUID.randomUUID().toString().replaceAll("-","");
        ServerHttpRequest serverHttpRequest = request.mutate().headers(httpHeaders -> {
            httpHeaders.set("tracingId",tracingId);
        }).build();

        //转发给下游
        exchange.mutate().request(serverHttpRequest);

        return chain.filter(exchange);
    }

    //用来给filter进行排序的
    @Override
    public int getOrder() {
        return 0;
    }
}
