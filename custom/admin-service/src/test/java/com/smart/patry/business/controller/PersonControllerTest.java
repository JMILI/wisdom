package com.smart.patry.business.controller;

import java.util.Date;

//import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.patry.business.dto.activity.ActivityDetailInfo;
import com.smart.patry.business.dto.activity.ActivityInfo;
import com.smart.patry.business.dto.activity.ActivityParam;
import com.smart.patry.business.dto.apply.ApplyApproveDetailInfo;
import com.smart.patry.business.dto.apply.ApplyApproveInfo;
import com.smart.patry.business.dto.apply.ApplyApproveParam;
import com.smart.patry.business.dto.apply.ApplyOverButNoEntryPeople;
import com.smart.patry.business.dto.apply.MoveUnitParam;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.provider.api.ExternalStudentService;
import com.smart.patry.provider.api.ExternalTeacherService;
import com.smart.patry.provider.api.PatryActivityService;
import com.smart.patry.provider.api.PatryAdminService;
import com.smart.patry.provider.api.PatryApplyService;
import com.smart.patry.provider.api.PatryMemberService;
import com.smart.patry.provider.domain.ExternalStudent;
import com.smart.patry.provider.domain.ExternalTeacher;
import com.smart.patry.provider.domain.PatryActivity;
import com.smart.patry.provider.domain.PatryApply;
import com.smart.patry.provider.domain.PatryMember;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * PersonController Tester.
 *
 * @author <JIMILI>
 * @since
 *     <pre>5�� 11, 2020</pre>
 *
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class PersonControllerTest {
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
  // endregion



  @Test
  public void testWatchApplyInfo() throws Exception {
    PatryApply patryApply = new PatryApply();
    ApplyApproveDetailInfo applyApproveInfo = new ApplyApproveDetailInfo();
    patryApply = patryApplyService.findByApplyId("20200509152219");
    if (patryApply != null) {
      BeanUtils.copyProperties(patryApply, applyApproveInfo);
      System.out.println(applyApproveInfo.toString());
      System.out.println("ok");
      //      return new ResponseResult<ApplyApproveDetailInfo>(CodeStatus.OK, "查询成功",
      // applyApproveInfo);
    }
    //    查找为空
    else {
      System.out.println("空");
      //      return new ResponseResult<ApplyApproveDetailInfo>(CodeStatus.FAIL, "没有信息", null);
    }
  }
  /** Method: updateApply(@RequestBody ApplyApproveParam applyApproveParam) */
  @Test
  public void testUpdateApply() throws Exception {
    ApplyApproveParam applyApproveParam = new ApplyApproveParam();
    applyApproveParam.setPatryApplyId("20200509152424");
    //      applyApproveParam.setPatryApplyName("");
    //      applyApproveParam.setPatryApplyTheme("");
    applyApproveParam.setPatryApplyPersonopinon("同意");
    applyApproveParam.setPatryApplyPersonhandler("李江米");
    applyApproveParam.setPatryApplyOtheropinion("均同意");
    applyApproveParam.setPatryApplyDenialreason("");

    PatryApply patryApply = new PatryApply();
    BeanUtils.copyProperties(applyApproveParam, patryApply);
    patryApply.setPatryApplyStatus("审核通过");
    int update = patryApplyService.update(patryApply);
    if (update > 0) {
      //          return new ResponseResult<Void>(CodeStatus.OK, "评审成功");
      System.out.println("ok");
    } else {
      //          return new ResponseResult<Void>(CodeStatus.FAIL, "评审失败，请检查网络");
      System.out.println("fail");
    }
  }

  /** Method: watchActivityApply() */
//  @Test
//  public void testWatchActivityApply() throws Exception {
//    List<PatryActivity> patryActivityList = patryActivityService.personWatch();
//    List<ActivityInfo> activityInfoList = new ArrayList<ActivityInfo>();
//    if (patryActivityList != null) {
//      for (PatryActivity item : patryActivityList) {
//        ActivityInfo activityInfo = new ActivityInfo();
//        BeanUtils.copyProperties(item, activityInfo);
//        activityInfoList.add(activityInfo);
//      }
//      System.out.println("ok");
//      //          return new ResponseResult<List<ActivityInfo>>(CodeStatus.OK, "查询成功",
//      // activityInfoList);
//    } else {
//      //          return new ResponseResult<List<ActivityInfo>>(CodeStatus.FAIL, "暂时没有活动审批");
//      System.out.println("fail");
//    }
//  }

  @Test
  public void testWatchActivityApplyInfo() throws Exception {
    ActivityDetailInfo activityDetailInfo = new ActivityDetailInfo();
    //    数据库根据id查询详细信息
    PatryActivity patryActivity = patryActivityService.findById("20200511200103");
    BeanUtils.copyProperties(patryActivity, activityDetailInfo);
  }

  /** Method: updateActivity(@RequestBody ActivityParam activityParam) */
  @Test
  public void testUpdateActivity() throws Exception {
    ActivityParam activityParam = new ActivityParam();
    activityParam.setPatryActivityId("20200511200103");
    activityParam.setPatryActivityPersonopinion("同意");
    activityParam.setPatryActivityPersonhandler("华晨宇");
    activityParam.setPatryActivityDenialreason("");

    PatryActivity patryActivity = new PatryActivity();
    BeanUtils.copyProperties(activityParam, patryActivity);
    patryActivity.setPatryActivityStatus("审核通过");
    int update = patryActivityService.update(patryActivity);
  }

  /** Method: watchActivists() */
  @Test
  public void testWatchActivists() throws Exception {
    String identity = "群众";
    String status = "审核通过";
    String theme = "申请成为积极分子";
    List<PatryApply> patryApplyList =
        patryApplyService.findByIdentityAndStatusAndTheme(identity, status, theme);
    List<ApplyOverButNoEntryPeople> applyOverButNoEntryPeopleList =
        new ArrayList<ApplyOverButNoEntryPeople>();
    if (patryApplyList != null) {
      for (PatryApply item : patryApplyList) {
        ApplyOverButNoEntryPeople applyOverButNoEntryPeople = new ApplyOverButNoEntryPeople();
        BeanUtils.copyProperties(item, applyOverButNoEntryPeople);
        applyOverButNoEntryPeopleList.add(applyOverButNoEntryPeople);
      }
      System.out.println("ok");
      //          return new ResponseResult<List<ApplyOverButNoEntryPeople>>(
      //                  CodeStatus.OK, "查询成功", applyOverButNoEntryPeopleList);
    } else {
      System.out.println("fail");
      //          return new ResponseResult<List<ApplyOverButNoEntryPeople>>(CodeStatus.FAIL,
      // "暂时没有积极分子待录入");
    }
  }

  /** Method: insertActivistsEntryAll() */
  @Test
  public void testInsertActivistsEntryAll() throws Exception {
    //    身份是群众，且审核通过,主题是积极分子申请
    //    申请订单中查找
    List<PatryApply> patryApplyList =
            patryApplyService.findByIdentityAndStatusAndTheme("群众", "审核通过", "申请成为积极分子");
    if (patryApplyList != null) {
      //          遍历每一个群众申请
      for (PatryApply item : patryApplyList) {
        patryInsert(item);
      }
      //      return new ResponseResult<>(CodeStatus.OK, "积极分子录入成功");
      System.out.println("ok");
    }
    //    return new ResponseResult<>(CodeStatus.FAIL, "已经没有积极分子有待录入了");
    System.out.println("dail");
  }

  public void patryInsert(PatryApply item) {
    //      准备一个党员类，
    PatryMember patryMember = new PatryMember();
    //      申请人是学生身份
    if (item.getPatryApplyIdentity().equals("学生")) {
      //  根据学生学号username，查找其个人信息。
      ExternalStudent externalStudent = externalStudentService.get(item.getPatryApplyUsername());
      //  党员类初始化数据
      //  性别
      patryMember.setPtrayMemberSex(externalStudent.getStudentSex());
      //  其他信息暂时没加
    }
    // 教师
    else {
      ExternalTeacher externalTeacher = externalTeacherService.get(item.getPatryApplyUsername());
      patryMember.setPtrayMemberSex(externalTeacher.getTeacherSex());
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
    //      插入成功
    if (insert > 0) {
      //      申请表删除
      patryApplyService.delete(item.getPatryApplyId());
    }
  }
  // endregion

  /** Method: patryInsert(PatryApply item) */
  @Test
  public void testPatryInsert() throws Exception {
    // TODO: Test goes here...
  }

  /**
   * Method: insertActivistsEntryOne(@RequestParam(value = "patryApplyUsername", required = false)
   * String patryApplyUsername)
   */
  @Test
  public void testInsertActivistsEntryOne() throws Exception {
    // TODO: Test goes here...
  }

  /** Method: watchProbationaryMember() */
  @Test
  public void testWatchProbationaryMember() throws Exception {
    // TODO: Test goes here...
  }

  /** Method: updateProbationaryMemberEntryAll() */
  @Test
  public void testUpdateProbationaryMemberEntryAll() throws Exception {
    // TODO: Test goes here...
  }

  /**
   * Method: updateProbationaryMemberEntryOne(@RequestParam(value = "patryApplyUsername", required =
   * false) String patryApplyUsername)
   */
  @Test
  public void testUpdateProbationaryMemberEntryOne() throws Exception {
    // TODO: Test goes here...
  }

  /** Method: watchMoveUnit() */
  @Test
  public void testWatchMoveUnit() throws Exception {

    List<PatryApply> patryApplyList = patryApplyService.findMoveUnit();
    List<ApplyOverButNoEntryPeople> applyOverButNoEntryPeopleList =
            new ArrayList<ApplyOverButNoEntryPeople>();
    if (patryApplyList != null) {
      for (PatryApply item : patryApplyList) {
        ApplyOverButNoEntryPeople applyOverButNoEntryPeople = new ApplyOverButNoEntryPeople();
        BeanUtils.copyProperties(item, applyOverButNoEntryPeople);
        applyOverButNoEntryPeopleList.add(applyOverButNoEntryPeople);
      }
      System.out.println("ok");
//      return new ResponseResult<List<ApplyOverButNoEntryPeople>>(
//              CodeStatus.OK, "查询成功", applyOverButNoEntryPeopleList);
    } else {
      //      return new ResponseResult<List<ApplyOverButNoEntryPeople>>(
      //              CodeStatus.FAIL, "暂时没有党组织成员需要转接组织");
      System.out.println("fail");
    }
  }

  /** Method: updateMoveUnitEntryOne(@RequestBody MoveUnitParam moveUnitParam) */
  @Test
  public void testUpdateMoveUnitEntryOne() throws Exception {
    MoveUnitParam moveUnitParam = new MoveUnitParam();
    moveUnitParam.setPatryApplyUsername("100001");
    moveUnitParam.setPatryApplyPatryunit("建大");
    moveUnitParam.setTargetUnit("清华");


    PatryApply patryApply = patryApplyService.findMoveUnitByUsername(moveUnitParam.getPatryApplyUsername());
//    PatryApply patryApply = patryApplyList.get(0);
    //    没有审批订单则返回查无人
    if (patryApply == null) {
//      return new ResponseResult<Void>(CodeStatus.FAIL, "查无该人申请信息");
    }
    // 2.如果有记录，则
    //    查找党员表中有没有此人，如果有。更新组织单位，
    else {
      PatryMember patryMember = new PatryMember();
      //      设置目标单位
      patryMember.setPtrayMemberNowpatryunit(moveUnitParam.getTargetUnit());
      //      将现在的单位设置为原来单位。
      patryMember.setPtrayMemberOldpatryunit(moveUnitParam.getPatryApplyPatryunit());
//      patryMemberService.update(patryMember);
      System.out.println("ok");
//      return new ResponseResult<Void>(CodeStatus.OK, "预备党员录入成功");
    }
  }

  /** Method: patryUpdate(PatryApply patryApply) */
  @Test
  public void testPatryUpdate() throws Exception {
    // TODO: Test goes here...

  }

//  @Test
//  public void watchPatryApply() {
////    PageHelper.startPage(1,2);
//    PageInfo<PatryApply> pageInfo = patryApplyService.personWatch(1,2,"","+id");
//
//  }
}
