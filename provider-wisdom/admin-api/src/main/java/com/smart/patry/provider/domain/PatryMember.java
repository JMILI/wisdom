package com.smart.patry.provider.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
    *@Description: 
    *@Author: JIMILI,
    *@Data: 2020/5/23,17:19
    *@Version: 
    *@Package: com.smart.patry.provider.domain
    *注解解释：
    *
    */

/**
 * 党员表
 */
@Data
@Table(name = "patry_member")
public class PatryMember implements Serializable {
    /**
     * 党员党号
     */
    @Id
    @Column(name = "patry_member_id")
    @GeneratedValue(generator = "JDBC")
    private Long patryMemberId;

    /**
     * 党员姓名
     */
    @Column(name = "ptray_member_name")
    private String ptrayMemberName;

    /**
     * 性别
     */
    @Column(name = "ptray_member_sex")
    private String ptrayMemberSex;

    /**
     * 党员身份：积极分子，预备党员
     */
    @Column(name = "ptray_member_identity")
    private String ptrayMemberIdentity;

    /**
     * 年+第几期：（每一个季度一期，取每个季度的首月为第几期，例如201801）
     */
    @Column(name = "ptray_member_period")
    private String ptrayMemberPeriod;

    /**
     * 工作或学习单位
     */
    @Column(name = "ptray_member_workUnit")
    private String ptrayMemberWorkunit;

    /**
     * 原来的工作学习单位
     */
    @Column(name = "ptray_member_oldPatryUnit")
    private String ptrayMemberOldpatryunit;

    /**
     * 现在的工作学习单位
     */
    @Column(name = "ptray_member_nowPatryUnit")
    private String ptrayMemberNowpatryunit;

    /**
     * 党员联系方式，电话
     */
    @Column(name = "ptray_member_call")
    private String ptrayMemberCall;

    /**
     * 学工号，教职工号
     */
    @Column(name = "patry_member_username")
    private String patryMemberUsername;

    /**
     * 邮箱
     */
    @Column(name = "patry_member_email")
    private String patryMemberEmail;

    private static final long serialVersionUID = 4525846065522805333L;
}