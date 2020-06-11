package com.smart.patry.provider.service;

import com.smart.patry.provider.domain.ExternalTeacher;

import javax.annotation.Resource;
import com.smart.patry.provider.mapper.ExternalTeacherMapper;
import com.smart.patry.provider.api.ExternalTeacherService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/7,20:21
 * @Version:
 * @Package: com.smart.patry.provider.service
 * 注解解释：
 */
@Service(version = "1.0.0")
public class ExternalTeacherServiceImpl implements ExternalTeacherService {

    @Resource
    private ExternalTeacherMapper externalTeacherMapper;

    @Override
    public ExternalTeacher get(String username) {
        return externalTeacherMapper.selectByPrimaryKey(username);
    }

    @Override
    public int insert(ExternalTeacher externalTeacher) {
        return 0;
    }
}



