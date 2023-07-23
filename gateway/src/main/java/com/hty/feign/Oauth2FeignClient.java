package com.hty.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author hty
 * @date 2023-07-22 17:15
 * @email 1156388927@qq.com
 * @description
 * @other 更多请看www.autunomy.top
 */

@FeignClient("oauth2-service")
public interface Oauth2FeignClient {

    @RequestMapping("/oauth/check_token")
    public Map<String, Object> checkToken(@RequestParam String token);
}
