package com.smart.patry.business.feign.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/26,13:25 @Version: @Package:
 * com.smart.patry.business.feign.dto 注解解释：
 */
@Data
public class NewsList implements Serializable {
  /**
   * 活动id
   */
  private String activityId;
  /** 标题 */
  private String title;
  /** 具体内容 */
  private String content;
  /** 时间 */
  private Date time;
  /** 外链 */
  private String href;
  /** 是否是可以报名的活动 */
  private String isActivity;

  private static final long serialVersionUID = 685456918522067636L;
}
