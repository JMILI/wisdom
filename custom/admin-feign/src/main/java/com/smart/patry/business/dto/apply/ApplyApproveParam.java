package com.smart.patry.business.dto.apply;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/10,2:10 @Version: @Package:
 * com.smart.patry.business.dto.front2end 注解解释：
 */
@Data
public class ApplyApproveParam implements Serializable {

    /** 党内申请的id，类似于订单号 */
    private String patryApplyId;

    /** 申请人姓名 */
    private String patryApplyName;

    /** 申请主题：积极分子申请，预备党员申请，组织转接申请 */
    private String patryApplyTheme;

    /** 人事处意见 */
    private String patryApplyPersonopinon;

    /** 人事处审批人 */
    private String patryApplyPersonhandler;

    /** 其他部门意见 */
    private String patryApplyOtheropinion;

    /** 驳回理由 */
    private String patryApplyDenialreason;

  private static final long serialVersionUID = -2395977589026426593L;
}
