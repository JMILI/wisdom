package com.smart.patry.business.dto.end2front;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 存储用户登录之后的信息 @Author: JIMILI, @Data: 2020/4/28,19:58 @Version: @Package:
 * com.smart.patry.business.controller 注解解释：
 */
@Data
public class LoginInfo implements Serializable {
  private static final long serialVersionUID = -5581321315903492253L;
  /** 姓名 */
  private String name;

  /** 账号 */
  private String username;

  //    private String patryAdminUnit;
  /** 登录身份 */
  private String loginIdentity;
  /**
   * 所在党部门
   */
  private String loginUnit;
}
