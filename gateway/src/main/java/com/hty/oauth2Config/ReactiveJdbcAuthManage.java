//package com.hty.oauth2Config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.ReactiveAuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//import org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationToken;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Mono;
//
//import javax.sql.DataSource;
//
///**
// * @author hty
// * @date 2023-07-22 14:41
// * @email 1156388927@qq.com
// * @description
// * @other 更多请看www.autunomy.top
// */
//
////授权  查找token 验证token
//public class ReactiveJdbcAuthManage implements ReactiveAuthenticationManager {
//
//    @Autowired
//    private TokenStore tokenStore;
//
//    public ReactiveJdbcAuthManage(DataSource dataSource) {
//        this.tokenStore = new JdbcTokenStore(dataSource);
//    }
//
//    @Override
//    public Mono<Authentication> authenticate(Authentication authentication) {
//        return Mono.justOrEmpty(authentication)
//                .filter(a -> a instanceof BearerTokenAuthenticationToken) //token的校验 原生的oauth2进行访问的时候 需要在header中添加token，并且以bearer开头
//                .cast(BearerTokenAuthenticationToken.class)//将Authentication类型转换为BearerTokenAuthenticationToken类型
//                .map(BearerTokenAuthenticationToken :: getToken)
//                .flatMap(accessToken -> {
//                    //accessToken就是获取到的token
//                    //从db读取
//                    OAuth2AccessToken oAuth2AccessToken = this.tokenStore.readAccessToken(accessToken);
//                    if (oAuth2AccessToken == null){
//                        //不存在
//                        return Mono.error(new InvalidTokenException("Token not found in token store!"));
//                    }
//                    if (oAuth2AccessToken.isExpired()){
//                        //已经过期了
//                        return Mono.error(new InvalidTokenException("Token is expired!"));
//                    }
//
//                    OAuth2Authentication oAuth2Authentication = this.tokenStore.readAuthentication(accessToken);
//                    if (oAuth2Authentication == null){
//                        return Mono.error(new InvalidTokenException("invalid token"));
//                    }
//                    if (!oAuth2Authentication.isAuthenticated()){
//                        //没有被放行
//                        return Mono.error(new InvalidTokenException("token not authenticated"));
//                    }
//
//                    return Mono.justOrEmpty(oAuth2Authentication);
//                }).cast(Authentication.class);
//    }
//}
