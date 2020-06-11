package com.smart.patry.provider.service;

import com.smart.patry.provider.api.PatryAdminService;
import com.smart.patry.provider.domain.PatryAdmin;
import com.smart.patry.provider.mapper.PatryAdminMapper;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/4/26,20:17 @Version: @Package:
 * com.smart.patry.provider.service 注解解释：
 */
@Service(version = "1.0.0")
public class PatryAdminServiceImpl implements PatryAdminService {

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Resource
    private PatryAdminMapper patryAdminMapper;

    @Override
    /**
     * @Description : @Auther : JIMILI @Param: patryAdmin {@link PatryAdmin} @Return: int @Data 3:02
     * 2020/4/28
     *
     * @otherComment
     */
    public int insert(PatryAdmin patryAdmin) {
        initPatryAdmin(patryAdmin);
        return patryAdminMapper.insert(patryAdmin);
    }

    /**
     * @Description : 密码加密 @Auther : JIMILI @Param: PatryAdmin {@link PatryAdmin} @Return: @Data 3:00
     * 2020/4/28
     * @otherComment
     */
    private void initPatryAdmin(PatryAdmin patryAdmin) {
        if (patryAdmin.getPassword() == null || patryAdmin.getPassword() == "") {
            return;
        }
        patryAdmin.setPassword(passwordEncoder.encode(patryAdmin.getPassword()));
    }

    @Override
    /**
     * @Description : 根据账号获取管理员信息 @Auther : JIMILI @Param: patryAdminId {@link Integer} @Return:
     * com.smart.patry.provider.domain.PatryAdmin @Data 3:02 2020/4/28
     *
     * @otherComment
     */
    public PatryAdmin get(String username) {
        Example example = new Example(PatryAdmin.class);
        example.createCriteria().andEqualTo("username", username);

        List<PatryAdmin> patryAdminList = patryAdminMapper.selectByExample(example);
        if (patryAdminList.size() == 0) {
            return null;
        } else {
            return patryAdminList.get(0);
        }
    }

    @Override
    public int update(PatryAdmin patryAdmin) {
        initPatryAdmin(patryAdmin);
        return patryAdminMapper.updateByPrimaryKey(patryAdmin);
    }
}

