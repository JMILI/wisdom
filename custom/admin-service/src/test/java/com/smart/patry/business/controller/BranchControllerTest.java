package com.smart.patry.business.controller;

import com.github.pagehelper.PageInfo;
import com.smart.patry.provider.api.ExternalStudentService;
import com.smart.patry.provider.api.ExternalTeacherService;
import com.smart.patry.provider.api.PatryActivityService;
import com.smart.patry.provider.api.PatryAdminService;
import com.smart.patry.provider.api.PatryApplyService;
import com.smart.patry.provider.api.PatryMemberService;
import com.smart.patry.provider.domain.PatryApply;
import org.apache.dubbo.config.annotation.Reference;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/23,3:03
 * @Version:
 * @Package: com.smart.patry.business.controller
 * 注解解释：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class BranchControllerTest {

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
  @Test
  public void watchPatryApply() {
//      String unit = patryAdminService.get("300005").getPatryAdminUnit();
//      PageInfo<PatryApply> pageInfo = patryApplyService.branchWatch(pageParamByUsername,unit);

  }

  @Test
  public void updateApply() {}
}
