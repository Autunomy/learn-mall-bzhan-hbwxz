package com.hty.oauth2Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.web.server.ServerBearerTokenAuthenticationConverter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;

import javax.sql.DataSource;

/**
 * @author hty
 * @date 2023-07-22 14:45
 * @email 1156388927@qq.com
 * @description
 * @other 更多请看www.autunomy.top
 */

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AccessManager accessManager;

    @Bean
    public SecurityWebFilterChain webFluxSecurityWebFilterChain(ServerHttpSecurity serverHttpSecurity){
        ReactiveJdbcAuthManage reactiveJdbcAuthManage = new ReactiveJdbcAuthManage(dataSource);
        AuthenticationWebFilter authenticationWebFilter = new AuthenticationWebFilter(reactiveJdbcAuthManage);
        authenticationWebFilter.setServerAuthenticationConverter(new ServerBearerTokenAuthenticationConverter());


        serverHttpSecurity
                .httpBasic().disable() //响应式编程 他和restful不同
                .csrf().disable()
                .authorizeExchange().pathMatchers(HttpMethod.OPTIONS).permitAll() // options全面方向是为了兼容ajax调用
                .anyExchange().access(accessManager) //除了上面的options全部都放行之外，剩下的全部请求都要使用accessManager进行过滤
                .and()
                .addFilterAt(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION);

        return  serverHttpSecurity.build();
    }

}
