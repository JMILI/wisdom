package com.smart.patry.provider.service;


import com.smart.patry.provider.domain.UnitRelation;
import com.smart.patry.provider.mapper.UnitRelationMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/26,16:04
 * @Version:
 * @Package: com.smart.patry.provider.service
 * 注解解释：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class UnitRelationServiceImplTest {

    @Resource
    private UnitRelationMapper unitRelationMapper;
  @Test
  public void getUnitBySuperUnit() {
      Example example = new Example(UnitRelation.class);
      example.createCriteria().andEqualTo("unitSuperDepartmentName", "建筑学院党总支");
      List<UnitRelation> relationList = unitRelationMapper.selectByExample(example);
      List<String> stringList = new ArrayList<String>();
      for (UnitRelation item : relationList) {
          stringList.add(item.getUnitName());
      }
  }
}
