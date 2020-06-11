package com.smart.patry.business.controller;

import com.smart.patry.business.dto.end2front.StudentProfile;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.provider.api.ExternalStudentService;
import com.smart.patry.provider.api.PatryApplyService;
import com.smart.patry.provider.api.PatryMemberService;
import com.smart.patry.provider.api.PatryNewsService;
import com.smart.patry.provider.domain.ExternalStudent;
import com.smart.patry.provider.domain.PatryNews;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class NewsController {


  @Reference(version = "1.0.0")
  private PatryNewsService patryNewsService;



  /**
   * 根据公告表中的公告状态获取公告 这里还有疑问
   *
   * @return
   */
  @GetMapping(value = "findNews")
  public ResponseResult<List<PatryNews>> findNews() {
    List<PatryNews> patryNewsList = patryNewsService.findNews();
    return new ResponseResult<List<PatryNews>>(CodeStatus.OK, "查询成功", patryNewsList);
  }
}
