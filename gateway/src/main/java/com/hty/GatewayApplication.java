package com.hty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hty
 * @date 2023-07-16 20:15
 * @email 1156388927@qq.com
 * @description
 * @other 更多请看www.autunomy.top
 */

@SpringBootApplication
@EnableDiscoveryClient//nacos注册
@EnableFeignClients
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
