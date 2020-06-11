package com.smart.patry.business.dto.front2end;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: @Author: JIMILI, @Data: 2020/4/28,19:56 @Version: @Package:
 * com.smart.patry.business.dto 注解解释：
 */
@Data
public class LoginParam implements Serializable {
  private static final long serialVersionUID = -5040704354035156663L;
  private String username;
  private String password;
//  private String loginIdentity;
}
