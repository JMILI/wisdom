package com.smart.patry.business.feign.feignFallback;

import com.smart.patry.business.dto.activity.ActivityParam;
import com.smart.patry.business.dto.apply.MoveUnitParam;
import com.smart.patry.business.dto.apply.SelectEntry;
import com.smart.patry.front.dto.PageParam;
import com.smart.patry.business.feign.PersonFeign;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.commons.utils.MapperUtils;
import com.smart.patry.front.dto.PageParamByUsername;
import com.smart.patry.provider.domain.PatryActivity;
import com.smart.patry.provider.domain.PatryApply;
import com.smart.patry.provider.domain.PatryMember;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/8,23:34 @Version: @Package:
 * com.smart.patry.business.feign.feignFallback 注解解释：
 */
@Component
public class PersonFeignFallback implements PersonFeign {
  public static final String BREAKING_MESSAGE = "请求失败了，请检查您的网络";
  /**
   * 根据条件： 党总支，党支部均同意，但是人事部没同意，申请状态还在审核中 查找所有的党内申请 返回 List<applyApproveInfo>
   *
   * @return
   */
  @Override
  public String fetchApplyList(PageParam pageParam) {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 积极分子录入查询
   *
   * @param pageParam
   * @return
   */
  @Override
  public String fetchApplyEntryList(PageParam pageParam) {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


  /**
   * 人事处审核之后修改表中，人事处需要处理的字段
   *
   * @param patryApply
   * @return
   */
  @Override
  public String updateApply(PatryApply patryApply) {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


  /**
   * 获取党总支所管辖的党支部下的活动申请
   *
   * @param pageParamByUsername
   * @return
   */
  @Override
  public String fetchActivityList(PageParamByUsername pageParamByUsername) {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 审批党支部活动申请
   *
   * @param patryActivity
   * @return
   */
  @Override
  public String updateActivity(PatryActivity patryActivity) {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 根据条件： 身份是群众，且审核通过的申请订单中查找 返回 List<ApplyOverButNoEntryPeople>
   *
   * @return
   */
  @Override
  public String watchActivists() {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 根据条件： 身份是群众，且审核通过的申请订单中查找，随后向党员表中插入所有满足条件的数据 并随时删除申请表中的数据，防止下次重新查找到
   *
   * @param
   * @return
   */
  @Override
  public String entryAllPatryMember(@RequestBody SelectEntry selectEntry) {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


  /**
   * 根据条件： 传入的学生id和其身份是群众的条件查询，随后插入到党员表中。 并随时删除申请表中的数据，防止下次重新查找到
   *
   * @param patryApply
   * @return
   */
  @Override
  public String entryOnePatryMember(PatryApply patryApply) {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 根据条件： 身份是积极分子，且审核通过的申请订单中查找，随后向党员表中修改所有满足条件的数据 并随时删除申请表中的数据，防止下次重新查找到
   *
   * @param selectEntry
   * @return
   */
  @Override
  public String entryAllProbationaryMember(SelectEntry selectEntry) {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 根据条件： 传入的学生id和其身份是积极分子的条件查询，随后更新到党员表中。 并随时删除申请表中的数据，防止下次重新查找到
   *
   * @param patryApply
   * @return
   */
  @Override
  public String entryOneProbationaryMember(PatryApply patryApply) {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 根据条件： 查找所有申请表中是非群众身份且审核状态完成的。 且申请主题中包含“组织转接”字眼的进行逐一数据库修改 返回 List<ApplyOverButNoEntryPeople>
   *
   * @return
   */
  @Override
  public String watchMoveUnit() {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 根据条件： 传入的学生id和其身份是积极分子的条件查询，随后更新到党员表中。 并随时删除申请表中的数据，防止下次重新查找到
   *
   * @param moveUnitParam
   * @return
   */
  @Override
  public String updateMoveUnitEntryOne(MoveUnitParam moveUnitParam) {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 获取所有预备党员
   *
   * @param pageParam
   * @return
   */
  @Override
  public String fetchPatryMemberList(PageParam pageParam) {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 批量将预备党员转正为党员
   *
   * @param patryMemberList
   * @return
   */
  @Override
  public String updateAllPatryMember(List<PatryMember> patryMemberList) {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 单个预备党员转正
   *
   * @param patryMember
   * @return
   */
  @Override
  public String updateOnePatryMember(PatryMember patryMember) {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 批量将预备党员转正为党员
   *
   * @param patryMemberList
   * @return
   */
  @Override
  public String entryExternalPatryMember(List<PatryMember> patryMemberList) {
    try {
      return MapperUtils.obj2json(new ResponseResult<Void>(CodeStatus.BREAKING, BREAKING_MESSAGE));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
