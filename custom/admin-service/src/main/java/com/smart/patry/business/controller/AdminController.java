package com.smart.patry.business.controller;

import com.github.pagehelper.PageInfo;
import com.smart.patry.business.dto.admin.PatryAdminDTO;
import com.smart.patry.business.dto.admin.PasswordParam;
import com.smart.patry.business.dto.admin.ProfileParam;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.front.dto.PageParam;
import com.smart.patry.provider.api.ActivityRegistService;
import com.smart.patry.provider.api.FileSaveService;
import com.smart.patry.provider.api.PatryAdminService;
import com.smart.patry.provider.api.PatryNewsService;
import com.smart.patry.provider.api.StudyHrefService;
import com.smart.patry.provider.api.UnitRelationService;
import com.smart.patry.provider.domain.ActivityRegist;
import com.smart.patry.provider.domain.FileSave;
import com.smart.patry.provider.domain.PatryAdmin;
import com.smart.patry.provider.domain.PatryApply;
import com.smart.patry.provider.domain.PatryNews;
import com.smart.patry.provider.domain.StudyHref;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
/**
 * @Description: @Author: JIMILI, @Data: 2020/5/5,18:43 @Version: @Package:
 * com.smart.patry.business.controller 注解解释：
 */
@RestController
@RequestMapping(value = "admin")
public class AdminController {
  @Reference(version = "1.0.0")
  private PatryAdminService patryAdminService;

  @Reference(version = "1.0.0")
  private UnitRelationService unitRelationService;

  @Reference(version = "1.0.0")
  private PatryNewsService patryNewsService;

  @Reference(version = "1.0.0")
  private ActivityRegistService activityRegistService;

  @Reference(version = "1.0.0")
  private StudyHrefService studyHrefService;

  @Reference(version = "1.0.0")
  private FileSaveService fileSaveService;

  @Resource private BCryptPasswordEncoder passwordEncoder;

  // region 个人信息管理
  // region 注册账号
  /**
   * @Description : @Auther : JIMILI @Param: PatryAdmin {@link PatryAdmin} @Return: @Data 3:03
   * 2020/4/28
   *
   * @otherComment
   */
  @PostMapping(value = "profile/reg")
  public ResponseResult<Void> reg(@RequestBody PatryAdmin patryAdmin) {
    String message = validateReg(patryAdmin.getUsername());
    // 可注册
    if (message == null) {
      int result = patryAdminService.insert(patryAdmin);
      if (result > 0) {
        PatryAdmin patryAdmin1 = patryAdminService.get(patryAdmin.getUsername());
        // 这里代码状态有改变，有疑问
        return new ResponseResult<Void>(CodeStatus.OK, "用户注册成功", null);
      }
    }
    return new ResponseResult<Void>(CodeStatus.FAIL, message != null ? message : "用户注册失败");
  }

  private String validateReg(String username) {
    PatryAdmin patryAdmin = patryAdminService.get(username);
    if (patryAdmin != null) {
      return "用户存在";
    }

    return null;
  }
  // endregion

  /**
   * 获取个人信息
   *
   * @param username {@code String} 用户名
   * @return {@link ResponseResult}
   */
  @GetMapping(value = "profile/info/{username}")
  public ResponseResult<PatryAdminDTO> info(@PathVariable String username) {
    PatryAdmin umsAdmin = patryAdminService.get(username);
    PatryAdminDTO dto = new PatryAdminDTO();
    //        (资源，目标）
    BeanUtils.copyProperties(umsAdmin, dto);
    return new ResponseResult<PatryAdminDTO>(CodeStatus.OK, "获取个人信息", dto);
  }

  /**
   * 更新个人信息
   *
   * @param profileParam {@link ProfileParam}
   * @return {@link ResponseResult}
   */
  @PostMapping(value = "profile/update")
  public ResponseResult<Void> update(@RequestBody ProfileParam profileParam) {
    PatryAdmin newPatryAdmin = new PatryAdmin();
    newPatryAdmin = patryAdminService.get(profileParam.getUsername());
    BeanUtils.copyProperties(profileParam, newPatryAdmin);
    int result = patryAdminService.update(newPatryAdmin);

    // 成功
    if (result > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "更新个人信息成功");
    }

