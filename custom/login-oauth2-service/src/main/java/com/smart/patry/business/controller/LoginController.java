package com.smart.patry.business.controller;

import com.google.common.collect.Maps;
import com.smart.patry.business.BusinessException;
import com.smart.patry.business.BusinessStatus;
import com.smart.patry.business.dto.end2front.LoginInfo;
import com.smart.patry.business.dto.front2end.LoginParam;
import com.smart.patry.business.feign.AdminFeign;
import com.smart.patry.business.feign.StudentFeign;
import com.smart.patry.business.feign.TeacherFeign;
import com.smart.patry.business.ymlobject.YmlObject;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.commons.utils.MapperUtils;
import com.smart.patry.commons.utils.OkHttpClientUtil;
import com.smart.patry.provider.api.AccountService;
import com.smart.patry.provider.api.ExternalStudentService;
import com.smart.patry.provider.api.ExternalTeacherService;
import com.smart.patry.provider.api.PatryAdminService;
import com.smart.patry.provider.api.PatryNewsService;
import com.smart.patry.provider.api.StudyHrefService;
import com.smart.patry.provider.domain.Account;
import com.smart.patry.provider.domain.ExternalStudent;
import com.smart.patry.provider.domain.ExternalTeacher;
import com.smart.patry.provider.domain.PatryAdmin;
import com.smart.patry.provider.domain.PatryNews;
import com.smart.patry.provider.domain.StudyHref;
import okhttp3.Response;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: @Author: JIMILI, @Data: 2020/4/26,19:20 @Version: @Package:
 * com.smart.patry.business.controller 注解解释：
 */
@RestController
public class LoginController {

  @Resource(name = "userDetailsServiceBean")
  public UserDetailsService userDetailsService;

  @Resource public BCryptPasswordEncoder passwordEncoder;
  @Autowired public YmlObject ymlObject;
  @Resource public TokenStore tokenStore;
  @Resource private AdminFeign adminProfile;
  @Resource private TeacherFeign teacherFeign;
  @Resource private StudentFeign studentFeign;

  @Reference(version = "1.0.0")
  private PatryAdminService patryAdminService;

  @Reference(version = "1.0.0")
  private ExternalTeacherService externalTeacherService;

  @Reference(version = "1.0.0")
  private ExternalStudentService externalStudentService;

  @Reference(version = "1.0.0")
  private AccountService accountService;

  @Reference(version = "1.0.0")
  private PatryNewsService patryNewsService;

