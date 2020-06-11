package com.smart.patry.provider;

//import com.smart.patry.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/4/26,20:24
 *@Version:
 *@Package: com.smart.patry.provider
 *注解解释：
 *
 */
//@SpringBootApplication(scanBasePackageClasses = {PatryAdminApplication.class, DubboSentinelConfiguration.class})
@SpringBootApplication
@MapperScan(basePackages = "com.smart.patry.provider.mapper")
public class ProviderPatryAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPatryAdminApplication.class, args);
    }
}
