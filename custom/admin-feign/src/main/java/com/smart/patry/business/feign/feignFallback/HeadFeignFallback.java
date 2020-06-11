package com.smart.patry.business.feign.feignFallback;

import com.smart.patry.business.feign.HeadFeign;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.commons.utils.MapperUtils;
import com.smart.patry.front.dto.PageParamByUsername;
import com.smart.patry.provider.domain.PatryActivity;
import com.smart.patry.provider.domain.PatryApply;
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
public class HeadFeignFallback implements HeadFeign {
    public static final String BREAKING_MESSAGE = "请求失败了，请检查您的网络";
    /**
     * 根据条件： 党总支，党支部均同意，但是人事部没同意，申请状态还在审核中 查找所有的党内申请 返回 List<applyApproveInfo>
     *
     * @return
     */
    @Override
    public String fetchApplyList(PageParamByUsername pageParamByUsername) {

        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String updateApply(PatryApply patryApply) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取党总支所管辖的党支部下的活动申请
     *
     * @param pageParamByUsername
     * @return
     */
    @Override
    public String fetchActivityList(PageParamByUsername pageParamByUsername) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 审批党支部活动申请
     *
     * @param patryActivity
     * @return
     */
    @Override
    public String updateActivity(PatryActivity patryActivity) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
