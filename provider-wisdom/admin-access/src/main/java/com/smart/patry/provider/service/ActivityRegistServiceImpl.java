package com.smart.patry.provider.service;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;
import com.smart.patry.front.dto.PageParam;
import com.smart.patry.provider.domain.ActivityRegist;
import com.smart.patry.provider.mapper.ActivityRegistMapper;
import com.smart.patry.provider.api.ActivityRegistService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/29,1:58 @Version: @Package:
 * com.smart.patry.provider.service 注解解释：
 */
@Service(version = "1.0.0")
public class ActivityRegistServiceImpl implements ActivityRegistService {

  @Resource private ActivityRegistMapper activityRegistMapper;

  private void init(ActivityRegist activityRegist) {
    Format format = new SimpleDateFormat("yyyyMMddHHmmss");
    activityRegist.setActRegistId(
        format.format(new Date())
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1)));
    //    if (activityRegist.getActRegistUnit() == "") {
    //      activityRegist.setActRegistUnit("无");
    //    }
    activityRegist.setActRegistSignIn("");
  }
  /**
   * 插入
   *
   * @param activityRegist
   * @return
   */
  @Override
  public int insert(ActivityRegist activityRegist) {
    init(activityRegist);
    return activityRegistMapper.insert(activityRegist);
  }

  /**
   * 根据username和活动id查找
   *
   * @param actRegistUsername
   * @param actRegistActivityid
   * @return
   */
  @Override
  public boolean getByUsernameAndActivityId(String actRegistUsername, String actRegistActivityid) {
    Example example = new Example(ActivityRegist.class); // 实例化
    Example.Criteria criteria = example.createCriteria();
    criteria
        .andEqualTo("actRegistUsername", actRegistUsername)
        .andEqualTo("actRegistActivityid", actRegistActivityid);
    List<ActivityRegist> activityRegists = activityRegistMapper.selectByExample(example);
    if (activityRegists.size() > 0) {
      return true;
    }
    return false;
  }

  /**
   * 根据党部门查找，活动主题，人名模糊查找。
   *
   * @param pageParam
   * @param stringList
   * @return
   */
  @Override
  public PageInfo<ActivityRegist> getActRegistList(PageParam pageParam, List<String> stringList) {
    Example example = new Example(ActivityRegist.class); // 实例化

    Example.Criteria criteria1 = example.createCriteria();
    Example.Criteria criteria2 = example.createCriteria();
    // 党支部
    if (pageParam.getSort().equals("+id")) {
      example.orderBy("actRegistId").asc();
    } else {
      example.orderBy("actRegistId").desc();
    }
    if (stringList != null) {
      for (String item : stringList) {
        criteria1.orEqualTo("actRegistUnit", item);
      }
    }
    criteria1.orEqualTo("actRegistUnit", pageParam.getUnit());
    criteria1.orEqualTo("actRegistUnit", "");

    if (pageParam.getTitle() != "") {
      criteria2.andLike("actRegistTheme", "%" + pageParam.getTitle() + "%");
    }
    if (pageParam.getApplicantName() != "") {
      criteria2.andLike("actRegistName", "%" + pageParam.getApplicantName() + "%");
    }
    example.and(criteria2);

    List<ActivityRegist> activityRegistList = activityRegistMapper.selectByExample(example);

    List<ActivityRegist> activityRegists =
        activityRegistMapper.selectByExampleAndRowBounds(
            example,
            new RowBounds((pageParam.getPage() - 1) * pageParam.getLimit(), pageParam.getLimit()));
    PageInfo<ActivityRegist> pageInfo = new PageInfo<ActivityRegist>(activityRegists);
    pageInfo.setTotal(activityRegistList.size());
    return pageInfo;
  }

  /**
   * 删除已经过期的活动
   *
   * @param activityRegistList
   * @return
   */
  @Override
  public boolean delete(List<ActivityRegist> activityRegistList) {
    boolean delete = false;
    for (ActivityRegist item : activityRegistList) {
      activityRegistMapper.delete(item);
      delete = true;
    }
    return delete;
  }
}