  @Reference(version = "1.0.0")
  private StudyHrefService studyHrefService;
  /**
   * 登录
   *
   * @param loginParam 登录参数
   * @return {@link ResponseResult}
   */
  @PostMapping(value = "/user/login")
  public ResponseResult<Map<String, Object>> login(
      @RequestBody LoginParam loginParam, HttpServletRequest request) throws Exception {
    Map<String, Object> result = Maps.newHashMap();

    //    授权
    UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
    // 验证密码是否正确
    if (userDetails == null
        || !passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
      //            1.这里需要添加异常处理
      throw new BusinessException(BusinessStatus.ADMIN_PASSWORD);
    }

    // 通过 HTTP 客户端请求登录接口
    Map<String, String> params = Maps.newHashMap();
    params.put("username", loginParam.getUsername());
    params.put("password", loginParam.getPassword());
    params.put("grant_type", ymlObject.getOauth2GrantType());
    params.put("client_id", ymlObject.getOauth2ClientId());
    params.put("client_secret", ymlObject.getOauth2ClientSecret());

    try {
      // 解析响应结果封装并返回
      //         //这里需要添加Okhttp3的
      //      请求令牌并封装响应体
      Response response = OkHttpClientUtil.getInstance().postData(ymlObject.getTokenUrl(), params);

      String jsonString = Objects.requireNonNull(response.body()).string();
      //            这里需要添加json对象转换为map对象的工具类
      Map<String, Object> jsonMap = MapperUtils.json2map(jsonString);
      String token = String.valueOf(jsonMap.get("access_token"));
      result.put("token", token);
      System.out.println(token);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseResult<Map<String, Object>>(CodeStatus.OK, "登录成功", result);
  }

  @PostMapping(value = "/user/register")
  public ResponseResult<Map<String, Object>> register(
      @RequestBody LoginParam loginParam, HttpServletRequest request) throws Exception {
    Map<String, Object> result = Maps.newHashMap();
    PatryAdmin patryAdmin = patryAdminService.get(loginParam.getUsername());
    Account account = accountService.get(loginParam.getUsername());

    // 查看有没由该账户
    if (account != null || patryAdmin != null) {
      // 账户存在
      throw new BusinessException(BusinessStatus.USER_EXIST);
    }
    //    没有
    else {
      // 增加账户
      Account account1 = new Account();
      ExternalStudent externalStudent = externalStudentService.get(loginParam.getUsername());
      ExternalTeacher externalTeacher = externalTeacherService.get(loginParam.getUsername());
      if (externalTeacher != null) {

        account1.setLoginIdentity("教师");
        account1.setAccountName(externalTeacher.getTeacherName());
      } else if (externalStudent != null) {
        account1.setLoginIdentity("学生");
        account1.setAccountName(externalStudent.getStudentName());
        System.out.println(externalStudent.getStudentName());
        System.out.println(externalStudent);
      } else {
        throw new BusinessException(BusinessStatus.NOT_USER);
      }
      account1.setUsername(loginParam.getUsername());
      account1.setPassword(loginParam.getPassword());
      int ss = accountService.insert(account1);
      if (ss == 0) {
        throw new BusinessException(BusinessStatus.FAIL);
      }
      // 增加成功，给权限
      UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
      // 验证密码是否正确
      if (userDetails == null
          || !passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
        //            1.这里需要添加异常处理
        throw new BusinessException(BusinessStatus.ADMIN_PASSWORD);
      }
    }

    // 通过 HTTP 客户端请求登录接口
    Map<String, String> params = Maps.newHashMap();
    params.put("username", loginParam.getUsername());
    params.put("password", loginParam.getPassword());
    params.put("grant_type", ymlObject.getOauth2GrantType());
    params.put("client_id", ymlObject.getOauth2ClientId());
    params.put("client_secret", ymlObject.getOauth2ClientSecret());

    try {
      // 解析响应结果封装并返回
      //         //这里需要添加Okhttp3的
      //      请求令牌并封装响应体
      Response response = OkHttpClientUtil.getInstance().postData(ymlObject.getTokenUrl(), params);
      String jsonString = Objects.requireNonNull(response.body()).string();
      //    这里需要添加json对象转换为map对象的工具类
      Map<String, Object> jsonMap = MapperUtils.json2map(jsonString);
      String token = String.valueOf(jsonMap.get("access_token"));
      result.put("token", token);
      System.out.println(token);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseResult<Map<String, Object>>(CodeStatus.OK, "注册成功", result);
  }

  @PreAuthorize("hasAuthority('ADMIN')or hasAuthority('USER')")
  @GetMapping(value = "/user/info")
  public ResponseResult<LoginInfo> info() throws Exception {
    // 获取认证信息
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    PatryAdmin patryAdmin = patryAdminService.get(authentication.getName());
    LoginInfo loginInfo = new LoginInfo();
    if (patryAdmin != null) {
      loginInfo.setUsername(patryAdmin.getUsername());
      loginInfo.setName(patryAdmin.getPatryAdminName());
      loginInfo.setLoginIdentity(patryAdmin.getLoginIdentity());
      loginInfo.setLoginUnit(patryAdmin.getLoginUnit());
      return new ResponseResult<LoginInfo>(CodeStatus.OK, "获取用户信息成功", loginInfo);
    } else {
      Account account = accountService.get(authentication.getName());
      if (account != null) {
        loginInfo.setUsername(account.getUsername());
        loginInfo.setLoginIdentity(account.getLoginIdentity());
        loginInfo.setLoginUnit(account.getLoginUnit());

        return new ResponseResult<LoginInfo>(CodeStatus.OK, "获取用户信息成功", loginInfo);
      }
    }
    return new ResponseResult<LoginInfo>(CodeStatus.FAIL, "获取用户信息失败");
  }

  /**
   * 注销
   *
   * @return {@link ResponseResult}
   */
  @PreAuthorize("hasAuthority('ADMIN')or hasAuthority('USER')")
  @PostMapping(value = "/user/logout")
  public ResponseResult<Void> logout(HttpServletRequest request) {
    // 获取 token
    String token = request.getParameter("access_token");
    // 删除 token 以注销
    OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
    tokenStore.removeAccessToken(oAuth2AccessToken);
    return new ResponseResult<Void>(CodeStatus.OK, "用户已注销");
  }
}
