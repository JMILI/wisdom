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
 * 部门组织结构图
 */
@Data
@Table(name = "patry_organization")
public class PatryOrganization implements Serializable {
    /**
     * 部门id
     */
    @Id
    @Column(name = "patry_organization_id")
    @GeneratedValue(generator = "JDBC")
    private Long patryOrganizationId;

    /**
     * 结构图
     */
    @Column(name = "patry_organization_structureDiagram")
    private String patryOrganizationStructurediagram;

    /**
     * 人员分布图
     */
    @Column(name = "patry_organization_staffDistribution")
    private String patryOrganizationStaffdistribution;

    /**
     * 部门邮箱
     */
    @Column(name = "patry_organization_email")
    private String patryOrganizationEmail;

    /**
     * 部门电话
     */
    @Column(name = "patry_organization_call")
    private String patryOrganizationCall;

    /**
     * 部门
     */
    @Column(name = "patry_organization_unit")
    private String patryOrganizationUnit;

    private static final long serialVersionUID = 4979705786462420426L;
}