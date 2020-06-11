package com.smart.patry.provider.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
    *@Description: 
    *@Author: JIMILI,
    *@Data: 2020/5/23,21:06
    *@Version: 
    *@Package: com.smart.patry.provider.domain
    *注解解释：
    *
    */

/**
 * 教务系统学生信息表
 */
@Data
@Table(name = "external_student")
public class ExternalStudent implements Serializable {
    /**
     * 学生学号
     */
    @Id
    @Column(name = "student_id")
    private String username;

    /**
     * 学生姓名
     */
    @Column(name = "student_name")
    private String studentName;

    /**
     * 性别
     */
    @Column(name = "student_sex")
    private String studentSex;

    /**
     * 籍贯
     */
    @Column(name = "student_hometown")
    private String studentHometown;

    /**
     * 学历
     */
    @Column(name = "student_education")
    private String studentEducation;

    /**
     * 家庭住址
     */
    @Column(name = "student_homeAddress")
    private String studentHomeaddress;

    /**
     * 学习单位
     */
    @Column(name = "student_unit")
    private String studentUnit;

    /**
     * 邮箱
     */
    @Column(name = "student_email")
    private String studentEmail;

    /**
     * 电话号码
     */
    @Column(name = "student_phone")
    private String studentPhone;

    private static final long serialVersionUID = 2810014130610099019L;
}