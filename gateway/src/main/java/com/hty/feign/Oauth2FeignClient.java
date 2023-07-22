package com.hty.feign;

import org.springframework.stereotype.Component;

/**
 * @author hty
 * @date 2023-07-22 17:15
 * @email 1156388927@qq.com
 * @description
 * @other 更多请看www.autunomy.top
 */

@Component
public class Oauth2FeignClient {

    public boolean checkToken(String token){
        return true;
    }

}
