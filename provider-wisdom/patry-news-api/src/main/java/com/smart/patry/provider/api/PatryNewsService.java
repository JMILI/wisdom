package com.smart.patry.provider.api;

import com.smart.patry.provider.domain.PatryNews;

import java.util.List;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/7,20:25
 * @Version:
 * @Package: com.smart.patry.provider.api
 * 注解解释：
 */
public interface PatryNewsService {


    /**
     * 数据库插入公告数据
     *
     * @return
     */
    int insert(PatryNews patryNews);

    /**
     * 修改公告信息
     *
     * @return
     */
    int update(PatryNews patryNews);

    /**
     * 取消发布
     *
     * @return
     */
    int delete(String patryNewId);

    /**
     * 根据党部门单位获取公告
     *
     * @param loginUnit
     * @return
     */
    List<PatryNews> branchGetByUnit(String loginUnit);

    /**
     * 获取已发布的公告
     *
     * @param
     * @return
     */
    List<PatryNews> findNews();

    /**
     * 根据id查找
     *
     * @param patryNewsId
     * @return
     */
    PatryNews findById(String patryNewsId);

    /**
     * 根据该公告是否是学生可以参加活动的公告查找。找出只是通知类型的。
     * @return
     */
    List<PatryNews> findNewsNoActivity(String isActivity);

}







