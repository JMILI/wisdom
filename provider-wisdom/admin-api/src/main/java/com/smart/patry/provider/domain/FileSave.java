package com.smart.patry.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
    *@Description: 
    *@Author: JIMILI,
    *@Data: 2020/6/9,13:44
    *@Version: 
    *@Package: com.smart.patry.provider.domain
    *注解解释：
    *
    */

/**
 * 文件存储表。一个对象可以存储多个文件
 */
@Data
@Table(name = "file_save")
public class FileSave implements Serializable {
    /**
     * 年月日时分秒+4位随机数
     */
    @Id
    @Column(name = "file_id")
    private String fileId;

    /**
     * 文件路径
     */
    @Column(name = "file_path")
    private String filePath;

    /**
     * 上传者账号信息，非空
     */
    @Column(name = "file_uploader_username")
    private String fileUploaderUsername;

    /**
     * 上传者姓名
     */
    @Column(name = "file_uploader_name")
    private String fileUploaderName;

    /**
     * 是为什么上传的，文件是为什么服务的
     */
    @Column(name = "file_uploader_theme")
    private String fileUploaderTheme;

    /**
     * 上传人所在单位
     */
    @Column(name = "file_uploader_unit")
    private String fileUploaderUnit;

    /**
     * 上传时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "file_time")
    private Date fileTime;

    /**
     * 发布状态
     */
    @Column(name = "file_status")
    private String fileStatus;

    private static final long serialVersionUID = -4775061564692644525L;
}