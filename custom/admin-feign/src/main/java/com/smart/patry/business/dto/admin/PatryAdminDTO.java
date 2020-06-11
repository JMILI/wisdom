package com.smart.patry.business.dto.admin;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/5,19:51 @Version: @Package:
 * com.smart.patry.business.dto 注解解释：
 */
@Data
public class PatryAdminDTO implements Serializable {
  private static final long serialVersionUID = 1106594120360510206L;
  private String patryAdminName;

  private String username;

  private String patryAdminUnit;

  private String loginidentity;
}
