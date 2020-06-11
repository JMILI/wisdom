package com.smart.patry.business.dto.apply;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/10,2:09 @Version: @Package:
 * com.smart.patry.business.dto.end2front 注解解释：
 */
@Data
public class ApplyOverButNoEntryPeople implements Serializable {

  private String patryApplyId;
  /** 学工号，注意这包含学生和教师.学生表的username */
  private String patryApplyUsername;

  /** 申请人姓名 */
  private String patryApplyName;

  /** 申请主题：积极分子申请，预备党员申请，组织转接申请 */
  private String patryApplyTheme;

  /** 申请理由 */
  private String patryApplyApplyreason;

  /** 工作或学习单位 */
  private String patryApplyWorkunit;

  /** 党内身份：群众/积极分子 */
  private String patryApplyPatryidentity;

  /** 联系电话 */
  private String patryApplyCall;

  /** 所在党部门 */
  private String patryApplyPatryunit;

  /** 申请时间 */
  private Date patryApplyApplytime;

  private static final long serialVersionUID = 6923182760386478443L;
}
