package com.smart.patry.business.feign;

import com.smart.patry.configuration.FeignRequestConfiguration;
import com.smart.patry.front.dto.PageParamByUsername;
import com.smart.patry.provider.domain.PatryActivity;
import com.smart.patry.provider.domain.PatryApply;
import org.springframework.cloud.openfeign.FeignClient;
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
        value = "admin-management",
        path = "admin",
        configuration = FeignRequestConfiguration.class)
public interface HeadFeign {
    /**
     * 获取党总支所管辖的党支部下的学生，或者教师申请
     * @param pageParamByUsername
     * @return
     */
    @PostMapping(value = "head/fetchApplyList")
    String fetchApplyList(@RequestBody PageParamByUsername pageParamByUsername);

    /**
     * 审批党内党员申请
     * @param patryApply
     * @return
     */
    @PostMapping(value = "head/updateApply")
    String updateApply(@RequestBody PatryApply patryApply);

    /**
     * 获取党总支所管辖的党支部下的活动申请
     * @param pageParamByUsername
     * @return
     */
    @PostMapping(value = "head/fetchActivityList")
    String fetchActivityList(@RequestBody PageParamByUsername pageParamByUsername);

    /**
     * 审批党支部活动申请
     * @param patryActivity
     * @return
     */
    @PostMapping(value = "head/updateActivity")
    String updateActivity(@RequestBody PatryActivity patryActivity);

}
