package com.smart.patry.business.feign;

import com.smart.patry.business.dto.front2end.ApplyDelete;
import com.smart.patry.business.dto.front2end.StudentApplyParam;
import com.smart.patry.business.dto.front2end.ApplyWatch;
import com.smart.patry.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/8,17:04 @Version: @Package:
 * com.smart.patry.business.feign 注解解释：
 */
@FeignClient(
    value = "student-client",
    path = "student",
    configuration = FeignRequestConfiguration.class)
public interface StudentFeign {
  /**
   * 获取个人信息
   *
   * @param username {@code String} 用户名
   * @return {@code String} JSON
   */
  @GetMapping(value = "info/{username}")
  String info(@PathVariable String username);
  /**
   * 获取个人信息
   *
   * @param username {@code String} 用户名
   * @return {@code String} JSON
   */
  @GetMapping(value = "profile/{username}")
  String profile(@PathVariable String username);

  /**
   * 获取申请时学生的基本信息
   *
   * @param username
   * @return
   */
  //    @PostMapping(value = "applyInfo")
  //    String applyInfo(@RequestBody ApplyWatch applyWatch);
  @GetMapping(value = "applyInfo/{username}")
  String applyInfo(@PathVariable String username);
  /**
   * 学生党内申请：积极分子申请，预备党员申请，组织转接申请
   *
   * @param studentApplyParam
   * @return
   */
  @PostMapping(value = "apply/write")
  String apply(@RequestBody StudentApplyParam studentApplyParam);

  /**
   * @param username
   * @return
   */
  @GetMapping(value = "applyWatch/{username}")
  String applyWatch(@PathVariable String username);
  //    /**
  //     * 查看申请状态
  //     * @param
  //     * @return
  //     */
  //    @GetMapping(value = "applyWatch/{username}")
  //    String applyWatch(@PathVariable String username);

  /**
   * 取消申请
   *
   * @param
   * @return
   */
  @GetMapping(value = "apply/delete/{patryApplyId}")
  String applyDelete(@PathVariable String patryApplyId);

  /**
   * 根据公告表中的公告状态获取公告
   *
   * @return
   */
  @GetMapping(value = "findNews")
  String findNews();
}
