package com.smart.patry.provider.service;

import com.smart.patry.provider.domain.ExternalStudent;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import com.smart.patry.provider.mapper.ExternalStudentMapper;
import com.smart.patry.provider.api.ExternalStudentService;
import tk.mybatis.mapper.entity.Example;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/7,20:01
 * @Version:
 * @Package: com.smart.patry.provider.service
 * 注解解释：
 */
@Service(version = "1.0.0")
public class ExternalStudentServiceImpl implements ExternalStudentService {
//    @Resource
//    private BCryptPasswordEncoder passwordEncoder;

    @Resource
    private ExternalStudentMapper externalStudentMapper;

    /**
     * 根据username查找
     *
     * @param username
     * @return
     */
    @Override
    public ExternalStudent get(String username) {
        return externalStudentMapper.selectByPrimaryKey(username);
    }

    /**
     * 学生表中插入学生
     *
     * @param externalStudent
     * @return
     */
    @Override
    public int insert(ExternalStudent externalStudent) {
        return externalStudentMapper.insertSelective(externalStudent);
    }

}


