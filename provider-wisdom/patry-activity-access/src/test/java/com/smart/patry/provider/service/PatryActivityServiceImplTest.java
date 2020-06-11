package com.smart.patry.provider.service;

import com.github.pagehelper.PageInfo;
import com.smart.patry.provider.domain.PatryActivity;
import com.smart.patry.provider.mapper.PatryActivityMapper;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * PatryActivityServiceImpl Tester.
 *
 * @author <JIMILI>
 * @since
 *     <pre>5�� 11, 2020</pre>
 *
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class PatryActivityServiceImplTest {

  @Resource private PatryActivityMapper patryActivityMapper;

  @Test
  public void testInsert() throws Exception {
    for (int i = 0; i < 5; i++) {
      PatryActivity patryActivity = new PatryActivity();
      patryActivity.setPatryActivityTheme("青年大学习之延安红色行");
      patryActivity.setPatryActivityPeoplenumber("参与人员：党支部各书记，信控学院团员86人");
      patryActivity.setPatryActivityBudget(2610.0);
      patryActivity.setPatryActivityCost(3000.0);
      patryActivity.setPatryActivityActivitytime("2020年8月2日到8月10日");
      patryActivity.setPatryActivityLoaction("延安");
      patryActivity.setPatryActivityActivitysteps("1.出发，2.出发，3.参观.4.写观后感");
      patryActivity.setPatryActivityPatryunit("信控学院团总支下属党支部");
      patryActivity.setPatryActivityApplyreason("增强同学们的红色精神，学习历史，勿忘国耻");
      patryActivity.setPatryActivityPrincipal("小猪佩奇");
      patryActivity.setPatryActivityPrincipalcall("18546987721");
      patryActivity.setPatryActivityAnnex("");

      initApplyTable(patryActivity);
      //    return patryActivityMapper.insertSelective(patryActivity);
      patryActivityMapper.insertSelective(patryActivity);
      Thread.sleep(2000);
    }
  }

  private void initApplyTable(PatryActivity patryActivity) {
    Format format = new SimpleDateFormat("yyyyMMddHHmmss");

    patryActivity.setPatryActivityId(format.format(new Date()));
    patryActivity.setPatryActivityApplytime(new Date());

    patryActivity.setPatryActivityHeadopinion("待审核");
    patryActivity.setPatryActivityHeadhandler("");
    patryActivity.setPatryActivityPersonopinion("待审核");
    patryActivity.setPatryActivityPersonhandler("");
    patryActivity.setPatryActivityDenialreason("");
    patryActivity.setPatryActivityStatus("审核中");
  }

  @Test
  public void testUpdate() throws Exception {
    // TODO: Test goes here...
  }

  @Test
  public void testPersonWatch() throws Exception {
    // TODO: Test goes here...
  }

  @Test
  public void testFindById() throws Exception {
    // TODO: Test goes here...
  }

  @Test
  public void testInitApplyTable() throws Exception {
    // TODO: Test goes here...
    /*
    try {
       Method method = PatryActivityServiceImpl.getClass().getMethod("initApplyTable", PatryActivity.class);
       method.setAccessible(true);
       method.invoke(<Object>, <Parameters>);
    } catch(NoSuchMethodException e) {
    } catch(IllegalAccessException e) {
    } catch(InvocationTargetException e) {
    }
    */
  }

  @Test
  public void headWatch() {
    Example example = new Example(PatryActivity.class); // 实例化
    Example.Criteria criteria1 = example.createCriteria();
    Example.Criteria criteria2 = example.createCriteria();
    Example.Criteria criteria3 = example.createCriteria();
    //    党支部
    //    if (pageParamByUsername.getSort().equals("+id")) {
    //      example.orderBy("patryActivityId").asc();
    //    } else {
    //      example.orderBy("patryActivityId").desc();
    //    }
    List<String> list = new ArrayList<String>();
    list.add("建科学院数学专业党支部");
    list.add("建科学院建筑学支部");
    list.add("建科学院建材料支部");
    list.add("建科学院园林党支部");
    //    if (pageParamByUsername.getTitle() != "") {
    //      criteria.andLike("patryActivityTheme", "%" +"团" + "%");
    //    }
    for (String item : list) {
      criteria1.orEqualTo("patryActivityPatryunit", item);
    }
    criteria2
        .andEqualTo("patryActivityHeadopinion", "待审核")
        .andEqualTo("patryActivityStatus", "审核中")
        .andLike("patryActivityTheme", "%" + "团" + "%");
    example.and(criteria2);

    List<PatryActivity> patryActivityLists = patryActivityMapper.selectByExample(example);

    List<PatryActivity> patryActivityList =
        patryActivityMapper.selectByExampleAndRowBounds(example, new RowBounds(0, 10));
    PageInfo<PatryActivity> pageInfo = new PageInfo<PatryActivity>(patryActivityList);
    pageInfo.setTotal(patryActivityLists.size());
  }
}
