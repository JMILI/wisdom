package com.smart.patry.provider.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
    *@Description: 
    *@Author: JIMILI,
    *@Data: 2020/5/23,21:18
    *@Version: 
    *@Package: com.smart.patry.provider.domain
    *注解解释：
    *
    */

/**
 * 教务系统教师信息表
 */
@Data
@Table(name = "external_teacher")
public class ExternalTeacher implements Serializable {
    /**
     * 教职工号
     */
    @Id
    @Column(name = "teacher_id")
    private String username;

    /**
     * 教师姓名
     */
    @Column(name = "teacher_name")
    private String teacherName;

    /**
     * 性别
     */
    @Column(name = "teacher_sex")
    private String teacherSex;

    /**
     * 籍贯
     */
    @Column(name = "teacher_hometown")
    private String teacherHometown;

    /**
     * 学历
     */
    @Column(name = "teacher_education")
    private String teacherEducation;

    /**
     * 家庭住址
     */
    @Column(name = "teacher_homeAddress")
    private String teacherHomeaddress;

    /**
     * 工作或学习单位
     */
    @Column(name = "teacher_unit")
    private String teacherUnit;

    /**
     * 邮箱
     */
    @Column(name = "teacher_email")
    private String teacherEmail;

    /**
     * 联系方式
     */
    @Column(name = "teacher_phone")
    private String teacherPhone;

    private static final long serialVersionUID = 1462661681134747336L;
}