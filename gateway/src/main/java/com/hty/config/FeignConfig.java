package com.hty.config;

import feign.codec.Decoder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hty
 * @date 2023-07-23 22:20
 * @email 1156388927@qq.com
 * @description
 * @other 更多请看www.autunomy.top
 */

//解决了bean注入不进来的报错
//feign.codec.EncodeException:
// No qualifying bean of type 'org.springframework.boot.autoconfigure.http.HttpMessageConverters' available:
// expected at least 1 bean which qualifies as autowire candidate. Dependency annotations:
// {@org.springframework.beans.factory.annotation.Autowired(required=true)}
@Configuration
public class FeignConfig {

    @Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
        return new HttpMessageConverters((Collection)converters.orderedStream().collect(Collectors.toList()));
    }

//    @Bean
//    public Decoder feignDecoder(){
//        ObjectFactory<HttpMessageConverters> objectFactory = new ObjectFactory() {
//            @Override
//            public Object getObject() throws BeansException {
//                MappingJackson2CborHttpMessageConverter mappingJackson2CborHttpMessageConverter =
//                        new MappingJackson2CborHttpMessageConverter();
//                List<MediaType> mediaTypeList = new ArrayList<>();
//                mediaTypeList.add(MediaType.valueOf(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"));
//                mappingJackson2CborHttpMessageConverter.setSupportedMediaTypes(mediaTypeList);
//                final HttpMessageConverters httpMessageConverters = new HttpMessageConverters(mappingJackson2CborHttpMessageConverter);
//                return httpMessageConverters;
//            }
//        };
//
//        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
//    }

}
