package com.smart.patry.business.dto.apply;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/10,4:04 @Version: @Package:
 * com.smart.patry.business.dto.front2end 注解解释：
 */
@Data
public class MoveUnitParam implements Serializable {

  private static final long serialVersionUID = 8952056461876950378L;
  /** 申请的id，类似于订单号 */
  private String patryApplyId;
  /** 学工号，注意这包含学生和教师.学生表的username */
  private String patryApplyUsername;

  /** 所在党部门 */
  private String patryApplyPatryunit;

  /** 目标单位 */
  private String targetUnit;
}
