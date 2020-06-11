package com.smart.patry.commons.dto;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/4/28,0:43
 *@Version:
 *@Package: com.smart.patry.commons.dto
 *注解解释：
 *
 */
public class CodeStatus {
    /**
     * 请求成功
     */
    public static final int OK = 20000;

    /**
     * 请求失败
     */
    public static final int FAIL = 20002;

    /**
     * 熔断请求
     */
    public static final int BREAKING = 20004;

    /**
     * 非法请求
     */
    public static final int ILLEGAL_REQUEST = 50000;

    /**
     * 非法令牌
     */
    public static final int ILLEGAL_TOKEN = 50008;

    /**
     * 其他客户登录
     */
    public static final int OTHER_CLIENTS_LOGGED_IN = 50012;

    /**
     * 令牌已过期
     */
    public static final int TOKEN_EXPIRED = 50014;
}