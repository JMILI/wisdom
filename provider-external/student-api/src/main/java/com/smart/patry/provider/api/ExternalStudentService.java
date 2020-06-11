package com.smart.patry.provider.api;

import com.smart.patry.provider.domain.ExternalStudent;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/7,20:01 @Version: @Package:
 * com.smart.patry.provider.api 注解解释：
 */
public interface ExternalStudentService {
    /**
     * 根据username获取学生信息
     *
     * @param username
     * @return
     */
    ExternalStudent get(String username);

    /**
     * 学生表中插入学生
     *
     * @param externalStudent
     * @return
     */
    int insert(ExternalStudent externalStudent);
}


