package com.smart.patry.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
    *@Description: 
    *@Author: JIMILI,
    *@Data: 2020/5/24,22:26
    *@Version: 
    *@Package: com.smart.patry.provider.domain
    *注解解释：
    *
    */

/**
 * 学生教师：党内申请表。包含：申请成为积极分子，
 * 申请成为预备党员，党内组织关系转接
 */
@Data
@Table(name = "patry_apply")
public class PatryApply implements Serializable {
    /**
     * 党内申请的id，类似于订单号
     */
    @Id
    @Column(name = "patry_apply_id")
    private String patryApplyId;

    /**
     * 学工号，注意这包含学生和教师.学生表的username
     */
    @Column(name = "patry_apply_username")
    private String patryApplyUsername;

    /**
     * 申请人姓名
     */
    @Column(name = "patry_apply_name")
    private String patryApplyName;

    /**
     * 工作或学习单位
     */
    @Column(name = "patry_apply_workUnit")
    private String patryApplyWorkunit;

    /**
     * 党内身份：群众/积极分子
     */
    @Column(name = "patry_apply_patryIdentity")
    private String patryApplyPatryidentity;

    /**
     * 联系电话
     */
    @Column(name = "patry_apply_call")
    private String patryApplyCall;

    /**
     * 申请主题：积极分子申请，预备党员申请，组织转接申请
     */
    @Column(name = "patry_apply_theme")
    private String patryApplyTheme;

    /**
     * 所在党部门
     */
    @Column(name = "patry_apply_patryUnit")
    private String patryApplyPatryunit;

    /**
     * 申请理由
     */
    @Column(name = "patry_apply_applyReason")
    private String patryApplyApplyreason;

    /**
     * 申请附件
     */
    @Column(name = "patry_apply_applyAnnex")
    private String patryApplyApplyannex;

    /**
     * 申请时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "patry_apply_applyTime")
    private Date patryApplyApplytime;

    /**
     * 党期：
     */
    @Column(name = "patry_apply_patryPeriod")
    private String patryApplyPatryperiod;

    /**
     * 党支部意见
     */
    @Column(name = "patry_apply_branchOpinion")
    private String patryApplyBranchopinion;

    /**
     * 党支部审批人
     */
    @Column(name = "patry_apply_branchHandler")
    private String patryApplyBranchhandler;

    /**
     * 党总支意见
     */
    @Column(name = "patry_apply_headOpinon")
    private String patryApplyHeadopinon;

    /**
     * 党总支审批人
     */
    @Column(name = "patry_apply_headHandler")
    private String patryApplyHeadhandler;

    /**
     * 人事处意见
     */
    @Column(name = "patry_apply_personOpinon")
    private String patryApplyPersonopinon;

    /**
     * 人事处审批人
     */
    @Column(name = "patry_apply_personHandler")
    private String patryApplyPersonhandler;

    /**
     * 其他部门意见
     */
    @Column(name = "patry_apply_otherOpinion")
    private String patryApplyOtheropinion;

    /**
     * 驳回理由
     */
    @Column(name = "patry_apply_denialReason")
    private String patryApplyDenialreason;

    /**
     * 值：审核中，审核通过，驳回
     */
    @Column(name = "patry_apply_status")
    private String patryApplyStatus;

    /**
     * 描述申请人身份：教师，学生
     */
    @Column(name = "patry_apply_identity")
    private String patryApplyIdentity;

    private static final long serialVersionUID = -9171600193249792803L;
}