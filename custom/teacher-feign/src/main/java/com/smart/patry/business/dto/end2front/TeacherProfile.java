package com.smart.patry.business.dto.end2front;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/8,20:55 @Version: @Package:
 * com.smart.patry.business.dto.end2front 注解解释：
 */
@Data
public class TeacherProfile implements Serializable {
  private static final long serialVersionUID = -3814657196254637988L;
  /** 教职工号 */
  private String username;

  /** 教师姓名 */
  private String teacherName;

  /** 性别 */
  private String teacherSex;

  /** 籍贯 */
  private String teacherHometown;

  /** 学历 */
  private String teacherEducation;

  /** 家庭住址 */
  private String teacherHomeaddress;

  /** 工作或学习单位 */
  private String teacherUnit;

  /** 登录身份，表中可以没有 */
  private String loginidentity;

  /** 邮箱 */
  private String teacherEmail;

  /** 联系方式 */
  private String teacherPhone;


}
