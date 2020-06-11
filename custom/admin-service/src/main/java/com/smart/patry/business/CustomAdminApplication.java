package com.smart.patry.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/5/5,18:41
 *@Version:
 *@Package: com.smart.patry.business
 *注解解释：
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CustomAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomAdminApplication.class);
    }

}
