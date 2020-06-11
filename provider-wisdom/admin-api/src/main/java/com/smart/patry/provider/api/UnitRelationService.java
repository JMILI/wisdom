package com.smart.patry.provider.api;

import java.util.List;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/23,17:03
 * @Version:
 * @Package: com.smart.patry.provider.service
 * 注解解释：
 */
public interface UnitRelationService {

    /**
     * 获取所有部门名称
     *
     * @return
     */
    List<String> acquireUnitData();

    /**
     * 根据上级部门查找其管理的下级部门
     *
     * @param username
     * @return
     */
    List<String> getUnitBySuperUnit(String username);
}

