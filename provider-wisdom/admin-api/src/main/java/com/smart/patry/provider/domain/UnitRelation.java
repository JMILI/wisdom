package com.smart.patry.provider.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
    *@Description: 
    *@Author: JIMILI,
    *@Data: 2020/5/26,15:53
    *@Version: 
    *@Package: com.smart.patry.provider.domain
    *注解解释：
    *
    */

/**
 * 单位关系表
 */
@Data
@Table(name = "unit_relation")
public class UnitRelation implements Serializable {
    /**
     * 部门名称，例如：信控学院党总支
     */
    @Id
    @Column(name = "unit_name")
    private String unitName;

    /**
     * 部门电话
     */
    @Column(name = "unit_call")
    private String unitCall;

    /**
     * 部门邮箱
     */
    @Column(name = "unit_email")
    private String unitEmail;

    /**
     * 该部门的上级部门
     */
    @Column(name = "unit_super_department_name")
    private String unitSuperDepartmentName;

    private static final long serialVersionUID = -1969121240812155438L;
}