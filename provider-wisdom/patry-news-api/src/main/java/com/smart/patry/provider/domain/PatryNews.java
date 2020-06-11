package com.smart.patry.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
    *@Description: 
    *@Author: JIMILI,
    *@Data: 2020/5/26,0:01
    *@Version: 
    *@Package: com.smart.patry.provider.domain
    *注解解释：
    *
    */

/**
 * 党内公告表
 */
@Data
@Table(name = "patry_news")
public class PatryNews implements Serializable {
    /**
     * 公告id：年月日时分
     */
    @Id
    @Column(name = "patry_news_id")
    private String patryNewsId;

    /**
     * 公告主题
     */
    @Column(name = "patry_news_theme")
    private String patryNewsTheme;

    /**
     * 主要内容
     */
    @Column(name = "patry_news_content")
    private String patryNewsContent;

    /**
     * 附件：学习材料，可为空
     */
    @Column(name = "patry_news_annex")
    private String patryNewsAnnex;

    /**
     * 发布时间，系统时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "patry_news_time")
    private Date patryNewsTime;

    /**
     * 发布，未发布
     */
    @Column(name = "patry_news_status")
    private String patryNewsStatus;

    /**
     * 发布部门
     */
    @Column(name = "patry_news_unit")
        private String patryNewsUnit;

    /**
     * 该公告，或者活动是否可以报名
     */
    @Column(name = "patry_news_activity")
    private String patryNewsActivity;

    private static final long serialVersionUID = 345774592811724824L;
}