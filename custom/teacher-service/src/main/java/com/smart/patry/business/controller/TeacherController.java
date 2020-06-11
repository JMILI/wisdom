package com.smart.patry.business.controller;

import com.smart.patry.business.dto.end2front.TeacherProfile;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.provider.api.ExternalTeacherService;
import com.smart.patry.provider.domain.ExternalTeacher;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/8,20:59 @Version: @Package:
 * com.smart.patry.business.controller 注解解释：
 */
@RestController
@RequestMapping(value = "teacher")
public class TeacherController {
  @Reference(version = "1.0.0")
  private ExternalTeacherService externalTeacherService;

  @Resource private BCryptPasswordEncoder passwordEncoder;
  /**
   * 获取个人信息
   *
   * @param username {@code String} 用户名
   * @return {@link ResponseResult}
   */
  @GetMapping(value = "info/{username}")
  public ResponseResult<TeacherProfile> info(@PathVariable String username) {
    ExternalTeacher externalStudent = externalTeacherService.get(username);
    TeacherProfile dto = new TeacherProfile();
    //        (资源，目标）
    BeanUtils.copyProperties(externalStudent, dto);
    return new ResponseResult<TeacherProfile>(CodeStatus.OK, "获取个人信息", dto);
  }
}
