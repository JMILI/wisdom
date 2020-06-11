package com.smart.patry.business.dto.activity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/5/10,4:26
 *@Version:
 *@Package: com.smart.patry.business.dto.activity
 *注解解释：
 *
 */
@Data
public class ActivityDetailInfo implements Serializable {

    /**
     * 预计参加人数，默认为空
     */
    @Column(name = "patry_activity_peopleNumber")
    private String patryActivityPeoplenumber;

    /**
     * 预算，默认为空
     */
    @Column(name = "patry_activity_budget")
    private Double patryActivityBudget;

    /**
     * 实际花销
     */
    @Column(name = "patry_activity_cost")
    private Double patryActivityCost;

    /**
     * 活动时间：这里的时间是描述性文字
     */
    @Column(name = "patry_activity_activityTime")
    private String patryActivityActivitytime;

    /**
     * 活动地理范围
     */
    @Column(name = "patry_activity_loaction")
    private String patryActivityLoaction;

    /**
     * 活动步骤
     */
    @Column(name = "patry_activity_activitySteps")
    private String patryActivityActivitysteps;


    /**
     * 申请理由
     */
    @Column(name = "patry_activity_applyReason")
    private String patryActivityApplyreason;

    /**
     * 负责人
     */
    @Column(name = "patry_activity_principal")
    private String patryActivityPrincipal;

    /**
     * 负责人电话
     */
    @Column(name = "patry_activity_principalCall")
    private String patryActivityPrincipalcall;

    /**
     * 附件
     */
    @Column(name = "patry_activity_annex")
    private String patryActivityAnnex;



    private static final long serialVersionUID = 3394200074810851633L;
}
