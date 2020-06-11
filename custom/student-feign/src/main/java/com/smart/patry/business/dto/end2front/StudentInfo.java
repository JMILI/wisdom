package com.smart.patry.business.dto.end2front;

import lombok.Data;

import java.io.Serializable;

/**
 *@Author: JIMILI,
 *@Data: 2020/5/8,17:00
 *@Version:
 *@Package: com.smart.patry.business.dto.end2front
 *注解解释：
 *
 */
@Data
public class StudentInfo implements Serializable {
    private static final long serialVersionUID = 5839245054094577701L;
    /**
     * 学生学号
     */
    private String username;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 性别
     */
    private String studentSex;

    /**
     * 籍贯
     */
    private String studentHometown;

    /**
     * 学历
     */
    private String studentEducation;

    /**
     * 家庭住址
     */
    private String studentHomeaddress;

    /**
     * 学习单位
     */
    private String studentUnit;

    /**
     * 邮箱
     */
    private String studentEmail;

    /**
     * 电话号码
     */
    private String studentPhone;
}
