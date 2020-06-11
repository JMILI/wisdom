package com.smart.patry.business.feign;

import com.smart.patry.business.dto.activity.ActivityParam;
import com.smart.patry.business.dto.apply.MoveUnitParam;
import com.smart.patry.business.dto.apply.SelectEntry;
import com.smart.patry.front.dto.PageParam;
import com.smart.patry.configuration.FeignRequestConfiguration;
import com.smart.patry.front.dto.PageParamByUsername;
import com.smart.patry.provider.domain.PatryActivity;
import com.smart.patry.provider.domain.PatryApply;
import com.smart.patry.provider.domain.PatryMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/8,23:33 @Version: @Package:
 * com.smart.patry.business.feign.feignFallback 注解解释：
 */
@FeignClient(
    value = "admin-management",
    path = "admin",
    configuration = FeignRequestConfiguration.class)
public interface PersonFeign {

  // region 党员申请审批

  /**
   * 根据条件： 党总支，党支部均同意，但是人事部没同意，申请状态还在审核中 查找所有的党内申请 返回 List<applyApproveInfo>
   *
   * @return
   */
  @PostMapping(value = "person/fetchApplyList")
  String fetchApplyList(@RequestBody PageParam pageParam);

  /**
   * 积极分子录入查询，或者组织转接查询
   * @param pageParam
   * @return
   */
  @PostMapping(value = "person/fetchApplyEntryList")
  String fetchApplyEntryList(@RequestBody PageParam pageParam);
  /**
   * 根据申请的id，查看申请人的申请信息，信息不可修改
   *
   * @return
   */
//  @PostMapping(value = "person/apply/watchDetailInfo")
//  String watchApplyInfo(@RequestParam(value="patryApplyId", required=false) String patryApplyId);

  /**
   * 人事处审核之后修改表中，人事处需要处理的字段
   *
   * @param patryApply
   * @return
   */
  @PostMapping(value = "person/apply/update")
  String updateApply(@RequestBody PatryApply patryApply);
  // endregion

  // region 活动申请审批
      /**
       * 根据条件： 党总支，党支部均同意，但是人事部没同意，申请状态还在审核中 查找所有的党内申请
       * 返回 List<ActivityInfo>
       *
       * @return
       */
      @PostMapping(value = "person/fetchActivityList")
      String fetchActivityList(@RequestBody PageParamByUsername pageParamByUsername);

    /**
     * 审批党支部活动申请
     * @param patryActivity
     * @return
     */
    @PostMapping(value = "person/updateActivity")
    String updateActivity(@RequestBody PatryActivity patryActivity);
 // endregion

  // region 积极分子录入
  /**
   * 根据条件： 身份是群众，且审核通过的申请订单中查找 返回 List<ApplyOverButNoEntryPeople>
   *
   * @return
   */
  @GetMapping(value = "entry/Activists/watch")
  String watchActivists();

  /**
   * 根据条件： 身份是群众，且审核通过的申请订单中查找，随后向党员表中插入所有满足条件的数据 并随时删除申请表中的数据，防止下次重新查找到
   *
   * @return
   */
//  @PostMapping(value = "person/entryAllPatryMember/{patryApplyPatryperiod}")
//  String entryAllPatryMember(@PathVariable String patryApplyPatryperiod);
  @PostMapping(value = "person/entryAllPatryMember")
  String entryAllPatryMember(@RequestBody SelectEntry selectEntry);

  /**
   * 根据条件： 传入的学生id和其身份是群众的条件查询，随后插入到党员表中。 并随时删除申请表中的数据，防止下次重新查找到
   *
   * @param patryApply
   * @return
   */
  @PostMapping(value = "person/entryOnePatryMember")
  String entryOnePatryMember(@RequestBody PatryApply patryApply);

  // endregion

  // region 预备党员录入
    /**
     * 根据条件： 身份是积极分子，且审核通过的申请订单中查找，随后向党员表中修改所有满足条件的数据 并随时删除申请表中的数据，防止下次重新查找到
     *
     * @return
     */
    @PostMapping(value = "person/entryAllProbationaryMember")
    String entryAllProbationaryMember(@RequestBody SelectEntry selectEntry);

    /**
     * 根据条件： 传入的学生id和其身份是积极分子的条件查询，随后更新到党员表中。 并随时删除申请表中的数据，防止下次重新查找到
     *
     * @param patryApply
     * @return
     */
    @PostMapping(value = "person/entryOneProbationaryMember")
    String entryOneProbationaryMember(@RequestBody PatryApply patryApply);
  // endregion

  // region 组织转接
    /**
     * 根据条件： 查找所有申请表中是非群众身份且审核状态完成的。
     * 且申请主题中包含“组织转接”字眼的进行逐一数据库修改
     * 返回 List<ApplyOverButNoEntryPeople>
     *
     * @return
     */
    @GetMapping(value = "entry/moveUnit/watch")
    String watchMoveUnit();

    /**
     * 根据条件： 传入的学生id和其身份是积极分子的条件查询，随后更新到党员表中。 并随时删除申请表中的数据，防止下次重新查找到
     *
     * @param moveUnitParam
     * @return
     */
    @PostMapping(value = "entry/moveUnit/oneUpdate")
    String updateMoveUnitEntryOne(@RequestBody MoveUnitParam moveUnitParam);
  // endregion


  /**
   * 获取所有预备党员
   * @param pageParam
   * @return
   */
  @PostMapping(value = "person/fetchPatryMemberList")
  String fetchPatryMemberList(@RequestBody PageParam pageParam);

  /**
   * 批量将预备党员转正为党员
   * @param patryMemberList
   * @return
   */
  @PostMapping(value = "person/updateAllPatryMember")
  String updateAllPatryMember(@RequestBody List<PatryMember> patryMemberList);

  /**
   * 单个预备党员转正
   *
   * @param patryMember
   * @return
   */
  @PostMapping(value = "person/updateOnePatryMember")
  String updateOnePatryMember(@RequestBody PatryMember patryMember);




  /**
   * 批量将预备党员转正为党员
   * @param patryMemberList
   * @return
   */
  @PostMapping(value = "person/entryExternalPatryMember")
  String entryExternalPatryMember(@RequestBody List<PatryMember> patryMemberList);

}
