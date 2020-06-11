package com.smart.patry.business.feign.feignFallback;

import com.smart.patry.front.dto.PageParam;
import com.smart.patry.business.feign.BranchFeign;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.commons.utils.MapperUtils;
import com.smart.patry.front.dto.PageParamByUsername;
import com.smart.patry.provider.domain.PatryActivity;
import com.smart.patry.provider.domain.PatryApply;
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
public class BranchFeignFallback implements BranchFeign {
    public static final String BREAKING_MESSAGE = "请求失败了，请检查您的网络";

    /**
     * 根据条件： 党总支，党支部均同意，但是人事部没同意，申请状态还在审核中 查找所有的党内申请 返回 List<applyApproveInfo>
     *
     * @return
     */
    @Override
    public String watchPatryApply(PageParamByUsername pageParamByUsername) {

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
     * 增加活动申请
     *
     * @param patryActivity
     * @return
     */
    @Override
    public String addActivity(PatryActivity patryActivity) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取某党组织单位的活动申请
     *
     * @param loginUnit
     * @return
     */
    @Override
    public String fetchActivityList(String loginUnit) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据id删除
     *
     * @param patryActivityId
     * @return
     */
    @Override
    public String deleteActivity(String patryActivityId) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据id查找
     *
     * @param patryActivityId
     * @return
     */
    @Override
    public String fetchDataById(String patryActivityId) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 增加公告
     *
     * @param patryNews
     * @return
     */
    @Override
    public String addNews(PatryNews patryNews) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String fetchNewsList(String loginUnit) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据id查找
     *
     * @param patryNewsId
     * @return
     */
    @Override
    public String fetchNewsDataById(String patryNewsId) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改新闻状态
     *
     * @param patryNews
     * @return
     */
    @Override
    public String updateNews(PatryNews patryNews) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据id删除
     *
     * @param patryNewsId
     * @return
     */
    @Override
    public String deleteNewsById(String patryNewsId) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
