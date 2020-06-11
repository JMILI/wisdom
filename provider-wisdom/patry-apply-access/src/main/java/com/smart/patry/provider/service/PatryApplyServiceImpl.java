package com.smart.patry.provider.service;

// import com.github.pagehelper.PageHelper;
// import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.patry.front.dto.PageParam;
import com.smart.patry.front.dto.PageParamByUsername;
import com.smart.patry.provider.domain.PatryApply;

import javax.annotation.Resource;
import com.smart.patry.provider.mapper.PatryApplyMapper;
import com.smart.patry.provider.api.PatryApplyService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/7,20:25 @Version: @Package:
 * com.smart.patry.provider.service 注解解释：
 */
@Service(version = "1.0.0")
public class PatryApplyServiceImpl implements PatryApplyService {

  @Resource private PatryApplyMapper patryApplyMapper;

  /**
   * 学生党内申请插入
   *
   * @param patryApply
   * @return
   */
  @Override
  public int insert(PatryApply patryApply) {
    Example example = new Example(PatryApply.class);
    Example.Criteria criteria = example.createCriteria();
    criteria
        .andEqualTo("patryApplyTheme", patryApply.getPatryApplyTheme())
        .andEqualTo("patryApplyUsername", patryApply.getPatryApplyUsername())
        .andEqualTo("patryApplyStatus", "审核中");

    List<PatryApply> patryApplyList = patryApplyMapper.selectByExample(example);
    if (patryApplyList.size() > 0) {
      //            已经有一个相同主题的申请了。
      return -1;
    } else {
      // 初次插入数据，进行初始化，主要有订单id 和系统时间
      initApplyTable(patryApply);
      return patryApplyMapper.insertSelective(patryApply);
    }
  }

