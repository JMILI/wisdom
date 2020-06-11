package com.smart.patry.provider.api;

import com.smart.patry.provider.domain.FileSave;

import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/6/8,21:28 @Version: @Package:
 * com.smart.patry.provider.api 注解解释：
 */
public interface FileSaveService {
    /**
     * 根据id主键删除
     * @param fileId
     * @return
     */
  int delete(String fileId);

    /**
     * 添加
     * @param fileSave
     * @return
     */
  int insert(FileSave fileSave);

    /**
     * 根据部门查找
     * @param loginUnit
     * @param stringList
     * @return
     */
  List<FileSave> GetByUnit(String loginUnit, List<String> stringList);

    /**
     * 更新
     * @param fileSave
     * @return
     */
  int update(FileSave fileSave);

  /**
   * 查找已经发布的
   * @return
   */
  List<FileSave> findFiles();
}
