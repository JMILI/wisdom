package com.smart.patry.business.controller;

import com.github.pagehelper.PageInfo;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.front.dto.PageParamByUsername;
import com.smart.patry.provider.api.ExternalStudentService;
import com.smart.patry.provider.api.ExternalTeacherService;
import com.smart.patry.provider.api.PatryActivityService;
import com.smart.patry.provider.api.PatryAdminService;
import com.smart.patry.provider.api.PatryApplyService;
import com.smart.patry.provider.api.PatryMemberService;
import com.smart.patry.provider.api.PatryNewsService;
import com.smart.patry.provider.domain.PatryActivity;
import com.smart.patry.provider.domain.PatryAdmin;
import com.smart.patry.provider.domain.PatryApply;
import com.smart.patry.provider.domain.PatryNews;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Max;
import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/5,18:43 @Version: @Package:
 * com.smart.patry.business.controller 注解解释：
 */
@RestController
@RequestMapping(value = "admin")
public class BranchController {
  // region 资源工具
  @Reference(version = "1.0.0")
  private PatryAdminService patryAdminService;

  @Reference(version = "1.0.0")
  private PatryApplyService patryApplyService;

  @Reference(version = "1.0.0")
  private PatryActivityService patryActivityService;

  @Reference(version = "1.0.0")
  private PatryMemberService patryMemberService;

  @Reference(version = "1.0.0")
  private ExternalStudentService externalStudentService;

  @Reference(version = "1.0.0")
  private ExternalTeacherService externalTeacherService;

  @Reference(version = "1.0.0")
  private PatryNewsService patryNewsService;

  @Resource private BCryptPasswordEncoder passwordEncoder;
  // endregion

  // region 党员申请审批

  // region 查找需要审批的党内成员申请 【后台已测试】
  /**
   * 根据条件： 党总支，党支部均同意，但是人事部没同意，申请状态还在审核中 查找所有的党内申请 返回 List<applyApproveInfo>
   *
   * @return
   */
  @PostMapping(value = "branch/apply/watch")
  public ResponseResult<PageInfo<PatryApply>> watchPatryApply(
      @RequestBody PageParamByUsername pageParamByUsername) {
    PageInfo<PatryApply> pageInfo =
        patryApplyService.branchWatch(pageParamByUsername, pageParamByUsername.getUnit());
    return new ResponseResult<PageInfo<PatryApply>>(CodeStatus.OK, "查询成功", pageInfo);
  }

  // region 数据库上传人事处评审信息 【？】
  /**
   * 人事处审核之后修改表中，人事处需要处理的字段
   *
   * @param patryApply
   * @return
   */
  @PostMapping(value = "branch/apply/update")
  public ResponseResult<Void> updateApply(@RequestBody PatryApply patryApply) {
    //    PatryApply patryApply = new PatryApply();
    //    BeanUtils.copyProperties(applyApproveParam, patryApply);
    if (patryApply.getPatryApplyDenialreason() != ""
        || !patryApply.getPatryApplyBranchopinion().equals("同意")) {
      patryApply.setPatryApplyStatus("驳回");
    }
    int update = patryApplyService.update(patryApply);
    if (update > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "评审成功");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "评审失败，请检查网络");
    }
  }

  @PostMapping(value = "branch/addActivity")
  public ResponseResult<Void> addActivity(@RequestBody PatryActivity patryActivity) {
    if (patryActivity != null) {
      int result = patryActivityService.insert(patryActivity);
      if (result > 0) {
        return new ResponseResult<Void>(CodeStatus.OK, "成功");
      }
    }
    return new ResponseResult<Void>(CodeStatus.FAIL, "申请失败");
  }

  @GetMapping(value = "branch/fetchActivityList/{loginUnit}")
  public ResponseResult<List<PatryActivity>> fetchActivityList(@PathVariable String loginUnit) {
    List<PatryActivity> patryActivityList = patryActivityService.branchGetByUnit(loginUnit);
    if (patryActivityList.size() >= 0) {
      return new ResponseResult<List<PatryActivity>>(CodeStatus.OK, "查询成功", patryActivityList);
    } else {
      return new ResponseResult<List<PatryActivity>>(CodeStatus.FAIL, "查询失败");
    }
  }

  @GetMapping(value = "branch/deleteActivity/{patryActivityId}")
  public ResponseResult<Void> deleteActivity(@PathVariable String patryActivityId) {
    int result = patryActivityService.deleteById(patryActivityId);
    if (result > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "成功取消申请");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "取消失败");
    }
  }

  @GetMapping(value = "branch/fetchDataById/{patryActivityId}")
  public ResponseResult<PatryActivity> fetchDataById(@PathVariable String patryActivityId) {
    PatryActivity result = patryActivityService.findById(patryActivityId);
    if (result != null) {
      return new ResponseResult<PatryActivity>(CodeStatus.OK, "请您编辑", result);
    } else {
      return new ResponseResult<PatryActivity>(CodeStatus.FAIL, "查找失败");
    }
  }

  @PostMapping(value = "branch/addNews")
  public ResponseResult<Void> addNews(@RequestBody PatryNews patryNews) {
    if (patryNews != null) {
      int result = patryNewsService.insert(patryNews);
      if (result > 0) {
        return new ResponseResult<Void>(CodeStatus.OK, "发布成功");
      }
    }
    return new ResponseResult<Void>(CodeStatus.FAIL, "发布失败");
  }

  @GetMapping(value = "branch/fetchNewsList/{loginUnit}")
  public ResponseResult<List<PatryNews>> fetchNewsList(@PathVariable String loginUnit) {
    List<PatryNews> patryNewsList = patryNewsService.branchGetByUnit(loginUnit);
    if (patryNewsList.size() >= 0) {
      return new ResponseResult<List<PatryNews>>(CodeStatus.OK, "查询成功", patryNewsList);
    } else {
      return new ResponseResult<List<PatryNews>>(CodeStatus.FAIL, "查询失败");
    }
  }
  @GetMapping(value = "branch/fetchNewsDataById/{patryNewsId}")
  public ResponseResult<PatryNews> fetchNewsDataById(@PathVariable String patryNewsId) {
    PatryNews result = patryNewsService.findById(patryNewsId);
    if (result != null) {
      return new ResponseResult<PatryNews>(CodeStatus.OK, "请您编辑", result);
    } else {
      return new ResponseResult<PatryNews>(CodeStatus.FAIL, "查找失败");
    }
  }
  @PostMapping(value = "branch/updateNews")
  public ResponseResult<Void> updateNews(@RequestBody PatryNews patryNews){
    int update = patryNewsService.update(patryNews);
    if (update > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "操作成功");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "操作失败，请检查网络");
    }
  }

  @GetMapping(value = "branch/deleteNewsById/{patryNewsId}")
  public ResponseResult<Void> deleteNewsById(@PathVariable String patryNewsId){
    int delete = patryNewsService.delete(patryNewsId);
    if (delete > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "已删除该公告");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "操作失败，请检查网络");
    }
  }
}



