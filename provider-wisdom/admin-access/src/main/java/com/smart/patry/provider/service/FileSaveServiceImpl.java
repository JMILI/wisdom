package com.smart.patry.provider.service;

import javax.annotation.Resource;

import com.smart.patry.provider.domain.FileSave;
import com.smart.patry.provider.domain.StudyHref;
import com.smart.patry.provider.mapper.FileSaveMapper;
import com.smart.patry.provider.api.FileSaveService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/6/8,21:28 @Version: @Package:
 * com.smart.patry.provider.service 注解解释：
 */
@Service(version = "1.0.0")
public class FileSaveServiceImpl implements FileSaveService {

  @Resource private FileSaveMapper fileSaveMapper;

  /**
   * 根据id主键删除
   *
   * @param fileId
   * @return
   */
  @Override
  public int delete(String fileId) {
    return fileSaveMapper.deleteByPrimaryKey(fileId);
  }

  /**
   * 添加
   *
   * @param fileSave
   * @return
   */
  @Override
  public int insert(FileSave fileSave) {
    init(fileSave);
    return fileSaveMapper.insertSelective(fileSave);
  }

  private void init(FileSave fileSave) {
    Format format = new SimpleDateFormat("yyyyMMddHHmmss");
    fileSave.setFileId(
        format.format(new Date())
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1)));
    fileSave.setFileTime(new Date());
    fileSave.setFileStatus("发布");
  }

  /**
   * 根据部门查找
   *
   * @param loginUnit
   * @param stringList
   * @return
   */
  @Override
  public List<FileSave> GetByUnit(String loginUnit, List<String> stringList) {
    Example example = new Example(FileSave.class); // 实例化

    Example.Criteria criteria1 = example.createCriteria();
    //        Example.Criteria criteria2 = example.createCriteria();
    example.orderBy("fileId").desc();
    if (stringList != null) {
      for (String item : stringList) {
        criteria1.orEqualTo("fileUploaderUnit", item);
      }
    }
    criteria1.orEqualTo("fileUploaderUnit", loginUnit);

    List<FileSave> fileSaveList = fileSaveMapper.selectByExample(example);
    return fileSaveList;
  }

  /**
   * 更新
   *
   * @param fileSave
   * @return
   */
  @Override
  public int update(FileSave fileSave) {
    return fileSaveMapper.updateByPrimaryKeySelective(fileSave);
  }

  /**
   * 查找已经发布的
   *
   * @return
   */
  @Override
  public List<FileSave> findFiles() {
    Example example = new Example(FileSave.class);
    example.orderBy("fileId").desc();
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("fileStatus", "发布");
    return fileSaveMapper.selectByExample(example);
  }
}
