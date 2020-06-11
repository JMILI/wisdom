package com.smart.patry.business.feign;

import com.smart.patry.business.dto.admin.PasswordParam;
import com.smart.patry.business.dto.admin.ProfileParam;
import com.smart.patry.configuration.FeignRequestConfiguration;
import com.smart.patry.front.dto.PageParam;
import com.smart.patry.provider.domain.ActivityRegist;
import com.smart.patry.provider.domain.FileSave;
import com.smart.patry.provider.domain.PatryAdmin;
import com.smart.patry.provider.domain.PatryNews;
import com.smart.patry.provider.domain.StudyHref;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 *@Description:
 *@Author: JIMILI,
 *@Data: 2020/5/5,19:32
 *@Version:
 *@Package: com.smart.patry.business.feign
 *注解解释：
 *
 */
@FeignClient(value = "admin-management", path = "admin", configuration = FeignRequestConfiguration.class)
public interface AdminFeign {
    //region 个人信息管理
    /**
     * 获取个人信息
     *
     * @param username {@code String} 用户名
     * @return {@code String} JSON
     */
    @GetMapping(value = "profile/info/{username}")
    String info(@PathVariable String username);
    /**
     * 更新个人信息
     *
     * @param profileParam {@link ProfileParam}
     * @return {@code String} JSON
     */
    @PostMapping(value = "profile/update")
    String update(@RequestBody ProfileParam profileParam);

    /**
     * 修改密码
     *
     * @param passwordParam {@link PasswordParam}
     * @return {@code String} JSON
     */
    @PostMapping(value = "profile/modify/password")
    String modifyPassword(@RequestBody PasswordParam passwordParam);
/**
* @Description : 注册
* @Auther : JIMILI
* @Param: null {@link null}
* @Return:
* @Data 19:47 2020/5/5
* @otherComment
*/
    @PostMapping(value = "profile/reg")
    String reg(@RequestBody PatryAdmin patryAdmin);
    //endregion

    /**
     * 获取所有部门名称
     * @return
     */
    @GetMapping(value = "acquireUnitData")
    String acquireUnitData();


    /**
     * 获取报名表
     * @param pageParam
     * @return
     */
    @PostMapping(value = "fetchActRegistList")
    String fetchActRegistList(@RequestBody PageParam pageParam);

    @PostMapping(value = "deleteAllOverActRegist")
    String deleteAllOverActRegist(@RequestBody List<ActivityRegist> activityRegistList);

    /**
     * 添加学习连接
     * @param studyHref
     * @return
     */
    @PostMapping(value = "addStudyHref")
    String addStudyHref(@RequestBody StudyHref studyHref);




    @GetMapping(value = "fetchStudyHrefList/{loginUnit}")
    String fetchStudyHrefList(@PathVariable String loginUnit);



    /**
     * 修改新闻状态
     * @param studyHref
     * @return
     */
    @PostMapping(value = "updateStudyHref")
    String updateStudyHref(@RequestBody StudyHref studyHref);
    /**
     * 根据id删除
     * @param studyId
     * @return
     */
    @GetMapping(value = "deleteStudyHrefById/{studyId}")
    String deleteStudyHrefById(@PathVariable String studyId);

    /**
     * 添加学习连接
     * @param studyHref
     * @return
     */
    @PostMapping(value = "addFileSave")
    String addFileSave(@RequestBody FileSave fileSave);




    @GetMapping(value = "fetchFileSaveList/{loginUnit}")
    String fetchFileSaveList(@PathVariable String loginUnit);



    /**
     * 修改新闻状态
     * @param fileSave
     * @return
     */
    @PostMapping(value = "updateFileSave")
    String updateFileSave(@RequestBody FileSave fileSave);
    /**
     * 根据id删除
     * @param fileId
     * @return
     */
    @GetMapping(value = "deleteFileSaveById/{fileId}")
    String deleteFileSaveById(@PathVariable String fileId);
}
