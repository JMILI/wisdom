package com.smart.patry.provider.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.smart.patry.provider.domain.PatryNews;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.core.parameters.P;

import javax.annotation.Resource;
import com.smart.patry.provider.mapper.PatryNewsMapper;
import com.smart.patry.provider.api.PatryNewsService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/7,20:25 @Version: @Package:
 * com.smart.patry.provider.service 注解解释：
 */
@Service(version = "1.0.0")
class PatryNewsServiceImpl implements PatryNewsService {

  @Resource private PatryNewsMapper patryNewsMapper;

  /**
   * 查询发布的公告 管理员
   *
   * @return
   */
  @Override
  public List<PatryNews> branchGetByUnit(String loginUnit) {
    Example example = new Example(PatryNews.class);
    example.orderBy("patryNewsId").desc();
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("patryNewsUnit", loginUnit);
    return patryNewsMapper.selectByExample(example);
  }

  /**
   * 查询发布的公告
   *
   * @return
   */
  @Override
  public List<PatryNews> findNews() {
    Example example = new Example(PatryNews.class);
    example.orderBy("patryNewsId").desc();
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("patryNewsStatus", "发布");
    return patryNewsMapper.selectByExample(example);
  }

  /**
   * 根据id查找
   *
   * @param patryNewsId
   * @return
   */
  @Override
  public PatryNews findById(String patryNewsId) {
    return patryNewsMapper.selectByPrimaryKey(patryNewsId);
  }

  /**
   * 根据该公告是否是学生可以参加活动的公告查找。找出只是通知类型的。
   *
   * @return
   */
  @Override
  public List<PatryNews> findNewsNoActivity(String isActivity) {
    Example example = new Example(PatryNews.class);
    example.orderBy("patryNewsId").desc();
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("patryNewsStatus", "发布").andEqualTo("patryNewsActivity", isActivity);
    return patryNewsMapper.selectByExample(example);
  }

  /**
   * 数据库插入公告数据
   *
   * @param patryNews
   * @return
   */
  @Override
  public int insert(PatryNews patryNews) {
    if (patryNewsMapper.selectByPrimaryKey(patryNews.getPatryNewsId()) != null) {
      //           编辑之后不管之前状态是发布还是待发布，都设置成发布
      patryNews.setPatryNewsStatus("发布");
      patryNewsMapper.updateByPrimaryKeySelective(patryNews);
      return 1;
    } else {
      initInsertNews(patryNews);
      return patryNewsMapper.insertSelective(patryNews);
    }
  }

  public void initInsertNews(PatryNews patryNews) {
    //    PatryNews patryNews = new PatryNews();
    Format format = new SimpleDateFormat("yyyyMMddHHmmss");
    patryNews.setPatryNewsId(
        format.format(new Date())
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1)));
    patryNews.setPatryNewsTime(new Date());
    patryNews.setPatryNewsStatus("发布");
  }

  /**
   * 修改公告信息 根据主键更新信息
   *
   * @param patryNews
   * @return
   */
  @Override
  public int update(PatryNews patryNews) {
    return patryNewsMapper.updateByPrimaryKeySelective(patryNews);
  }

  /**
   * 取消发布
   *
   * @param patryNewId
   * @return
   */
  @Override
  public int delete(String patryNewId) {
    return patryNewsMapper.deleteByPrimaryKey(patryNewId);
  }
}