    // 失败
    else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "更新个人信息失败");
    }
  }

  /**
   * 修改密码
   *
   * @param passwordParam {@link PasswordParam}
   * @return {@link ResponseResult}
   */
  @PostMapping(value = "profile/modify/password")
  public ResponseResult<Void> modifyPassword(@RequestBody PasswordParam passwordParam) {
    PatryAdmin patryAdmin = patryAdminService.get(passwordParam.getUsername());

    // 旧密码正确
    if (passwordEncoder.matches(
        passwordParam.getOldPatryAdminPassword(), patryAdmin.getPassword())) {
      //            更新新密码，数据访问层会稍后加密
      patryAdmin.setPassword(passwordParam.getNewPatryAdminPassword());
      //            数据库修改密码
      int result = patryAdminService.update(patryAdmin);
      if (result > 0) {
        return new ResponseResult<Void>(CodeStatus.OK, "修改密码成功");
      }
    }

    // 旧密码错误
    else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "旧密码不匹配，请重试");
    }

    return new ResponseResult<Void>(CodeStatus.FAIL, "修改密码失败");
  }
  // endregion

  @GetMapping(value = "acquireUnitData")
  public ResponseResult<List<String>> acquireUnitData() {
    List<String> stringList = unitRelationService.acquireUnitData();
    return new ResponseResult<List<String>>(CodeStatus.OK, stringList);
  }

  @PostMapping(value = "fetchActRegistList")
  public ResponseResult<PageInfo<ActivityRegist>> fetchActRegistList(
      @RequestBody PageParam pageParam) {
    List<String> stringList = unitRelationService.getUnitBySuperUnit(pageParam.getUnit());
    PageInfo<ActivityRegist> pageInfo =
        activityRegistService.getActRegistList(pageParam, stringList);
    return new ResponseResult<PageInfo<ActivityRegist>>(CodeStatus.OK, pageInfo);
  }

  @PostMapping(value = "deleteAllOverActRegist")
  public ResponseResult<Void> deleteAllOverActRegist(
      @RequestBody List<ActivityRegist> activityRegistList) {
    boolean deletemy = activityRegistService.delete(activityRegistList);
    if (deletemy == true) {
      return new ResponseResult<Void>(CodeStatus.OK, "删除成功");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "删除失败");
    }
  }

  @PostMapping(value = "addStudyHref")
  public ResponseResult<Void> addStudyHref(@RequestBody StudyHref studyHref) {

    boolean isPing = testUrlWithTimeOut(studyHref.getStudyHref(), 10000);
    if (isPing == true) {
      int result = studyHrefService.insert(studyHref);
      if (result > 0) {
        return new ResponseResult<Void>(CodeStatus.OK, "添加学习链接成功");
      } else {
        return new ResponseResult<Void>(CodeStatus.FAIL, "添加失败");
      }
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "网址无效。或者网址访问缓慢");
    }
  }

  public boolean testUrlWithTimeOut(String urlString, int timeOutMillSeconds) {
    long lo = System.currentTimeMillis();
    URL url;
    boolean reslut = false;
    try {
      url = new URL(urlString);
      URLConnection co = url.openConnection();
      co.setConnectTimeout(timeOutMillSeconds);
      co.connect();
      System.out.println("连接可用");
      reslut = true;
    } catch (Exception e1) {
      System.out.println("连接打不开!");
      url = null;
      reslut = false;
    }
    System.out.println(System.currentTimeMillis() - lo);
    return reslut;
  }

  @GetMapping(value = "fetchStudyHrefList/{loginUnit}")
  public ResponseResult<List<StudyHref>> fetchStudyHrefList(@PathVariable String loginUnit) {
    List<String> stringList = unitRelationService.getUnitBySuperUnit(loginUnit);
    List<StudyHref> studyHrefList = studyHrefService.GetByUnit(loginUnit, stringList);
    if (studyHrefList.size() >= 0) {
      return new ResponseResult<List<StudyHref>>(CodeStatus.OK, "查询成功", studyHrefList);
    } else {
      return new ResponseResult<List<StudyHref>>(CodeStatus.FAIL, "查询失败");
    }
  }

  @PostMapping(value = "updateStudyHref")
  public ResponseResult<Void> updateStudyHref(@RequestBody StudyHref studyHref) {
    int update = studyHrefService.update(studyHref);
    if (update > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "更新成功");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "操作失败，请检查网络");
    }
  }

  @GetMapping(value = "deleteStudyHrefById/{studyId}")
  public ResponseResult<Void> deleteStudyHrefById(@PathVariable String studyId) {
    int delete = studyHrefService.delete(studyId);
    if (delete > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "已删除该学习链接");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "操作失败，请检查网络");
    }
  }

  @PostMapping(value = "addFileSave")
  public ResponseResult<Void> addFileSave(@RequestBody FileSave fileSave) {

    int result = fileSaveService.insert(fileSave);
    if (result > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "上传文件发布成功");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "上传文件发布失败");
    }
  }

  @GetMapping(value = "fetchFileSaveList/{loginUnit}")
  public ResponseResult<List<FileSave>> fetchFileSaveList(@PathVariable String loginUnit) {
    List<String> stringList = unitRelationService.getUnitBySuperUnit(loginUnit);
    List<FileSave> fileSaveList = fileSaveService.GetByUnit(loginUnit, stringList);
    if (fileSaveList.size() >= 0) {
      return new ResponseResult<List<FileSave>>(CodeStatus.OK, "查询成功", fileSaveList);
    } else {
      return new ResponseResult<List<FileSave>>(CodeStatus.FAIL, "查询失败");
    }
  }

  @PostMapping(value = "updateFileSave")
  public ResponseResult<Void> updateFileSave(@RequestBody FileSave fileSave) {
    int update = fileSaveService.update(fileSave);
    if (update > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "更新成功");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "操作失败，请检查网络");
    }
  }

  @GetMapping(value = "deleteFileSaveById/{fileId}")
  public ResponseResult<Void> deleteFileSaveById(@PathVariable String fileId) {
    int delete = fileSaveService.delete(fileId);
    if (delete > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "已删除");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "操作失败，请检查网络");
    }
  }
}
