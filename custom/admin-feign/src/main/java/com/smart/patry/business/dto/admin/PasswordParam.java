package com.smart.patry.business.dto.admin;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/5,19:01 @Version: @Package:
 * com.smart.patry.business.dto 注解解释：
 */
@Data
public class PasswordParam implements Serializable {
  private static final long serialVersionUID = 4881721060044637861L;

  String username;
  String oldPatryAdminPassword;
  String newPatryAdminPassword;
}
