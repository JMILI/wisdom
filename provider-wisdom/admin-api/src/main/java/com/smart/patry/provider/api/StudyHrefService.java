package com.smart.patry.provider.api;

import com.smart.patry.provider.domain.StudyHref;

import java.util.List;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/26,0:04
 * @Version:
 * @Package: com.smart.patry.provider.service
 * 注解解释：
 */
public interface StudyHrefService {

    /**
     * 查找所有学习连接
     *
     * @return
     */
    List<StudyHref> findStudyNews();

    /**
     *添加学习链接
     * @param studyHref
     * @return
     */
    int insert(StudyHref studyHref);

    /**
     * 根据部门获取学习链接
     * @param loginUnit
     * @return
     */
    List<StudyHref> GetByUnit(String loginUnit,List<String > list);

    /**
     * 更新学习链接的发布状态
     * @param studyHref
     * @return
     */
    int update(StudyHref studyHref);

    /**
     * 删除某个学习链接
     * @param studyId
     * @return
     */
    int delete(String studyId);
}

