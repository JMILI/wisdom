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
public class ApplyDelete implements Serializable {
    private static final long serialVersionUID= 6882954752789794115L;
    /**
     * 根据申请订单id查询
     */
    private String patryApplyId;
}
