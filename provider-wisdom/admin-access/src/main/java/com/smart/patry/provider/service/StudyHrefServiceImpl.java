package com.smart.patry.provider.service;

import com.smart.patry.provider.domain.StudyHref;

import javax.annotation.Resource;
import com.smart.patry.provider.mapper.StudyHrefMapper;
import com.smart.patry.provider.api.StudyHrefService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/26,0:04 @Version: @Package:
 * com.smart.patry.provider.service 注解解释：
 */
@Service(version = "1.0.0")
public class StudyHrefServiceImpl implements StudyHrefService {

  @Resource private StudyHrefMapper studyHrefMapper;

  /**
   * 查找所有学习连接
   *
   * @return
   */
  @Override
  public List<StudyHref> findStudyNews() {
    Example example = new Example(StudyHref.class);
    example.orderBy("studyId").desc();
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("studyStatus", "发布");
    return studyHrefMapper.selectByExample(example);
  }

  /**
   * 添加学习链接
   *
   * @param studyHref
   * @return
   */
  @Override
  public int insert(StudyHref studyHref) {
    init(studyHref);
    return studyHrefMapper.insert(studyHref);
  }

  /**
   * 根据部门获取学习链接
   *
   * @param loginUnit
   * @param list
   * @return
   */
  @Override
  public List<StudyHref> GetByUnit(String loginUnit, List<String> list) {
    Example example = new Example(StudyHref.class); // 实例化

    Example.Criteria criteria1 = example.createCriteria();
    //        Example.Criteria criteria2 = example.createCriteria();
    example.orderBy("studyId").desc();
    if (list != null) {
      for (String item : list) {
        criteria1.orEqualTo("studyUploadUnit", item);
      }
    }
    criteria1.orEqualTo("studyUploadUnit", loginUnit);

    List<StudyHref> studyHrefList = studyHrefMapper.selectByExample(example);
    return studyHrefList;
  }

  /**
   * 更新学习链接的发布状态
   *
   * @param studyHref
   * @return
   */
  @Override
  public int update(StudyHref studyHref) {
    return studyHrefMapper.updateByPrimaryKeySelective(studyHref);
  }

  /**
   * 删除某个学习链接
   *
   * @param studyId
   * @return
   */
  @Override
  public int delete(String studyId) {
    return studyHrefMapper.deleteByPrimaryKey(studyId);
  }

  private void init(StudyHref studyHref) {
    Format format = new SimpleDateFormat("yyyyMMddHHmmss");
    studyHref.setStudyId(
        format.format(new Date())
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1)));
    studyHref.setStudyUploadTime(new Date());
    studyHref.setStudyStatus("发布");
  }
}
