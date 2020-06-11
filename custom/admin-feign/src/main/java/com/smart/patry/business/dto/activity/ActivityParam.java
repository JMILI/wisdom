package com.smart.patry.business.dto.activity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/10,4:20 @Version: @Package:
 * com.smart.patry.business.dto.activity 注解解释：
 */
@Data
public class ActivityParam implements Serializable {
  /**
   * 活动id：年月日时分
   */
  private String patryActivityId;

  /**
   * 活动主题
   */
  private String patryActivityTheme;


  /**
   * 申请单位：党支部
   */
  private String patryActivityPatryunit;







  /**
   * 人事处意见
   */
  private String patryActivityPersonopinion;

  /**
   * 人事处审批人
   */
  private String patryActivityPersonhandler;

  /**
   * 驳回理由
   */
  private String patryActivityDenialreason;


  private static final long serialVersionUID = 7936161640367684877L;
}
