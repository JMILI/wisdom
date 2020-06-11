package com.smart.patry.provider.api;

import com.github.pagehelper.PageInfo;
import com.smart.patry.front.dto.PageParam;
import com.smart.patry.provider.domain.PatryMember;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/7,15:40
 * @Version:
 * @Package: com.smart.patry.provider.api
 * 注解解释：
 */
public interface PatryMemberService {
    /**
     * 初次插入，党员身份都是积极分子
     *
     * @param patryMember
     * @return
     */
    int insert(PatryMember patryMember);

    /**
     * 更新党员信息
     * 管理员可以修改：身份，组织关系
     *
     * @param patryMember
     * @return
     */
    int update(PatryMember patryMember);

    /**
     * 根据学生 学工号，或教师的教职工号查询
     * @param patryApplyUsername
     * @return
     */
    PatryMember get(String patryApplyUsername);

    /**
     * 查找所有预备党员
     * @param pageParam
     * @return
     */
    PageInfo<PatryMember> personProbationaryWatch(PageParam pageParam);
}



