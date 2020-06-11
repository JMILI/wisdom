package com.smart.patry.provider.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.patry.provider.domain.PatryApply;
import com.smart.patry.provider.mapper.PatryApplyMapper;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * PatryApplyServiceImpl Tester.
 *
 * @author <JIMILI>
 * @since
 *     <pre>5�� 9, 2020</pre>
 *
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class PatryApplyServiceImplTest {
  @Resource private PatryApplyMapper patryApplyMapper;

  @Test
  public void testInsert() throws Exception {
    for (int i = 10; i < 40; i++) {
      PatryApply patryApply = new PatryApply();
      patryApply.setPatryApplyUsername("1000"+String.valueOf(i));
      patryApply.setPatryApplyName("支建" + String.valueOf(i));
      patryApply.setPatryApplyWorkunit("西安安建筑科技大学");
      patryApply.setPatryApplyPatryidentity("积极分子");
      patryApply.setPatryApplyCall("18109210242");
      patryApply.setPatryApplyTheme("党组织关系转接申请");
      patryApply.setPatryApplyPatryunit("建科学院建筑学支部");
      patryApply.setPatryApplyApplyreason("由于本人转学需要，党组织转接,转接到：建科学院建筑学党总支");
      patryApply.setPatryApplyApplyannex("");
      patryApply.setPatryApplyIdentity("学生");
      testInitApplyTable(patryApply);

      patryApplyMapper.insert(patryApply);
      Thread.sleep(1000);
    }
  }

  /** Method: initApplyTable(PatryApply patryApply) */
  public void testInitApplyTable(PatryApply patryApply) {
    // 申请订单id
    // 转换提日期输出格式
    Format format = new SimpleDateFormat("yyyyMMddHHmmss");
    patryApply.setPatryApplyId(format.format(new Date()));
    //    申请时间
    patryApply.setPatryApplyApplytime(new Date());
    patryApply.setPatryApplyPatryperiod("20121");
    //    党支部默认意见
    patryApply.setPatryApplyBranchopinion("同意");
    patryApply.setPatryApplyBranchhandler("");
    //    党总支默认意见
    patryApply.setPatryApplyHeadopinon("同意");
    patryApply.setPatryApplyHeadhandler("");
    //    人事处默认意见
    patryApply.setPatryApplyPersonopinon("同意");
    patryApply.setPatryApplyPersonhandler("");
    patryApply.setPatryApplyOtheropinion("");
    patryApply.setPatryApplyDenialreason("");
    //    申请订单状态
    patryApply.setPatryApplyStatus("审核通过");
  }

  /** Method: update(PatryApply patryApply) */
  @Test
  public void testUpdate() throws Exception {
    // TODO: Test goes here...
  }

  /** Method: delete(String applyId) */
  @Test
  public void testDelete() throws Exception {
    // TODO: Test goes here...
  }

  /** Method: findByUsernameAndStatus(String username, String Status) */
  @Test
  public void testFindByUsernameAndStatus() throws Exception {
    Example example = new Example(PatryApply.class); // 实例化
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("patryApplyUsername", "100001");
    //    criteria.andEqualTo("patryApplyStatus", "审核中");
    List<PatryApply> patryApplyList = patryApplyMapper.selectByExample(example);
  }

  /** Method: branchWatch() */
  @Test
  public void testBranchWatch() throws Exception {
    Example example = new Example(PatryApply.class); // 实例化
    Example.Criteria criteria = example.createCriteria();

    criteria
        .andEqualTo("patryApplyBranchopinion", "待审核")
        .andEqualTo("patryApplyStatus", "审核中")
        .andEqualTo("patryApplyPatryunit", "建科学院建筑学支部");
    List<PatryApply> patryApplyList5 =
            patryApplyMapper.selectByExample(example);

    RowBounds rowBounds = new RowBounds(0, 10);
   List<PatryApply> patryApplyList1 =
        patryApplyMapper.selectByExampleAndRowBounds(example, rowBounds);

    RowBounds rowBounds2 = new RowBounds(0, 10);
    List<PatryApply> patryApplyList2=
            patryApplyMapper.selectByExampleAndRowBounds(example, rowBounds2);
  }

  /** Method: headWatch() */
  @Test
  public void testHeadWatch() throws Exception {
    Example example = new Example(PatryApply.class); // 实例化
    Example.Criteria criteria = example.createCriteria();
    List<String> list = new ArrayList<String>();
    list.add("建科学院数学专业党支部");
    list.add("建科学院建筑学支部");
    list.add("建科学院建材料支部");
    list.add("建科学院园林党支部");
    criteria
            .andEqualTo("patryApplyBranchopinion", "同意")
            .andEqualTo("patryApplyHeadopinon", "待审核")
            .andEqualTo("patryApplyStatus", "审核中");
    for (String item : list) {
      criteria.orEqualTo("patryApplyPatryunit",item);
    }

    List<PatryApply> patryApplyLists = patryApplyMapper.selectByExample(example);

    List<PatryApply> patryApplyList =
            patryApplyMapper.selectByExampleAndRowBounds(
                    example,
                    new RowBounds(0,10));

    PageInfo<PatryApply> pageInfo = new PageInfo<PatryApply>(patryApplyList);
    pageInfo.setTotal(patryApplyLists.size());
  }

  /** Method: personWatch() */
  @Test
  public void testPersonWatch() throws Exception {
    Example example = new Example(PatryApply.class); // 实例化
    Example.Criteria criteria = example.createCriteria();
    //    党支部
    String sort = "+id";
    String theme = "";
    if (sort.equals("-id")) {
      example.orderBy("patryApplyId").asc();
    } else {
      example.orderBy("patryApplyId").desc();
    }
    if (theme != "") {
      criteria.andEqualTo("patryApplyTheme", theme);
    }
    criteria
        .andEqualTo("patryApplyBranchopinion", "同意")
        .andEqualTo("patryApplyHeadopinon", "同意")
        .andEqualTo("patryApplyPersonopinon", "待审核")
        .andEqualTo("patryApplyStatus", "审核中");
    PageHelper.startPage(1, 5);
    List<PatryApply> patryApplyList = patryApplyMapper.selectByExample(example);
    PageInfo pageInfo = new PageInfo(patryApplyList);
    //    return pageInfo;
  }

  @Test
  public void testFindByIdentityAndStatusAndTheme() {
    Example example = new Example(PatryApply.class); // 实例化
    Example.Criteria criteria = example.createCriteria();
    String identity = "群众";
    String status = "审核通过";
    String theme = "申请成为积极分子";
    //    党支部
    example.orderBy("patryApplyId").desc();
    criteria
        .andEqualTo("patryApplyPatryidentity", identity)
        .andEqualTo("patryApplyStatus", status)
        .andEqualTo("patryApplyTheme", theme);
    List<PatryApply> patryApplyList = patryApplyMapper.selectByExample(example);
  }

  @Test
  public void findMoveUnitByUsername() {
    Example example = new Example(PatryApply.class); // 实例化
    Example.Criteria criteria = example.createCriteria();
    //    党支部
    example.orderBy("patryApplyId").desc();
    criteria
        .andEqualTo("patryApplyUsername", "100001")
        .andEqualTo("patryApplyStatus", "审核通过")
        .andEqualTo("patryApplyTheme", "党组织关系转接申请")
        .andNotEqualTo("patryApplyPatryidentity", "群众");
    //    PatryApply patryApply= patryApplyMapper.selectOneByExample(example);
    List<PatryApply> patryApplyList = patryApplyMapper.selectByExample(example);

    if (patryApplyList.size() == 0) {
      //      return null;
      System.out.println("fa");
    } else {
      PatryApply patryApply = patryApplyList.get(0);
      //      return patryApply;
      System.out.println("ok");
    }
  }

  @Test
  public void personWatch() {
    PageHelper.startPage(1, 2);

    Example example = new Example(PatryApply.class); // 实例化
    //    Example.Criteria criteria = example.createCriteria();
    //    党支部

    //    example.orderBy("patryApplyId").desc();
    example
        .createCriteria()
        .andEqualTo("patryApplyBranchopinion", "同意")
        .andEqualTo("patryApplyHeadopinon", "同意")
        .andEqualTo("patryApplyPersonopinon", "待审核")
        .andEqualTo("patryApplyStatus", "审核中");

    //    List<PatryApply> patryApplyList = patryApplyMapper.selectByExampleAndRowBounds(example,new
    // RowBounds(1,2));
    List<PatryApply> patryApplyList = patryApplyMapper.selectByExample(example);
    PageInfo<PatryApply> userPageInfo = new PageInfo<>(patryApplyList);
    //    PageInfo pageInfo = new PageInfo<>(patryApplyList);
  }
}
