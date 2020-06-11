package com.smart.patry.provider.api;

import com.smart.patry.provider.domain.ExternalTeacher;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/7,20:21
 * @Version:
 * @Package: com.smart.patry.provider.api
 * 注解解释：
 */
public interface ExternalTeacherService {

    ExternalTeacher get(String username);

    int insert(ExternalTeacher externalTeacher);
}



