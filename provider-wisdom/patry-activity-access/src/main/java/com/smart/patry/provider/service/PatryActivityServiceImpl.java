package com.smart.patry.provider.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.github.pagehelper.PageInfo;
import com.smart.patry.front.dto.PageParamByUsername;
import com.smart.patry.provider.domain.PatryActivity;

import javax.annotation.Resource;
import com.smart.patry.provider.mapper.PatryActivityMapper;
import com.smart.patry.provider.api.PatryActivityService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/7,20:24 @Version: @Package:
 * com.smart.patry.provider.service 注解解释：
 */
@Service(version = "1.0.0")
public class PatryActivityServiceImpl implements PatryActivityService {

  @Resource private PatryActivityMapper patryActivityMapper;

  /**
   * 党支部活动申请，插入数据
   *
   * @param patryActivity
   * @return
   */
  @Override
  public int insert(PatryActivity patryActivity) {
    if (patryActivityMapper.selectByPrimaryKey(patryActivity.getPatryActivityId()) != null) {
      patryActivityMapper.updateByPrimaryKeySelective(patryActivity);
      return 1;
    } else {
      initApplyTable(patryActivity);
      return patryActivityMapper.insertSelective(patryActivity);
    }
  }

  private void initApplyTable(PatryActivity patryActivity) {
    Format format = new SimpleDateFormat("yyyyMMddHHmmss");

    patryActivity.setPatryActivityId(
        format.format(new Date())
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1)));
    patryActivity.setPatryActivityApplytime(new Date());

    patryActivity.setPatryActivityHeadopinion("待审核");
    patryActivity.setPatryActivityHeadhandler("");
    patryActivity.setPatryActivityPersonopinion("待审核");
    patryActivity.setPatryActivityPersonhandler("");
    patryActivity.setPatryActivityDenialreason("");
    patryActivity.setPatryActivityStatus("审核中");
  }

  /**
   * 审批表更新
   *
   * @param patryActivity
   * @return
   */
  @Override
  public int update(PatryActivity patryActivity) {
    return patryActivityMapper.updateByPrimaryKeySelective(patryActivity);
  }

  /**
   * 人事处查询需要审批的活动 党支部：同意，党总支：不同，人事处：待审核，状态：审核中
   *
   * @return
   */
  @Override
  public PageInfo<PatryActivity> personWatch(
      PageParamByUsername pageParamByUsername, List<String> list) {
    Example example = new Example(PatryActivity.class); // 实例化
    Example.Criteria criteria = example.createCriteria();
    Example.Criteria criteria1 = example.createCriteria();
    //    党支部
    if (pageParamByUsername.getSort().equals("+id")) {
      example.orderBy("patryActivityId").asc();
    } else {
      example.orderBy("patryActivityId").desc();
    }
    criteria
        //                党总支意见
        .andEqualTo("patryActivityHeadopinion", "同意")
        .andEqualTo("patryActivityPersonopinion", "待审核")
        .andEqualTo("patryActivityStatus", "审核中");
    if (pageParamByUsername.getTitle() != "") {
      criteria.andLike("patryActivityTheme", "%" + pageParamByUsername.getTitle() + "%");
    }
    if (list != null) {
      for (String item : list) {
        criteria1.orEqualTo("patryActivityPatryunit", item);
      }
    }
    criteria1.orEqualTo("patryActivityPatryunit", pageParamByUsername.getUnit());
    example.and(criteria1);
    List<PatryActivity> patryActivityLists = patryActivityMapper.selectByExample(example);

    List<PatryActivity> patryActivityList =
        patryActivityMapper.selectByExampleAndRowBounds(
            example,
            new RowBounds(
                (pageParamByUsername.getPage() - 1) * pageParamByUsername.getLimit(),
                pageParamByUsername.getLimit()));
    PageInfo<PatryActivity> pageInfo = new PageInfo<PatryActivity>(patryActivityList);
    pageInfo.setTotal(patryActivityLists.size());
    return pageInfo;
  }

  /**
   * 数据库根据id查询详细信息
   *
   * @param patryActivityId
   * @return
   */
  @Override
  public PatryActivity findById(String patryActivityId) {
    return patryActivityMapper.selectByPrimaryKey(patryActivityId);
  }

  /**
   * 根据党组织单位查询
   *
   * @param loginUnit
   * @return
   */
  @Override
  public List<PatryActivity> branchGetByUnit(String loginUnit) {
    Example example = new Example(PatryActivity.class); // 实例化
    example.orderBy("patryActivityId").desc();
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("patryActivityPatryunit", loginUnit);

    List<PatryActivity> patryApplyList = patryActivityMapper.selectByExample(example);
    return patryApplyList;
  }

  /**
   * 根据id删除
   *
   * @param patryActivityId
   * @return
   */
  @Override
  public int deleteById(String patryActivityId) {
    return patryActivityMapper.deleteByPrimaryKey(patryActivityId);
  }
  /**
   * 党总支根据： 1.党支部为：同意 2.党总支：待审核 3.状态：审核中 三个条件都满足的条件小查找。并返回list
   *
   * @return
   */
  @Override
  public PageInfo<PatryActivity> headWatch(
      PageParamByUsername pageParamByUsername, List<String> stringList) {
    Example example = new Example(PatryActivity.class); // 实例化
    Example.Criteria criteria1 = example.createCriteria();
    Example.Criteria criteria2 = example.createCriteria();
    //    党支部
    if (pageParamByUsername.getSort().equals("+id")) {
      example.orderBy("patryActivityId").asc();
    } else {
      example.orderBy("patryActivityId").desc();
    }

    criteria1
        .andEqualTo("patryActivityHeadopinion", "待审核")
        .andEqualTo("patryActivityStatus", "审核中");
    if (pageParamByUsername.getTitle() != "") {
      criteria1.andLike("patryActivityTheme", "%" + pageParamByUsername.getTitle() + "%");
    }
    if (stringList != null) {
      for (String item : stringList) {
        criteria2.orEqualTo("patryActivityPatryunit", item);
      }
    }
    criteria2.orEqualTo("patryActivityPatryunit", pageParamByUsername.getUnit());

    example.and(criteria2);
    List<PatryActivity> patryActivityLists = patryActivityMapper.selectByExample(example);

    List<PatryActivity> patryActivityList =
        patryActivityMapper.selectByExampleAndRowBounds(
            example,
            new RowBounds(
                (pageParamByUsername.getPage() - 1) * pageParamByUsername.getLimit(),
                pageParamByUsername.getLimit()));
    PageInfo<PatryActivity> pageInfo = new PageInfo<PatryActivity>(patryActivityList);
    pageInfo.setTotal(patryActivityLists.size());
    return pageInfo;
  }
}
