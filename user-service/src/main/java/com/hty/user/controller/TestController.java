package com.hty.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hty
 * @date 2023-07-22 13:55
 * @email 1156388927@qq.com
 * @description
 * @other 更多请看www.autunomy.top
 */

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "hello";
    }

}
