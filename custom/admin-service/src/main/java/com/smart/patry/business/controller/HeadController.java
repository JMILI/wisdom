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
import com.smart.patry.provider.api.UnitRelationService;
import com.smart.patry.provider.domain.PatryActivity;
import com.smart.patry.provider.domain.PatryApply;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/5,18:43 @Version: @Package:
 * com.smart.patry.business.controller 注解解释：
 */
@RestController
@RequestMapping(value = "admin")
public class HeadController {
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
  private UnitRelationService unitRelationService;

  @Resource private BCryptPasswordEncoder passwordEncoder;
  // endregion

  // region 党员申请审批

  // region 查找需要审批的党内成员申请 【后台已测试】
  /**
   * 根据条件： 党总支，党支部均同意，但是人事部没同意，申请状态还在审核中 查找所有的党内申请 返回 List<applyApproveInfo>
   *
   * @return
   */
  @PostMapping(value = "head/fetchApplyList")
  public ResponseResult<PageInfo<PatryApply>> fetchApplyList(
      @RequestBody PageParamByUsername pageParamByUsername) {
    List<String> stringList =unitRelationService.getUnitBySuperUnit(pageParamByUsername.getUnit());
        PageInfo < PatryApply > pageInfo =
            patryApplyService.headWatch(pageParamByUsername, stringList);
    return new ResponseResult<PageInfo<PatryApply>>(CodeStatus.OK, "查询成功", pageInfo);
  }

  // region 数据库上传人事处评审信息 【？】
  /**
   * 人事处审核之后修改表中，人事处需要处理的字段
   *
   * @param patryApply
   * @return
   */
  @PostMapping(value = "head/updateApply")
  public ResponseResult<Void> updateApply(@RequestBody PatryApply patryApply) {

    if (patryApply.getPatryApplyDenialreason() != ""
        || !patryApply.getPatryApplyHeadopinon().equals("同意")) {
      patryApply.setPatryApplyStatus("驳回");
    }
    int update = patryApplyService.update(patryApply);
    if (update > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "评审成功");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "评审失败，请检查网络");
    }
  }


  @PostMapping(value = "head/fetchActivityList")
  public ResponseResult<PageInfo<PatryActivity>> fetchActivityList(
          @RequestBody PageParamByUsername pageParamByUsername) {
    List<String> stringList =unitRelationService.getUnitBySuperUnit(pageParamByUsername.getUnit());
    PageInfo <PatryActivity> pageInfo =
            patryActivityService.headWatch(pageParamByUsername, stringList);
    return new ResponseResult<PageInfo<PatryActivity>>(CodeStatus.OK, "查询成功", pageInfo);
  }

  // region 数据库上传人事处评审信息
  /**
   *
   *
   * @param patryActivity
   * @return
   */
  @PostMapping(value = "head/updateActivity")
  public ResponseResult<Void> updateActivity(@RequestBody PatryActivity patryActivity) {

    if (patryActivity.getPatryActivityDenialreason() != ""
            || !patryActivity.getPatryActivityHeadopinion().equals("同意")) {
      patryActivity.setPatryActivityStatus("驳回");
    }
    int update = patryActivityService.update(patryActivity);
    if (update > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "评审成功");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "评审失败，请检查网络");
    }
  }
}
