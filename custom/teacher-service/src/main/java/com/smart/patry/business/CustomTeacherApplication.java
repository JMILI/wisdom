package com.smart.patry.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/5/7,21:37
 *@Version:
 *@Package: com.smart.patry.business
 *注解解释：
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CustomTeacherApplication {
  public static void main(String[] args) {
      SpringApplication.run(CustomTeacherApplication.class,args);
  }
}
