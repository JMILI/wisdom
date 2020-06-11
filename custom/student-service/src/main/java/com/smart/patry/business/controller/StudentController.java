package com.smart.patry.business.controller;

import com.smart.patry.business.dto.end2front.StudentApplyInfo;
import com.smart.patry.business.dto.end2front.StudentInfo;
import com.smart.patry.business.dto.end2front.StudentProfile;
import com.smart.patry.business.dto.front2end.ApplyDelete;
import com.smart.patry.business.dto.front2end.ApplyWatch;
import com.smart.patry.business.dto.front2end.StudentApplyParam;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.provider.api.ExternalStudentService;
import com.smart.patry.provider.api.PatryApplyService;
import com.smart.patry.provider.api.PatryMemberService;
import com.smart.patry.provider.api.PatryNewsService;
import com.smart.patry.provider.api.UnitRelationService;
import com.smart.patry.provider.domain.ExternalStudent;
import com.smart.patry.provider.domain.PatryApply;
import com.smart.patry.provider.domain.PatryMember;
import com.smart.patry.provider.domain.PatryNews;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
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
public class StudentController {

  @Reference(version = "1.0.0")
  private ExternalStudentService externalStudentService;

  @Reference(version = "1.0.0")
  private PatryApplyService patryApplyService;

  @Reference(version = "1.0.0")
  private PatryNewsService patryNewsService;

  @Reference(version = "1.0.0")
  private PatryMemberService patryMemberService;

  @Reference(version = "1.0.0")
  private UnitRelationService unitRelationService;

  @Resource private BCryptPasswordEncoder passwordEncoder;
  /**
   * 获取个人信息
   *
   * @param username {@code String} 用户名
   * @return {@link ResponseResult}
   */
  @GetMapping(value = "info/{username}")
  public ResponseResult<StudentInfo> info(@PathVariable String username) {
    ExternalStudent externalStudent = externalStudentService.get(username);
    StudentInfo dto = new StudentInfo();
    //        (资源，目标）
    BeanUtils.copyProperties(externalStudent, dto);
    return new ResponseResult<StudentInfo>(CodeStatus.OK, "获取个人信息", dto);
  }
  /**
   * 获取个人信息
   *
   * @param username {@code String} 用户名
   * @return {@link ResponseResult}
   */
  @GetMapping(value = "profile/{username}")
  public ResponseResult<StudentProfile> profile(@PathVariable String username) {
    ExternalStudent externalStudent = externalStudentService.get(username);
    StudentProfile dto = new StudentProfile();
    //        (资源，目标）
    BeanUtils.copyProperties(externalStudent, dto);
    PatryMember patryMember = patryMemberService.get(username);
    if (patryMember != null) {
      BeanUtils.copyProperties(patryMember, dto);
    }
    return new ResponseResult<StudentProfile>(CodeStatus.OK, "获取个人信息", dto);
  }

  @GetMapping(value = "acquireUnitData")
  public ResponseResult<List<String>> acquireUnitData() {
    List<String> stringList = unitRelationService.acquireUnitData();
    return new ResponseResult<List<String>>(CodeStatus.OK, "获取个人信息", stringList);
  }
}
