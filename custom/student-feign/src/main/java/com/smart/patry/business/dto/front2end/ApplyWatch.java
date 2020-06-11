package com.smart.patry.business.dto.front2end;

import lombok.Data;

import java.io.Serializable;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/5/8,21:37
 *@Version:
 *@Package: com.smart.patry.business.dto.front2end
 *注解解释：
 *
 */
@Data
public class ApplyWatch implements Serializable {
    private static final long serialVersionUID= -3791010959133775626L;
    /**
     * 根据学生账号查询
     */
    private String username;
}
