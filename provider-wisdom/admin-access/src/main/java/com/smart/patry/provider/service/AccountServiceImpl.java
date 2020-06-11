package com.smart.patry.provider.service;

import javax.annotation.Resource;

import com.smart.patry.provider.domain.Account;
import com.smart.patry.provider.domain.PatryAdmin;
import com.smart.patry.provider.mapper.AccountMapper;
import com.smart.patry.provider.api.AccountService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/23,17:03 @Version: @Package:
 * com.smart.patry.provider.service 注解解释：
 */
@Service(version = "1.0.0")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;
    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 根据username查找
     *
     * @param username
     * @return
     */
    @Override
    public Account get(String username) {
        return accountMapper.selectByPrimaryKey(username);
    }

    /**
     * 插入账户信息
     *
     * @param account1
     * @return
     */
    @Override
    public int insert(Account account1) {
        init(account1);
        return accountMapper.insert(account1);
    }

    /**
     * 初始化
     *
     * @param account1
     */
    private void init(Account account1) {
        account1.setPassword(passwordEncoder.encode(account1.getPassword()));
        account1.setLoginUnit("");
    }
}


