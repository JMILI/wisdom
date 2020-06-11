package com.smart.patry.business.dto.admin;

import lombok.Data;

import java.io.Serializable;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/5/5,19:04
 *@Version:
 *@Package: com.smart.patry.business.dto
 *注解解释：
 *
 */
@Data
/**
* @Description : 
* @Auther : JIMILI
* @Param: null {@link null}
* @Return: 
* @Data 1:32 2020/5/7
* @otherComment
*/
public class ProfileParam implements Serializable {

    private static final long serialVersionUID = -2193913710932580795L;

    private String patryAdminName;

    private String username;

    private String patryAdminUnit;

    private String loginidentity;
}
