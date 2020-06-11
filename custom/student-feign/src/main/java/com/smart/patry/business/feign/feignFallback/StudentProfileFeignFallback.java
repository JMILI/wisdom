package com.smart.patry.business.feign.feignFallback;


import com.smart.patry.business.dto.front2end.ApplyDelete;
import com.smart.patry.business.dto.front2end.ApplyWatch;
import com.smart.patry.business.dto.front2end.StudentApplyParam;
import com.smart.patry.business.feign.StudentFeign;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.commons.utils.MapperUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

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
public class StudentProfileFeignFallback implements StudentFeign {
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

    /**
     * 获取个人信息
     *
     * @param username {@code String} 用户名
     * @return {@code String} JSON
     */
    @Override
    public String profile(String username) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取申请时学生的基本信息
     *
     * @param username
     * @return
     */
    @Override
    public String applyInfo(String username) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    @Override
//    public String applyInfo(ApplyWatch applyWatch) {
//        try {
//            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    /**
     * 学生党内申请：积极分子申请，预备党员申请，组织转接申请
     * @param studentApplyParam
     * @return
     */
    @Override
    public String apply(StudentApplyParam studentApplyParam) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param username
     * @return
     */
    @Override
    public String applyWatch(String username) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 取消申请
     * @param patryApplyId
     * @return
     */
    @Override
    public String applyDelete(String patryApplyId) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据公告表中的公告状态获取公告
     * @return
     */
    @Override
    public String findNews() {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
