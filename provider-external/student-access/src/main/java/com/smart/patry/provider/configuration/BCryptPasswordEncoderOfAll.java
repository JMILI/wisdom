package com.smart.patry.provider.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/4/27,22:16
 *@Version:
 *@Package: com.smart.patry.configuration
 *注解解释：
 *
 */
@Configuration
@Component
public class BCryptPasswordEncoderOfAll {
    @Bean()
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
