package com.smart.patry.business.feign.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/26,13:25 @Version: @Package:
 * com.smart.patry.business.feign.dto 注解解释：
 */
@Data
public class RegistActivityInfo implements Serializable {
private String actRegistActivityid;
  private String actRegistTheme;
  private String actRegistUnit ;
  private String actRegistUsername ;

  private static final long serialVersionUID = -112497594899509222L;
}
