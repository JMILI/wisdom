package com.smart.patry.business.feign;

import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.front.dto.PageParam;
import com.smart.patry.configuration.FeignRequestConfiguration;
import com.smart.patry.front.dto.PageParamByUsername;
import com.smart.patry.provider.domain.PatryActivity;
import com.smart.patry.provider.domain.PatryApply;
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
        value = "admin-management",
        path = "admin",
        configuration = FeignRequestConfiguration.class)
public interface BranchFeign {

    @PostMapping(value = "branch/apply/watch")
    String watchPatryApply(@RequestBody PageParamByUsername pageParamByUsername);

    @PostMapping(value = "branch/apply/update")
    String updateApply(@RequestBody PatryApply patryApply);

    /**
     * 增加活动申请
     * @param patryActivity
     * @return
     */
    @PostMapping(value = "branch/addActivity")
    String addActivity(@RequestBody PatryActivity patryActivity);

    /**
     * 获取某党组织单位的活动申请
     * @param loginUnit
     * @return
     */
    @GetMapping(value = "branch/fetchActivityList/{loginUnit}")
    String fetchActivityList(@PathVariable String loginUnit);

    /**
     * 根据id删除
     * @param patryActivityId
     * @return
     */
    @GetMapping(value = "branch/deleteActivity/{patryActivityId}")
    String deleteActivity(@PathVariable String patryActivityId);

    /**
     * 根据id查找
     * @param patryActivityId
     * @return
     */
    @GetMapping(value = "branch/fetchDataById/{patryActivityId}")
    String fetchDataById(@PathVariable String patryActivityId);

    /**
     * 增加公告
     * @param patryNews
     * @return
     */
    @PostMapping(value = "branch/addNews")
    String addNews(@RequestBody PatryNews patryNews);

    @GetMapping(value = "branch/fetchNewsList/{loginUnit}")
    String fetchNewsList(@PathVariable String loginUnit);

    /**
     * 根据id查找
     * @param patryNewsId
     * @return
     */
    @GetMapping(value = "branch/fetchNewsDataById/{patryNewsId}")
    String fetchNewsDataById(@PathVariable String patryNewsId);

    /**
     * 修改新闻状态
     * @param patryNews
     * @return
     */
    @PostMapping(value = "branch/updateNews")
    String updateNews(@RequestBody PatryNews patryNews);
    /**
     * 根据id删除
     * @param patryNewsId
     * @return
     */
    @GetMapping(value = "branch/deleteNewsById/{patryNewsId}")
    String deleteNewsById(@PathVariable String patryNewsId);



}
