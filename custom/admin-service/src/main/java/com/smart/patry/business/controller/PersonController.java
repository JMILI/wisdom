package com.smart.patry.business.controller;

// import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInfo;
import com.smart.patry.business.dto.activity.ActivityDetailInfo;
import com.smart.patry.business.dto.activity.ActivityInfo;
import com.smart.patry.business.dto.activity.ActivityParam;
import com.smart.patry.business.dto.apply.ApplyOverButNoEntryPeople;
import com.smart.patry.business.dto.apply.MoveUnitParam;
import com.smart.patry.business.dto.apply.SelectEntry;
import com.smart.patry.front.dto.PageParam;
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
import com.smart.patry.provider.domain.ExternalStudent;
import com.smart.patry.provider.domain.ExternalTeacher;
import com.smart.patry.provider.domain.PatryActivity;
import com.smart.patry.provider.domain.PatryApply;
import com.smart.patry.provider.domain.PatryMember;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class PersonController {
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

  // region 获取党员申请
  @PostMapping(value = "person/fetchApplyList")
  public ResponseResult<PageInfo<PatryApply>> fetchApplyList(@RequestBody PageParam pageParam) {
    PageInfo<PatryApply> pageInfo = patryApplyService.personWatch(pageParam);
    return new ResponseResult<PageInfo<PatryApply>>(CodeStatus.OK, "查询成功", pageInfo);
  }
  // endregion

  // region 党委审批 党员申请
  /**
   * 人事处审核之后修改表中，人事处需要处理的字段
   *
   * @param patryApply
   * @return
   */
  @PostMapping(value = "person/apply/update")
  public ResponseResult<Void> updateApply(@RequestBody PatryApply patryApply) {
    //    PatryApply patryApply = new PatryApply();
    //    BeanUtils.copyProperties(applyApproveParam, patryApply);
    if (patryApply.getPatryApplyPatryperiod() == "") {
      if (patryApply.getPatryApplyDenialreason() != ""
          || !patryApply.getPatryApplyPersonopinon().equals("同意")) {
        patryApply.setPatryApplyStatus("驳回");
      } else {
        patryApply.setPatryApplyStatus("审核通过");
      }
    }

    int update = patryApplyService.update(patryApply);
    if (update > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "评审成功");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "评审失败，请检查网络");
    }
  }
  // endregion

  // region 获取需要录入的积极分子 或 申请成为预备党员
  /**
   * 获取Apply 状态：审核通过，主题：申请成为积极分子，申请成为预备党员
   *
   * @param pageParam
   * @return
   */
  @PostMapping(value = "person/fetchApplyEntryList")
  public ResponseResult<PageInfo<PatryApply>> fetchApplyEntryList(
      @RequestBody PageParam pageParam) {
    PageInfo<PatryApply> pageInfo = patryApplyService.personEntryWatch(pageParam);
    return new ResponseResult<PageInfo<PatryApply>>(CodeStatus.OK, "查询成功", pageInfo);
  }

  // endregion

  // region  向党员表中写入数据前，进行初始化
  public String patryInsert(PatryApply item) {
    //      准备一个党员类，
    if (patryMemberService.get(item.getPatryApplyUsername()) != null) {
      return "党员存在";
    }

    PatryMember patryMember = new PatryMember();
    //      申请人是学生身份
    if (item.getPatryApplyIdentity().equals("学生")) {
      //  根据学生学号username，查找其个人信息。
      ExternalStudent externalStudent = externalStudentService.get(item.getPatryApplyUsername());
      //  党员类初始化数据
      //  性别
      patryMember.setPtrayMemberSex(externalStudent.getStudentSex());
      patryMember.setPatryMemberEmail(externalStudent.getStudentEmail());
      //  其他信息暂时没加
    }
    // 教师
    else {
      ExternalTeacher externalTeacher = externalTeacherService.get(item.getPatryApplyUsername());
      patryMember.setPtrayMemberSex(externalTeacher.getTeacherSex());
      patryMember.setPatryMemberEmail(externalTeacher.getTeacherEmail());
    }
    // region 党员表信息初始化
    //  学号
    patryMember.setPatryMemberUsername(item.getPatryApplyUsername());
    //  姓名
    patryMember.setPtrayMemberName(item.getPatryApplyName());
    //  身份：由群众转为积极分子，群众身份的不录入党员表
    patryMember.setPtrayMemberIdentity("积极分子");
    //  党期
    patryMember.setPtrayMemberPeriod(item.getPatryApplyPatryperiod());
    patryMember.setPtrayMemberWorkunit(item.getPatryApplyWorkunit());
    //  第一次以入党积极分子的身份，没有原来所在的党组织单位。设置为空
    patryMember.setPtrayMemberOldpatryunit("");
    //  积极分子所属单位
    patryMember.setPtrayMemberNowpatryunit(item.getPatryApplyPatryunit());
    //  个人电话
    patryMember.setPtrayMemberCall(item.getPatryApplyCall());
    // endregion
    //      党员表插入
    int insert = patryMemberService.insert(patryMember);
    //          插入成功
    if (insert > 0) {
      //      申请表删除
      item.setPatryApplyStatus("已录入");
      patryApplyService.update(item);
      //          patryApplyService.delete(item.getPatryApplyId());
    }
    return "录入成功";
  }
  // endregion

  // region 前端点击单个积极分子录入
  /**
   * 根据条件： 传入的学生id和其身份是群众的条件查询，随后插入到党员表中。 并随时删除申请表中的数据，防止下次重新查找到
   *
   * @param patryApply
   * @return
   */
  @PostMapping(value = "person/entryOnePatryMember")
  public ResponseResult<Void> entryOnePatryMember(@RequestBody PatryApply patryApply) {
    //    根据username和身份是群众，且，审核通过，且申请主题为积极分子申请。
    //    查找到申请表中的相关信息
    if (patryApply != null) {
      String message = patryInsert(patryApply);
      if (message == "党员存在") {
        return new ResponseResult<Void>(CodeStatus.OK, "积极分子录入成功");
      }
    }
      return new ResponseResult<Void>(CodeStatus.FAIL, "录入失败");
  }
  // endregion

  // region 全部录入
  /**
   * 根据条件： 身份是群众，且审核通过的申请订单中查找，随后向党员表中插入所有满足条件的数据 并随时删除申请表中的数据，防止下次重新查找到
   *
   * @return
   */
