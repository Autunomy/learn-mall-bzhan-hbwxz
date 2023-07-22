package com.hty.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hty
 * @date 2023-07-16 20:15
 * @email 1156388927@qq.com
 * @description
 * @other 更多请看www.autunomy.top
 */

@SpringBootApplication
@EnableDiscoveryClient//nacos注册
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
