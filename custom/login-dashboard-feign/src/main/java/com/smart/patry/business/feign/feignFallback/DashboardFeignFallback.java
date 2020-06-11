package com.smart.patry.business.feign.feignFallback;

import com.smart.patry.business.feign.DashboardFeign;
import com.smart.patry.business.feign.dto.RegistActivityInfo;
import com.smart.patry.front.dto.PageParam;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.commons.utils.MapperUtils;
import com.smart.patry.front.dto.PageParamByUsername;
import com.smart.patry.provider.domain.PatryNews;
import org.springframework.stereotype.Component;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/5/8,23:34
 *@Version:
 *@Package: com.smart.patry.business.feign.feignFallback
 *注解解释：
 *
 */
@Component
public class DashboardFeignFallback implements DashboardFeign {
    public static final String BREAKING_MESSAGE = "请求失败了，请检查您的网络";


    @Override
    public String fetchNewsList() {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String fetchActivityNewsList() {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String fetchStudyList() {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
}

    @Override
    public String registActivity(RegistActivityInfo registActivityInfo) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String fetchFileList() {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
