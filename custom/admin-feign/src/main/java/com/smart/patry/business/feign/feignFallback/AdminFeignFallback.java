package com.smart.patry.business.feign.feignFallback;

import com.smart.patry.business.dto.admin.PasswordParam;
import com.smart.patry.business.dto.admin.ProfileParam;
import com.smart.patry.business.feign.AdminFeign;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.commons.utils.MapperUtils;
import com.smart.patry.front.dto.PageParam;
import com.smart.patry.provider.domain.ActivityRegist;
import com.smart.patry.provider.domain.FileSave;
import com.smart.patry.provider.domain.PatryAdmin;
import com.smart.patry.provider.domain.StudyHref;
import org.springframework.stereotype.Component;

import java.util.List;

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
public class AdminFeignFallback implements AdminFeign {
    public static final String BREAKING_MESSAGE = "请求失败了，请检查您的网络";

    /**
     * 获取个人信息
     *
     * @param patryAdminId {@code String} 用户名
     * @return {@code String} JSON
     */
    @Override
    public String info(String patryAdminId) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新个人信息
     *
     * @param profileParam {@link ProfileParam}
     * @return {@code String} JSON
     */
    @Override
    public String update(ProfileParam profileParam) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改密码
     *
     * @param passwordParam {@link PasswordParam}
     * @return {@code String} JSON
     */
    @Override
    public String modifyPassword(PasswordParam passwordParam) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description : 注册
     * @Auther : JIMILI
     * @Param: null {@link null}
     * @Return:
     * @Data 19:47 2020/5/5
     * @otherComment
     * @param patryAdmin
     */
    @Override
    public String reg(PatryAdmin patryAdmin) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取所有部门名称
     *
     * @return
     */
    @Override
    public String acquireUnitData() {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取报名表
     *
     * @param pageParam
     * @return
     */
    @Override
    public String fetchActRegistList(PageParam pageParam) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteAllOverActRegist(List<ActivityRegist> activityRegistList) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加学习连接
     *
     * @param studyHref
     * @return
     */
    @Override
    public String addStudyHref(StudyHref studyHref) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String fetchStudyHrefList(String loginUnit) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改新闻状态
     *
     * @param studyHref
     * @return
     */
    @Override
    public String updateStudyHref(StudyHref studyHref) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据id删除
     *
     * @param studyId
     * @return
     */
    @Override
    public String deleteStudyHrefById(String studyId) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加学习连接
     *
     * @param fileSave@return
     */
    @Override
    public String addFileSave(FileSave fileSave) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String fetchFileSaveList(String loginUnit) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改新闻状态
     *
     * @param fileSave
     * @return
     */
    @Override
    public String updateFileSave(FileSave fileSave) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据id删除
     *
     * @param fileId
     * @return
     */
    @Override
    public String deleteFileSaveById(String fileId) {
        try {
            return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING,BREAKING_MESSAGE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
