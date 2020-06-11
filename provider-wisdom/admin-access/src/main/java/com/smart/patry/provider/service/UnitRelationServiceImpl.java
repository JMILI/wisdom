package com.smart.patry.provider.service;

import com.smart.patry.provider.domain.PatryAdmin;
import com.smart.patry.provider.domain.UnitRelation;

import javax.annotation.Resource;
import com.smart.patry.provider.mapper.UnitRelationMapper;
import com.smart.patry.provider.api.UnitRelationService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/23,17:03 @Version: @Package:
 * com.smart.patry.provider.service 注解解释：
 */
@Service(version = "1.0.0")
public class UnitRelationServiceImpl implements UnitRelationService {

  @Resource private UnitRelationMapper unitRelationMapper;

  /**
   * 获取所有部门名称
   *
   * @return
   */
  @Override
  public List<String> acquireUnitData() {
    List<UnitRelation> unitRelations = unitRelationMapper.selectAll();
    List<String> stringList = new ArrayList<String>();
    if (unitRelations.size() == 0) {
      return null;
    } else {
      for (UnitRelation item : unitRelations) {
        stringList.add(item.getUnitName());
      }
      return stringList;
    }
  }

  /**
   * 根据上级部门查找其管理的下级部门
   *
   * @param unit
   * @return
   */
  @Override
  public List<String> getUnitBySuperUnit(String unit) {
    Example example = new Example(UnitRelation.class);
    example.createCriteria().andEqualTo("unitSuperDepartmentName", unit);
    List<UnitRelation> relationList = unitRelationMapper.selectByExample(example);
    List<String> stringList = new ArrayList<String>();
    if (relationList.size() > 0) {
      for (UnitRelation item : relationList) {
        stringList.add(item.getUnitName());
      }
      return stringList;
    } else {
      return null;
    }
  }
}
