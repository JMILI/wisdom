package com.smart.patry.provider.api;

//import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInfo;
import com.smart.patry.front.dto.PageParam;
import com.smart.patry.front.dto.PageParamByUsername;
import com.smart.patry.provider.domain.PatryApply;

import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/7,20:25 @Version: @Package:
 * com.smart.patry.provider.api 注解解释：
 */
public interface PatryApplyService {
    /**
     * 学生党内申请插入
     *
     * @param patryApply
     * @return
     */
    int insert(PatryApply patryApply);

    /**
     * 党部门审查，填写其他字段的值
     *
     * @param patryApply
     * @return
     */
    int update(PatryApply patryApply);

    /**
     * 学生取消申请,前端出入申请订单的id
     *
     * @param applyId
     * @return
     */
    int delete(String applyId);


    /**
     * 党总支根据： 1.党支部为：待审核 2.状态：审核中 三个条件都满足的条件小查找。并返回list
     *
     * @return
     */
    PageInfo<PatryApply> branchWatch(PageParamByUsername pageParamByUsername, String unit);

    /**
     * 党总支根据： 1.党支部为：同意 2.党总支：待审核 3.状态：审核中 三个条件都满足的条件小查找。并返回list
     *
     * @return
     */
    PageInfo<PatryApply> headWatch(PageParamByUsername pageParamByUsername, List<String> list);


    /**
     * 人事部根据： 1.党支部为：同意 2.党总支：同意 3.状态：审核中 三个条件都满足的条件小查找。并返回list
     *
     * @return
     */
    PageInfo<PatryApply> personWatch(PageParam pageParam);

    /**
     * 根据申请订单的单号查找详细申请信息
     *
     * @param patryApplyId
     * @return
     */
    PatryApply findByApplyId(String patryApplyId);

    /**
     * 根据 身份，审批状态，申请主题查询，
     *
     * @param identity
     * @param status
     * @param theme
     * @return List<PatryApply>
     */
    List<PatryApply> findByIdentityAndStatusAndTheme(String identity, String status, String theme);

    /**
     * 根据 使用者账号（学号，教职工号）身份，审批状态，申请主题查询，
     *
     * @param patryApplyUsername
     * @param identity
     * @param status
     * @param theme
     * @return
     */
    PatryApply findByUsernameAndIdentify(
            String patryApplyUsername, String identity, String status, String theme);

    /**
     * 身份是"非群众"， 主题是党组织关系转接申请，且申请通过
     *
     * @return
     */
    List<PatryApply> findMoveUnit();

    PatryApply findMoveUnitByUsername(String patryApplyUsername);

    /**
     * 表：apply
     * 查找：申请成为积极分子，申请成为预备党员
     * 根据人名：模糊查找，分页查找
     * @param pageParam
     * @return
     */
    PageInfo<PatryApply> personEntryWatch(PageParam pageParam);

    /**
     * 学生或教师根据自己的账号和申请订单的状态查询自己申请的进度，状态为审核中
     *
     * @param username
     * @return
     */

    List<PatryApply> findByUsername(String username);
}


