package com.smart.patry.provider.api;

import com.github.pagehelper.PageInfo;
import com.smart.patry.front.dto.PageParamByUsername;
import com.smart.patry.provider.domain.PatryActivity;

import java.util.List;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/7,20:24
 * @Version:
 * @Package: com.smart.patry.provider.api
 * 注解解释：
 */
public interface PatryActivityService {
    /**
     * 党支部活动申请，插入数据
     *
     * @param patryActivity
     * @return
     */
    int insert(PatryActivity patryActivity);

    /**
     * 审批更新
     *
     * @param patryActivity
     * @return
     */
    int update(PatryActivity patryActivity);

    /**
     * 人事处查询需要审批的活动
     * 党支部：同意，党总支：不同，人事处：待审核，状态：审核中
     *
     * @return
     */
    PageInfo<PatryActivity> personWatch(PageParamByUsername pageParamByUsername,List<String> list);

    /**
     * 数据库根据id查询详细信息
     *
     * @param patryActivityId
     * @return
     */
    PatryActivity findById(String patryActivityId);

    /**
     * 根据党组织单位查询
     * @param loginUnit
     * @return
     */
    List<PatryActivity> branchGetByUnit(String loginUnit);

    /**
     * 根据id删除
     * @param patryActivityId
     * @return
     */
    int deleteById(String patryActivityId);

    PageInfo<PatryActivity> headWatch(PageParamByUsername pageParamByUsername, List<String> stringList);
}






