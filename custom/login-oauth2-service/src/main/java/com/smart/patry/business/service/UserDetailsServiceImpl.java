package com.smart.patry.business.service;

import com.google.common.collect.Lists;
import com.smart.patry.business.dto.front2end.LoginParam;
import com.smart.patry.provider.api.AccountService;
import com.smart.patry.provider.api.ExternalStudentService;
import com.smart.patry.provider.api.ExternalTeacherService;
import com.smart.patry.provider.api.PatryAdminService;
import com.smart.patry.provider.domain.Account;
import com.smart.patry.provider.domain.ExternalStudent;
import com.smart.patry.provider.domain.ExternalTeacher;
import com.smart.patry.provider.domain.PatryAdmin;
import com.sun.org.apache.xpath.internal.objects.XObject;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/4/28,15:43 @Version: @Package:
 * com.smart.patry.business.service 注解解释：
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
  @Reference(version = "1.0.0")
  private PatryAdminService patryAdminService;

  @Reference(version = "1.0.0")
  private ExternalTeacherService externalTeacherService;

  @Reference(version = "1.0.0")
  private ExternalStudentService externalStudentService;
  @Reference(version = "1.0.0")
  private AccountService accountService;
  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

    // 查询用户
    PatryAdmin patryAdmin = patryAdminService.get(s);
    Account account = accountService.get(s);
//    ExternalTeacher externalTeacher = externalTeacherService.get(s);
//    ExternalStudent externalStudent = externalStudentService.get(s);
    // 查看是不是党委部门人员登录
    if (patryAdmin != null) {
      // 默认所有用户拥有 USER 权限
      List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
      GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ADMIN");
      grantedAuthorities.add(grantedAuthority);
      return new User(patryAdmin.getUsername(), patryAdmin.getPassword(), grantedAuthorities);
    }
//    // 查看是不是教师登录
//    else if (externalTeacher != null) {
//      // 默认所有用户拥有 USER 权限
//      List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
//      GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("TEACHER");
//      grantedAuthorities.add(grantedAuthority);
//      return new User(
//          externalTeacher.getUsername(), externalTeacher.getPassword(), grantedAuthorities);
//    }
    //    查看是不是学生登录
    else if (account != null) {
      List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
      GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
      grantedAuthorities.add(grantedAuthority);
      return new User(
              account.getUsername(), account.getPassword(), grantedAuthorities);
    } else {
      return null;
    }
  }


}
