package com.smart.patry.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
    *@Description: 
    *@Author: JIMILI,
    *@Data: 2020/5/25,0:54
    *@Version: 
    *@Package: com.smart.patry.provider.domain
    *注解解释：
    *
    */

/**
 * 活动申请表
 * 党支部申请，
 * 上级组织审批
 */
@Data
@Table(name = "patry_activity")
public class PatryActivity implements Serializable {
    /**
     * 活动id：年月日时分+4位随机数
     * 1秒中最多生成999个订单
     */
    @Id
    @Column(name = "patry_activity_id")
    private String patryActivityId;

    /**
     * 活动主题
     */
    @Column(name = "patry_activity_theme")
    private String patryActivityTheme;

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
     * 申请单位：党支部
     */
    @Column(name = "patry_activity_patryUnit")
    private String patryActivityPatryunit;

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

    /**
     * 申请时间，系统生成
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "patry_activity_applyTime")
    private Date patryActivityApplytime;

    /**
     * 党总支意见
     */
    @Column(name = "patry_activity_headOpinion")
    private String patryActivityHeadopinion;

    /**
     * 党总支审批人
     */
    @Column(name = "patry_activity_headHandler")
    private String patryActivityHeadhandler;

    /**
     * 人事处意见
     */
    @Column(name = "patry_activity_personOpinion")
    private String patryActivityPersonopinion;

    /**
     * 人事处审批人
     */
    @Column(name = "patry_activity_personHandler")
    private String patryActivityPersonhandler;

    /**
     * 驳回理由
     */
    @Column(name = "patry_activity_denialReason")
    private String patryActivityDenialreason;

    /**
     * 状态：审核中/审核通过
     */
    @Column(name = "patry_activity_status")
    private String patryActivityStatus;

    /**
     * 活动详情，实际活动的具体体现。如照片等
     */
    @Column(name = "patry_activity_show")
    private String patryActivityShow;

    private static final long serialVersionUID = 6744974772014243575L;
}