package com.smart.patry.front.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/10,2:09 @Version: @Package:
 * com.smart.patry.business.dto.end2front 注解解释：
 */
@Data
public class PageParamByUsername implements Serializable {
  private String username;
  /** 党内申请的id，类似于订单号 */
  private int page;

  /** 申请人姓名 */
  private int limit;
  /**
   * 主题
   */
  private String title;
  /**
   * 排序
   */
  private String sort;
  /**
   * 党组织单位
   */
  private String unit;

  private static final long serialVersionUID = -3915312955371042841L;
}
