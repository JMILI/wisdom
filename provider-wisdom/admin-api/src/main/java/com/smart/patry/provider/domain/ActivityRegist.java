package com.smart.patry.provider.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
    *@Description: 
    *@Author: JIMILI,
    *@Data: 2020/5/29,2:52
    *@Version: 
    *@Package: com.smart.patry.provider.domain
    *注解解释：
    *
    */

/**
 * 活动报名表
 */
@Data
@Table(name = "activity_regist")
public class ActivityRegist implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name = "act_regist_id")
    private String actRegistId;

    /**
     * 所要报名的活动id
     */
    @Column(name = "act_regist_activityId")
    private String actRegistActivityid;

    /**
     * 活动主题
     */
    @Column(name = "act_regist_theme")
    private String actRegistTheme;

    /**
     * 学号
     */
    @Column(name = "act_regist_username")
    private String actRegistUsername;

    /**
     * 所属党部门。当学生第一次登陆时。可以为空
     */
    @Column(name = "act_regist_unit")
    private String actRegistUnit;

    /**
     * 人名
     */
    @Column(name = "act_regist_name")
    private String actRegistName;

    /**
     * 性别
     */
    @Column(name = "act_regist_sex")
    private String actRegistSex;

    /**
     * 学习或工作单位。学生则为班级
     */
    @Column(name = "act_regist_work_unit")
    private String actRegistWorkUnit;

    /**
     * 电话
     */
    @Column(name = "act_regist_call")
    private String actRegistCall;

    /**
     * 签到
     */
    @Column(name = "act_regist_sign_in")
    private String actRegistSignIn;

    private static final long serialVersionUID = 8251333464123932336L;
}