package com.hty;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author hty
 * @date 2023-07-20 21:40
 * @email 1156388927@qq.com
 * @description
 * @other 更多请看www.autunomy.top
 */

@SpringBootTest
public class Oauth2ApplicationTest {

    @Test
    public void test(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("hty"));
    }

}
