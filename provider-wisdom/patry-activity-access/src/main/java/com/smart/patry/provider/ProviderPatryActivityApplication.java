package com.smart.patry.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/5/7,21:01
 *@Version:
 *@Package: com.smart.patry.provider
 *注解解释：
 *
 */
@SpringBootApplication
@MapperScan(basePackages = "com.smart.patry.provider.mapper")
public class ProviderPatryActivityApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPatryActivityApplication.class, args);
    }
}
