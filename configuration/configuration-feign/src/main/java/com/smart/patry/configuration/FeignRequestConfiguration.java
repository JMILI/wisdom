package com.smart.patry.configuration;

import com.smart.patry.interceptor.FeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/4/29,2:38
 *@Version:
 *@Package: com.smart.patry.configuration
 *注解解释：
 *
 */
@Configuration
public class FeignRequestConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestInterceptor();
    }

}