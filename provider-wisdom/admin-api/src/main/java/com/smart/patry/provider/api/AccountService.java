package com.smart.patry.provider.api;

import com.smart.patry.provider.domain.Account;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/23,17:03 @Version: @Package:
 * com.smart.patry.provider.service 注解解释：
 */
public interface AccountService {
    /**
     * 根据username查找
     *
     * @param username
     * @return
     */
    Account get(String username);

    /**
     * 插入账户信息
     *
     * @param account1
     * @return
     */
    int insert(Account account1);
}

