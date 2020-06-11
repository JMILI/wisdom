package com.smart.patry.business.feign;

import com.smart.patry.business.feign.dto.RegistActivityInfo;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.front.dto.PageParam;
import com.smart.patry.configuration.FeignRequestConfiguration;
import com.smart.patry.front.dto.PageParamByUsername;
import com.smart.patry.provider.domain.PatryNews;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/5/8,23:33
 *@Version:
 *@Package: com.smart.patry.business.feign.feignFallback
 *注解解释：
 *
 */
@FeignClient(
        value = "dashboard-client",
        path = "dashboard",
        configuration = FeignRequestConfiguration.class)
public interface DashboardFeign {


    @GetMapping(value = "fetchNewsList")
    String fetchNewsList();
    @GetMapping(value = "fetchActivityNewsList")
    String fetchActivityNewsList();
    @GetMapping(value = "fetchStudyList")
    String fetchStudyList();
    @PostMapping(value = "registActivity")
    String registActivity(@RequestBody RegistActivityInfo registActivityInfo);
    @GetMapping(value = "fetchFileList")
    String fetchFileList();
}
