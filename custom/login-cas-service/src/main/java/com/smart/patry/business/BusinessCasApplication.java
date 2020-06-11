package com.smart.patry.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/4/26,18:54
 *@Version:
 *@Package: com.smart.patry.business
 *注解解释：
 *
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class BusinessCasApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessCasApplication.class, args);
    }
}