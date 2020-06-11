package com.smart.patry.business.dto.end2front;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Author: JIMILI, @Data: 2020/5/8,17:00 @Version: @Package: com.smart.patry.business.dto.end2front
 * 注解解释：
 */
@Data
public class StudentProfile implements Serializable {
  private static final long serialVersionUID = 7774491859439482052L;

  /** 学生学号 */
  private String username;

  /** 学生姓名 */
  private String studentName;

  /** 性别 */
  private String studentSex;

  /** 籍贯 */
  private String studentHometown;

  /** 学历 */
  private String studentEducation;

  /** 家庭住址 */
  private String studentHomeaddress;

  /** 学习单位 */
  private String studentUnit;

  /** 党员党号 */
  private Long patryMemberId;

  /** 党员身份：积极分子，预备党员 */
  private String ptrayMemberIdentity;

  /** 年+第几期：（每一个季度一期，取每个季度的首月为第几期，例如201801） */
  private String ptrayMemberPeriod;

  /** 原来的党组织单位 */
  private String ptrayMemberOldpatryunit;

  /** 现在的工作学习单位 */
  private String ptrayMemberNowpatryunit;

  /** 党员联系方式，电话 */
  private String ptrayMemberCall;

  /**
   * 党员邮箱
   */
  private String patryMemberEmail;
}