  public void initApplyTable(PatryApply patryApply) {
    // 申请订单id
    // 转换提日期输出格式
    //        System.out.println((int)((Math.random()*9+1)*1000));
    Format format = new SimpleDateFormat("yyyyMMddHHmmss");
    patryApply.setPatryApplyId(
        format.format(new Date())
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1))
            + String.valueOf((int) (Math.random() * 9 + 1)));
    //    申请时间20001-12-05 8:00:00
    patryApply.setPatryApplyApplytime(new Date());
    //    党支部默认意见
    patryApply.setPatryApplyBranchopinion("待审核");
    //    党总支默认意见
    patryApply.setPatryApplyHeadopinon("待审核");
    //    人事处默认意见
    patryApply.setPatryApplyPersonopinon("待审核");
    //    申请订单状态
    patryApply.setPatryApplyStatus("审核中");

    patryApply.setPatryApplyPatryperiod("");
    patryApply.setPatryApplyBranchhandler("");
    patryApply.setPatryApplyHeadhandler("");
    patryApply.setPatryApplyPersonhandler("");
    patryApply.setPatryApplyOtheropinion("");
    patryApply.setPatryApplyDenialreason("");
  }

  /**
   * 党部门审查，填写其他字段的值 这里必须有主键
   *
   * @param patryApply
   * @return
   */
  @Override
  public int update(PatryApply patryApply) {
    return patryApplyMapper.updateByPrimaryKeySelective(patryApply);
  }

  /**
   * 学生取消申请,前端出入申请订单的id
   *
   * @param applyId
   * @return
   */
  @Override
  public int delete(String applyId) {
    return patryApplyMapper.deleteByPrimaryKey(applyId);
  }

  /**
   * 学生或教师根据自己的账号和申请订单的状态查询自己申请的进度，状态为审核中
   *
   * @param username
   * @return
   */
  @Override
  public List<PatryApply> findByUsername(String username) {
    Example example = new Example(PatryApply.class); // 实例化
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("patryApplyUsername", username);
    List<PatryApply> patryApplyList = patryApplyMapper.selectByExample(example);
    return patryApplyList;
  }

  /**
   * 党总支根据： 1.党支部为：不同意 2.状态：审核中 三个条件都满足的条件小查找。并返回list
   *
   * @return
   */
  @Override
  public PageInfo<PatryApply> branchWatch(PageParamByUsername pageParamByUsername, String unit) {
    Example example = new Example(PatryApply.class); // 实例化
    Example.Criteria criteria = example.createCriteria();

    if (pageParamByUsername.getSort().equals("+id")) {
      example.orderBy("patryApplyId").asc();
    } else {
      example.orderBy("patryApplyId").desc();
    }
    if (pageParamByUsername.getTitle() != "") {
      criteria.andEqualTo("patryApplyTheme", pageParamByUsername.getTitle());
    }
    //    党支部
    criteria
        .andEqualTo("patryApplyBranchopinion", "待审核")
        .andEqualTo("patryApplyStatus", "审核中")
        .andEqualTo("patryApplyPatryunit", unit);

    List<PatryApply> patryApplyLists = patryApplyMapper.selectByExample(example);
    List<PatryApply> patryApplyList =
        patryApplyMapper.selectByExampleAndRowBounds(
            example,
            new RowBounds(
                (pageParamByUsername.getPage() - 1) * pageParamByUsername.getLimit(),
                pageParamByUsername.getLimit()));
    PageInfo<PatryApply> pageInfo = new PageInfo<PatryApply>(patryApplyList);
    pageInfo.setTotal(patryApplyLists.size());
    return pageInfo;
  }

  /**
   * 党总支根据： 1.党支部为：同意 2.党总支：不同意 3.状态：审核中 三个条件都满足的条件小查找。并返回list
   *
   * @return
   */
  @Override
  public PageInfo<PatryApply> headWatch(
      PageParamByUsername pageParamByUsername, List<String> list) {

    Example example = new Example(PatryApply.class); // 实例化

    Example.Criteria criteria1 = example.createCriteria();
    Example.Criteria criteria2 = example.createCriteria();
    // 党支部
    if (pageParamByUsername.getSort().equals("+id")) {
      example.orderBy("patryApplyId").asc();
    } else {
      example.orderBy("patryApplyId").desc();
    }
    if (list != null) {
      for (String item : list) {
        criteria1.orEqualTo("patryApplyPatryunit", item);
      }
    }
    criteria1.orEqualTo("patryApplyPatryunit", pageParamByUsername.getUnit());
    criteria2
        .andEqualTo("patryApplyBranchopinion", "同意")
        .andEqualTo("patryApplyHeadopinon", "待审核")
        .andEqualTo("patryApplyStatus", "审核中");
    if (pageParamByUsername.getTitle() != "") {
      criteria2.andEqualTo("patryApplyTheme", pageParamByUsername.getTitle());
    }
    example.and(criteria2);

    List<PatryApply> patryApplyLists = patryApplyMapper.selectByExample(example);

    List<PatryApply> patryApplyList =
        patryApplyMapper.selectByExampleAndRowBounds(
            example,
            new RowBounds(
                (pageParamByUsername.getPage() - 1) * pageParamByUsername.getLimit(),
                pageParamByUsername.getLimit()));
    PageInfo<PatryApply> pageInfo = new PageInfo<PatryApply>(patryApplyList);
    pageInfo.setTotal(patryApplyLists.size());
    return pageInfo;
  }

  /**
   * 人事部根据： 1.党支部为：同意 2.党总支：同意 3.状态：审核中 三个条件都满足的条件小查找。并返回list
   *
   * @return
   */
  @Override
  public PageInfo<PatryApply> personWatch(PageParam pageParam) {
    Example example = new Example(PatryApply.class); // 实例化
    Example.Criteria criteria1 = example.createCriteria();
    Example.Criteria criteria2 = example.createCriteria();
    //    党支部
    if (pageParam.getSort().equals("+id")) {
      example.orderBy("patryApplyId").asc();
    } else {
      example.orderBy("patryApplyId").desc();
    }
    if (pageParam.getTitle() != "") {
      criteria1.andEqualTo("patryApplyTheme", pageParam.getTitle());
    }
    criteria1
        .andEqualTo("patryApplyBranchopinion", "同意")
        .andEqualTo("patryApplyHeadopinon", "同意")
        .andEqualTo("patryApplyPersonopinon", "待审核")
        .andEqualTo("patryApplyStatus", "审核中");
    if (pageParam.getApplicantName() != null && pageParam.getApplicantName() != "") {
      criteria2.andLike("patryApplyName", "%" + pageParam.getApplicantName() + "%");
    }
    List<PatryApply> patryApplyLists = patryApplyMapper.selectByExample(example);
    example.and(criteria2);
    List<PatryApply> patryApplyList =
        patryApplyMapper.selectByExampleAndRowBounds(
            example,
            new RowBounds((pageParam.getPage() - 1) * pageParam.getLimit(), pageParam.getLimit()));
    PageInfo<PatryApply> pageInfo = new PageInfo<PatryApply>(patryApplyList);
    pageInfo.setTotal(patryApplyLists.size());
    return pageInfo;
  }

  /**
   * 根据申请订单的单号查找详细申请信息
   *
   * @param patryApplyId
   * @return
   */
  @Override
  public PatryApply findByApplyId(String patryApplyId) {
    return patryApplyMapper.selectByPrimaryKey(patryApplyId);
  }

  /**
   * 根据 身份，审批状态，申请主题查询，
   *
   * @param identity
   * @param status
   * @param theme
   * @return List<PatryApply>
   */
  @Override
  public List<PatryApply> findByIdentityAndStatusAndTheme(
      String identity, String status, String theme) {
    Example example = new Example(PatryApply.class); // 实例化
    Example.Criteria criteria = example.createCriteria();
    //    党支部
    example.orderBy("patryApplyId").desc();
    criteria
        .andEqualTo("patryApplyPatryidentity", identity)
        .andEqualTo("patryApplyStatus", status)
        .andEqualTo("patryApplyTheme", theme);
    List<PatryApply> patryApplyList = patryApplyMapper.selectByExample(example);
    return patryApplyList;
  }

  /**
   * 根据 使用者账号（学号，教职工号）身份，审批状态，申请主题查询，
   *
   * @param patryApplyUsername
   * @param identity
   * @param status
   * @param theme
   * @return
   */
  @Override
  public PatryApply findByUsernameAndIdentify(
      String patryApplyUsername, String identity, String status, String theme) {
    Example example = new Example(PatryApply.class); // 实例化
    Example.Criteria criteria = example.createCriteria();
    criteria
        .andEqualTo("patryApplyUsername", patryApplyUsername)
        .andEqualTo("patryApplyPatryidentity", identity)
        .andEqualTo("patryApplyStatus", status)
        .andEqualTo("patryApplyTheme", theme);
    List<PatryApply> patryApplyList = patryApplyMapper.selectByExample(example);
    if (patryApplyList.size() == 0) {
      return null;
    } else {
      return patryApplyList.get(0);
    }
  }

  /**
   * 身份是"非群众"， 主题是党组织关系转接申请，且申请通过
   *
   * @return
   */
  @Override
  public List<PatryApply> findMoveUnit() {
    Example example = new Example(PatryApply.class); // 实例化
    Example.Criteria criteria = example.createCriteria();
    //    党支部
    example.orderBy("patryApplyId").desc();
    criteria
        .andNotEqualTo("patryApplyPatryidentity", "群众")
        .andEqualTo("patryApplyStatus", "审核通过")
        .andEqualTo("patryApplyTheme", "党组织关系转接申请");
    List<PatryApply> patryApplyList = patryApplyMapper.selectByExample(example);
    return patryApplyList;
  }

  @Override
  public PatryApply findMoveUnitByUsername(String patryApplyUsername) {
    Example example = new Example(PatryApply.class); // 实例化
    Example.Criteria criteria = example.createCriteria();
    //    党支部
    example.orderBy("patryApplyId").desc();
    criteria
        .andEqualTo("patryApplyUsername", patryApplyUsername)
        .andEqualTo("patryApplyStatus", "审核通过")
        .andEqualTo("patryApplyTheme", "党组织关系转接申请")
        .andNotEqualTo("patryApplyPatryidentity", "群众");
    List<PatryApply> patryApplyList = patryApplyMapper.selectByExample(example);
    if (patryApplyList.size() == 0) {
      return null;
    } else {
      return patryApplyList.get(0);
    }
  }

  /**
   * 表：apply 查找：申请成为积极分子，申请成为预备党员 根据人名：模糊查找，分页查找
   *
   * @param pageParam
   * @return
   */
  @Override
  public PageInfo<PatryApply> personEntryWatch(PageParam pageParam) {
    Example example = new Example(PatryApply.class);
    Example.Criteria criteria1 = example.createCriteria();
    Example.Criteria criteria2 = example.createCriteria();
    //    党支部
    if (pageParam.getSort().equals("+id")) {
      example.orderBy("patryApplyId").asc();
    } else {
      example.orderBy("patryApplyId").desc();
    }
    if (pageParam.getTitle() != "") {
      criteria1.andEqualTo("patryApplyTheme", pageParam.getTitle());
    }

    criteria1.andEqualTo("patryApplyStatus", "审核通过");
    if (pageParam.getApplicantName() != null && pageParam.getApplicantName() != "") {
      criteria2.andLike("patryApplyName", "%" + pageParam.getApplicantName() + "%");
    }
    List<PatryApply> patryApplyLists = patryApplyMapper.selectByExample(example);
    example.and(criteria2);
    List<PatryApply> patryApplyList =
        patryApplyMapper.selectByExampleAndRowBounds(
            example,
            new RowBounds((pageParam.getPage() - 1) * pageParam.getLimit(), pageParam.getLimit()));
    PageInfo<PatryApply> pageInfo = new PageInfo<PatryApply>(patryApplyList);
    pageInfo.setTotal(patryApplyLists.size());
    return pageInfo;
  }
}
