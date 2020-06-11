package com.smart.patry.business.feign.feignFallback;


import com.smart.patry.business.feign.TeacherFeign;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.commons.utils.MapperUtils;
import org.springframework.stereotype.Component;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/5/6,16:47
 *@Version:
 *@Package: com.smart.patry.business.feign.feignFallback
 *注解解释：
 *
 */
@Component
public class TeacherProfileFeignFallback implements TeacherFeign {
    public static final String BREAKING_MESSAGE = "请求失败了，请检查您的网络";

    /**
     * 获取个人信息
     *
     * @param username {@code String} 用户名
     * @return {@code String} JSON
     */
    @Override
    public String info(String username) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
