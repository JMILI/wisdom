package com.smart.patry.cloud;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/31,16:59
 * @Version:
 * @Package: com.smart.patry.cloud
 * 注解解释：
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudUploadApplication.class, args);
    }

}
