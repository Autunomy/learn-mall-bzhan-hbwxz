package com.hty.oauth2Config;

import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author hty
 * @date 2023-07-22 14:09
 * @email 1156388927@qq.com
 * @description
 * @other 更多请看www.autunomy.top
 */

//权限认证 进行访问的放行或拦截
//响应式编程
@Component
public class AccessManager implements ReactiveAuthorizationManager<AuthorizationContext> {

    //对url的check  有些url需要从gateway层面直接放行 user注册
    private Set<String> permitAll = new ConcurrentSkipListSet<>();//可以过滤的路径
    private static final AntPathMatcher antPathMatcher = new AntPathMatcher();

    public AccessManager(){
        permitAll.add("/**/oauth/**");
    }

    private boolean checkPath(String requestUrl){
        return permitAll.stream().filter(p -> antPathMatcher.match(p,requestUrl)).findFirst().isPresent();
    }

    //最终决定权的方法
    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> authentication, AuthorizationContext authorizationContext) {

        return null;
    }
}