@PostMapping(value = "person/entryAllPatryMember")
public ResponseResult<Void> entryAllPatryMember(@RequestBody SelectEntry selectEntry) {
  //    身份是群众，且审核通过,主题是积极分子申请
  //    申请订单中查找

  if (selectEntry.getList() != null) {
    //          遍历每一个群众申请
    for (PatryApply item : selectEntry.getList()) {
      item.setPatryApplyPatryperiod(selectEntry.getPatryApplyPatryperiod());
      patryInsert(item);
    }
    return new ResponseResult<>(CodeStatus.OK, "积极分子录入成功");
  }
  return new ResponseResult<>(CodeStatus.FAIL, "已经没有积极分子有待录入了");
}
  // endregion

  // region 预备党员录入

  // region 全部录入
  /**
   * 根据条件： 身份是积极分子，且审核通过的申请订单中查找，随后向党员表中修改所有满足条件的数据 并随时删除申请表中的数据，防止下次重新查找到
   *
   * @return
   */
  @PostMapping(value = "person/entryAllProbationaryMember")
  public ResponseResult<Void> entryAllProbationaryMember(@RequestBody SelectEntry selectEntry) {
//    List<PatryApply> patryApplyList =
//            patryApplyService.findByIdentityAndStatusAndTheme("积极分子", "审核通过", "申请成为预备党员");
    if (selectEntry.getList() != null) {
      for (PatryApply patryApply : selectEntry.getList()) {
        patryUpdate(patryApply);
      }
      return new ResponseResult<Void>(CodeStatus.OK, "预备党员录入成功");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "没有预备党员待录入");
    }
  }
  // endregion

  // region 当个点击录入
  /**
   * 根据条件： 传入的学生id和其身份是积极分子的条件查询，随后更新到党员表中。 并随时删除申请表中的数据，防止下次重新查找到
   *
   * @param patryApply
   * @return
   */
  @PostMapping(value = "person/entryOneProbationaryMember")
  public ResponseResult<Void> entryOneProbationaryMember(@RequestBody PatryApply patryApply){
    if (patryApply.getPatryApplyDenialreason()!=""){
      patryApply.setPatryApplyStatus("驳回");
      patryApplyService.update(patryApply);
      return new ResponseResult<Void>(CodeStatus.OK, "该申请被驳回");
    }else{
      patryUpdate(patryApply);
      return new ResponseResult<Void>(CodeStatus.OK, "预备党员录入成功");
    }
  }
  // endregion

  // region 录入之前、查询党员表中有没有此人，然后录入，最后删除申请表中的申请数据。这个类作为上面的两个的工具类
  private void patryUpdate(PatryApply patryApply) {
    //    依次更新信息
    //  1。先查询是否有此党员
    PatryMember patryMember = patryMemberService.get(patryApply.getPatryApplyUsername());
    if (patryMember != null) {
      //  2.修改党员身份：积极分子-》预备党员
      patryMember.setPtrayMemberIdentity("预备党员");
      int result = patryMemberService.update(patryMember);
      //  3.删除申请表中的申请订单
      if (result > 0) {
        patryApply.setPatryApplyStatus("已录入");
        patryApplyService.update(patryApply);
      }
    }
    //   党员表中没有此人，可能被开了
    else {
      //          删除它的申请记录
      patryApplyService.delete(patryApply.getPatryApplyId());
    }
  }
  // endregion

  // endregion

  // region 查询需要活动审批的订单【？】
  /**
   * 根据条件： 党总支，党支部均同意，但是人事部没同意，申请状态还在审核中 查找所有的活动申请 返回 List<ActivityInfo>
   *
   * @return
   */
  @PostMapping(value = "person/fetchActivityList")
  public ResponseResult<PageInfo<PatryActivity>> fetchActivityList(
      @RequestBody PageParamByUsername pageParamByUsername) {
    List<String> stringList = unitRelationService.getUnitBySuperUnit(pageParamByUsername.getUnit());
    PageInfo<PatryActivity> pageInfo =
        patryActivityService.personWatch(pageParamByUsername, stringList);
    return new ResponseResult<PageInfo<PatryActivity>>(CodeStatus.OK, "查询成功", pageInfo);
  }

  // region 数据库上传人事处评审信息
  /**
   * @param patryActivity
   * @return
   */
  @PostMapping(value = "person/updateActivity")
  public ResponseResult<Void> updateActivity(@RequestBody PatryActivity patryActivity) {

    if (patryActivity.getPatryActivityDenialreason() != ""
        || !patryActivity.getPatryActivityPersonopinion().equals("同意")) {
      patryActivity.setPatryActivityStatus("驳回");
    }
    int update = patryActivityService.update(patryActivity);
    if (update > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "评审成功");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "评审失败，请检查网络");
    }
  }
  // endregion

  // endregion




  // region 组织转接

  /**
   * 根据条件： 传入的学生id和其身份是积极分子的条件查询，随后更新到党员表中。 并随时删除申请表中的数据，防止下次重新查找到
   *
   * @param patryApply
   * @return
   */
  @PostMapping(value = "person/entryMoveUnit")
  public ResponseResult<Void> entryMoveUnit(@RequestBody PatryApply patryApply) {
    if (patryApply.getPatryApplyDenialreason()!=""){
      patryApply.setPatryApplyStatus("驳回");
      patryApplyService.update(patryApply);
      return new ResponseResult<Void>(CodeStatus.OK, "已驳回该请求");
    }
      PatryMember patryMember = patryMemberService.get(patryApply.getPatryApplyUsername());
      if (patryMember == null) {
        return new ResponseResult<Void>(CodeStatus.FAIL, "查无该人党员信息");
      } else {
        //      设置目标单位
        String tempUnit = patryMember.getPtrayMemberNowpatryunit();
        patryMember.setPtrayMemberNowpatryunit(patryApply.getPatryApplyPatryunit());
        //      将现在的单位设置为原来单位。
        patryMember.setPtrayMemberOldpatryunit(tempUnit);
        if(patryMemberService.update(patryMember)==0){
          // 操作失败，删除申请表中的记录
          return new ResponseResult<Void>(CodeStatus.FAIL, "网络不好");
        }
        patryApply.setPatryApplyStatus("已录入");
        patryApplyService.update(patryApply);
        return new ResponseResult<Void>(CodeStatus.OK, "录入成功");
      }
  }
  // endregion



















  @PostMapping(value = "person/fetchPatryMemberList")
  public ResponseResult<PageInfo<PatryMember>> fetchPatryMemberList(
          @RequestBody PageParam pageParam) {
    PageInfo<PatryMember> pageInfo =
            patryMemberService.personProbationaryWatch(pageParam);
    return new ResponseResult<PageInfo<PatryMember>>(CodeStatus.OK, "查询成功", pageInfo);
  }




  // region 前端点击,将单个预备党员转正为：正式党员
  /**
   * 前端点击,将单个预备党员转正为：正式党员
   * @param patryMember
   * @return
   */
  @PostMapping(value = "person/updateOnePatryMember")
  public ResponseResult<Void> updateOnePatryMember(@RequestBody PatryMember patryMember) {
    if (patryMember != null) {
      patryMember.setPtrayMemberIdentity("党员");
      if (patryMemberService.update(patryMember) >0) {
        return new ResponseResult<Void>(CodeStatus.OK, "预备党员转正成功");
      }
    }
    return new ResponseResult<Void>(CodeStatus.FAIL, "转正失败");
  }
  // endregion

  // region 全部录入,预备党员转正
  /**
   *
   *
   * @return
   */
  @PostMapping(value = "person/updateAllPatryMember")
  public ResponseResult<Void> updateAllPatryMember(@RequestBody List<PatryMember> patryMemberList) {
    //    身份是群众，且审核通过,主题是积极分子申请
    //    申请订单中查找

    if (patryMemberList.size()>0) {
      //          遍历每一个群众申请
      for (PatryMember item : patryMemberList) {
        item.setPtrayMemberIdentity("党员");
        patryMemberService.update(item);
      }
      return new ResponseResult<>(CodeStatus.OK, "预备党员转正成功");
    }
    return new ResponseResult<>(CodeStatus.FAIL, "没有需要转正的");
  }
  // endregion



  @PostMapping(value = "person/entryExternalPatryMember")
  public ResponseResult<Void> entryExternalPatryMember(@RequestBody List<PatryMember> patryMemberList) {
    //    身份是群众，且审核通过,主题是积极分子申请
    //    申请订单中查找

    if (patryMemberList.size()>0) {
      //          遍历每一个群众申请
      for (PatryMember item : patryMemberList) {
//        item.setPatryApplyPatryperiod(selectEntry.getPatryApplyPatryperiod());
        PatryMember patryMember = patryMemberService.get(item.getPatryMemberUsername());
        if (patryMember==null){
          try{
            patryMemberService.insert(item);
          }catch (Exception e){
            return new ResponseResult<>(CodeStatus.FAIL, "请检查表头是否正确?");
          }

        }
//       已经存在的不在添加
      }
      return new ResponseResult<>(CodeStatus.OK, "外部党员录入成功");
    }
    return new ResponseResult<>(CodeStatus.FAIL, "已经没有积极分子有待录入了");
  }
}
