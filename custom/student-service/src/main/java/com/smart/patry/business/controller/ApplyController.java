package com.smart.patry.business.controller;

import com.smart.patry.business.dto.end2front.StudentApplyInfo;
import com.smart.patry.business.dto.end2front.StudentProfile;
import com.smart.patry.business.dto.front2end.StudentApplyParam;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.provider.api.ExternalStudentService;
import com.smart.patry.provider.api.PatryApplyService;
import com.smart.patry.provider.api.PatryMemberService;
import com.smart.patry.provider.api.PatryNewsService;
import com.smart.patry.provider.domain.ExternalStudent;
import com.smart.patry.provider.domain.PatryApply;
import com.smart.patry.provider.domain.PatryMember;
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
import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/8,16:57 @Version: @Package:
 * com.smart.patry.business.controller 注解解释：
 */
@RestController
@RequestMapping(value = "student")
public class ApplyController {
  @Reference(version = "1.0.0")
  private ExternalStudentService externalStudentService;

  @Reference(version = "1.0.0")
  private PatryApplyService patryApplyService;

  @Reference(version = "1.0.0")
  private PatryMemberService patryMemberService;

  @Resource private BCryptPasswordEncoder passwordEncoder;


  /**
   * 学生党内申请之前前端填充基本信息
   *
   * @param {@code String} 用户名
   * @return {@link ResponseResult}
   */
  //  @PostMapping(value = "applyInfo")
  //  public ResponseResult<StudentApplyInfo> applyInfo(@RequestBody ApplyWatch applyWatch) {

  @GetMapping(value = "applyInfo/{username}")
  public ResponseResult<StudentApplyInfo> applyInfo(@PathVariable String username) {
    ExternalStudent externalStudent = externalStudentService.get(username);
    StudentApplyInfo studentApplyInfo = new StudentApplyInfo();
    if (studentApplyInfo != null) {
      studentApplyInfo.setPatryApplyCall(externalStudent.getStudentPhone());
      studentApplyInfo.setPatryApplyName(externalStudent.getStudentName());
      studentApplyInfo.setPatryApplyUsername(externalStudent.getUsername());
      studentApplyInfo.setPatryApplyWorkunit(externalStudent.getStudentUnit());
      studentApplyInfo.setPatryApplyIdentity("学生");
    }
    //   从党员表中获取信息
    PatryMember patryMember = patryMemberService.get(username);
    if (patryMember != null) {
      studentApplyInfo.setPatryApplyPatryidentity(patryMember.getPtrayMemberIdentity());
      studentApplyInfo.setPatryApplyPatryunit(patryMember.getPtrayMemberNowpatryunit());
    }
    return new ResponseResult<StudentApplyInfo>(CodeStatus.OK, "获取个人信息", studentApplyInfo);
  }
  /**
   * 学生党内申请：积极分子申请，预备党员申请，组织转接申请
   *
   * @param studentApplyParam
   * @return
   */
  @PostMapping(value = "apply/write")
  public ResponseResult<Void> apply(@RequestBody StudentApplyParam studentApplyParam) {
    PatryApply patryApply = new PatryApply();
    BeanUtils.copyProperties(studentApplyParam, patryApply);
    int result = patryApplyService.insert(patryApply);
    if (result > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "申请完成，等待审核");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "申请失败");
    }
  }
  //  /**
  //   * 查看申请状态
  //   *
  //   * @param
  //   * @return
  //   */
  @GetMapping(value = "applyWatch/{username}")
  public ResponseResult<List<PatryApply>> applyWatch(@PathVariable String username) {
    // 查看申请的状态
    List<PatryApply> patryApplyList;
    patryApplyList = patryApplyService.findByUsername(username);
    if (patryApplyList == null) {
      return new ResponseResult<List<PatryApply>>(CodeStatus.FAIL, "没有申请");
    }
    return new ResponseResult<List<PatryApply>>(CodeStatus.OK, "查询成功", patryApplyList);
  }

  /**
   * 取消申请
   *
   * @param patryApplyId
   * @return
   */
  @GetMapping(value = "apply/delete/{patryApplyId}")
  public ResponseResult<Void> applyDelete(@PathVariable String patryApplyId) {
    int result = patryApplyService.delete(patryApplyId);
    if (result > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "成功取消申请");
    }
    return new ResponseResult<Void>(CodeStatus.FAIL, "取消申请失败");
  }
}
