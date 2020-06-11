package com.smart.patry.business.dto.end2front;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/8,21:17 @Version: @Package:
 * com.smart.patry.business.dto.front2end 注解解释：
 */
@Data
public class StudentApplyInfo implements Serializable {
  private static final long serialVersionUID = -2061431659017716105L;
  /** 学工号，注意这包含学生和教师 */
  private String patryApplyUsername;

  /** 申请人姓名 */
  private String patryApplyName;

  /** 工作或学习单位 */
  private String patryApplyWorkunit;

  /** 描述申请人身份：教师，学生 */
  private String patryApplyIdentity;

  /** 党内身份：群众/积极分子 */
  private String patryApplyPatryidentity;

  /** 联系电话 */
  private String patryApplyCall;

//  /** 申请主题：积极分子申请，预备党员申请，组织转接申请 */
//  private String patryApplyTheme;

  /** 所在党部门 */
  private String patryApplyPatryunit;

  /** 申请理由 */
  private String patryApplyApplyreason;

  /** 申请附件 */
  private String patryApplyApplyannex;
}
