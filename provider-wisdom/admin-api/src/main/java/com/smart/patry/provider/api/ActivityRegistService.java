package com.smart.patry.provider.api;

import com.github.pagehelper.PageInfo;
import com.smart.patry.front.dto.PageParam;
import com.smart.patry.provider.domain.ActivityRegist;

import java.util.List;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/29,1:58
 * @Version:
 * @Package: com.smart.patry.provider.api
 * 注解解释：
 */
public interface ActivityRegistService {

    /**
     * 插入
     *
     * @param activityRegist
     * @return
     */
    int insert(ActivityRegist activityRegist);

    /**
     * 根据username和活动id查找
     * @param actRegistUsername
     * @param actRegistActivityid
     * @return
     */
    boolean getByUsernameAndActivityId(String actRegistUsername, String actRegistActivityid);

    /**
     * 根据党部门查找，活动主题，人名模糊查找。
     * @param pageParam
     * @param stringList
     * @return
     */
    PageInfo<ActivityRegist> getActRegistList(PageParam pageParam, List<String> stringList);

    /**
     * 删除已经过期的活动
     * @param activityRegistList
     * @return
     */
    boolean delete(List<ActivityRegist> activityRegistList);
}

