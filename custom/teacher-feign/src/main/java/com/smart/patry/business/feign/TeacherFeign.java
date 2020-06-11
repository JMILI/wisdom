package com.smart.patry.business.feign;

import com.smart.patry.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/5/8,17:04
 *@Version:
 *@Package: com.smart.patry.business.feign
 *注解解释：
 *
 */
@FeignClient(value = "teacher-client", path = "teacher", configuration = FeignRequestConfiguration.class)
public interface TeacherFeign {
    /**
     * 获取个人信息
     *
     * @param username {@code String} 用户名
     * @return {@code String} JSON
     */
    @GetMapping(value = "info/{username}")
    String info(@PathVariable String username);
}
