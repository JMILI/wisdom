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
 * 管理员表：角色包含：党支部，党总支，党委
 */
@Data
@Table(name = "patry_admin")
public class PatryAdmin implements Serializable {
    /**
     * 可以是用户名，也可以是id账号，这里用id
     */
    @Id
    @Column(name = "patry_admin_username")
    private String username;

    /**
     * 管理员姓名
     */
    @Column(name = "patry_admin_name")
    private String patryAdminName;

    /**
     * 密码
     */
    @Column(name = "patry_admin_password")
    private String password;

    /**
     * 部门的全称单位名，如：西安建筑科技大学信控党委下属党支部
     */
    @Column(name = "patry_admin_unit")
    private String loginUnit;

    /**
     * 登录身份：党总支，人事处，党支部，用于分辨是那个系统
     */
    @Column(name = "login_identity")
    private String loginIdentity;

    private static final long serialVersionUID = 1147127375475300924L;
}