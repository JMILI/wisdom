package com.smart.patry.provider.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
    *@Description: 
    *@Author: JIMILI,
    *@Data: 2020/5/24,2:40
    *@Version: 
    *@Package: com.smart.patry.provider.domain
    *注解解释：
    *
    */

/**
 * 学生和教师登录系统的账户表
 */
@Data
@Table(name = "account")
public class Account implements Serializable {
    /**
     * 账号
     */
    @Id
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 登录身份
     */
    @Column(name = "login_identity")
    private String loginIdentity;

    /**
     * 所属党部门
     */
    @Column(name = "login_unit")
    private String loginUnit;

    /**
     * 姓名
     */
    @Column(name = "account_name")
    private String accountName;

    private static final long serialVersionUID = -7862724536170942428L;
}