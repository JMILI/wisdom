package com.smart.patry.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
    *@Description: 
    *@Author: JIMILI,
    *@Data: 2020/6/8,21:28
    *@Version: 
    *@Package: com.smart.patry.provider.domain
    *注解解释：
    *
    */

/**
 * 学习外链表。存储学习的一些连接
 */
@Data
@Table(name = "study_href")
public class StudyHref implements Serializable {
    /**
     * id主键
     */
    @Id
    @Column(name = "study_id")
    private String studyId;

    /**
     * 学习主题
     */
    @Column(name = "study_theme")
    private String studyTheme;

    /**
     * 学习的连接
     */
    @Column(name = "study_href")
    private String studyHref;

    /**
     * 链接上传时间，系统自动生成
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "study_upload_time")
    private Date studyUploadTime;

    /**
     * 连接状态
     */
    @Column(name = "study_status")
    private String studyStatus;

    /**
     * 上传人账号
     */
    @Column(name = "study_upload_username")
    private String studyUploadUsername;

    /**
     * 上传人姓名
     */
    @Column(name = "study_upload_name")
    private String studyUploadName;

    /**
     * 上传人姓名
     */
    @Column(name = "study_upload_unit")
    private String studyUploadUnit;

    private static final long serialVersionUID = 5601119588932724800L;
}