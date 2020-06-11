package com.smart.patry.provider.api;

import com.smart.patry.provider.domain.PatryAdmin;

/**
 * @Description: @Author: JIMILI, @Data: 2020/4/26,20:17 @Version: @Package:
 * com.smart.patry.provider.api 注解解释：
 */
public interface PatryAdminService {

    int insert(PatryAdmin patryAdmin);

    PatryAdmin get(String username);

    int update(PatryAdmin patryAdmin);

}




