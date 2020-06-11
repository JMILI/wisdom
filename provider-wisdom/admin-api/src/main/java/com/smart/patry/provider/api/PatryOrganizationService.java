package com.smart.patry.provider.api;

import com.smart.patry.provider.domain.PatryOrganization;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/5/7,15:40
 *@Version:
 *@Package: com.smart.patry.provider.api
 *注解解释：
 *
 */
public interface PatryOrganizationService {
    /**
     * 插入部门结构数据
     * @return
     */
    int insert(PatryOrganization patryOrganization);

//    /**
//     * 根据部门查看该部门组织结构
//     * @param unit
//     * @return
//     */
//    PatryOrganization findByUnit(String unit);


}



