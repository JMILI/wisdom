package com.smart.patry.provider.service;

import javax.annotation.Resource;

import com.github.pagehelper.PageInfo;
import com.smart.patry.front.dto.PageParam;
import com.smart.patry.provider.domain.PatryMember;
import com.smart.patry.provider.mapper.PatryMemberMapper;
import com.smart.patry.provider.api.PatryMemberService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/7,15:40
 * @Version:
 * @Package: com.smart.patry.provider.service
 * 注解解释：
 */
@Service(version = "1.0.0")
public class PatryMemberServiceImpl implements PatryMemberService {

    @Resource
    private PatryMemberMapper patryMemberMapper;

    /**
     * 插入党员
     *
     * @param patryMember
     * @return
     */
    @Override
    public int insert(PatryMember patryMember) {
        return patryMemberMapper.insertSelective(patryMember);
    }

    /**
     * 更新党员信息
     * 管理员可以修改：身份，组织关系
     * 根据主键更新
     *
     * @param patryMember
     * @return
     */
    @Override
    public int update(PatryMember patryMember) {
        return patryMemberMapper.updateByPrimaryKeySelective(patryMember);
    }

    /**
     * 根据学生 学工号，或教师的教职工号查询
     *
     * @param patryApplyUsername
     * @return
     */
    @Override
    public PatryMember get(String patryApplyUsername) {
        Example example = new Example(PatryMember.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("patryMemberUsername", patryApplyUsername);
        PatryMember patryMember = null;
        List<PatryMember> patryMemberList = patryMemberMapper.selectByExample(example);

        if (patryMemberList.size() == 0) {
            return null;
        } else {
            return patryMemberList.get(0);
        }
    }

    /**
     * 查找所有预备党员
     *
     * @param pageParam
     * @return
     */
    @Override
    public PageInfo<PatryMember> personProbationaryWatch(PageParam pageParam) {
        Example example = new Example(PatryMember.class);
        Example.Criteria criteria1 = example.createCriteria();
        Example.Criteria criteria2 = example.createCriteria();
        //    党支部
        if (pageParam.getSort().equals("+id")) {
            example.orderBy("patryMemberId").asc();
        } else {
            example.orderBy("patryMemberId").desc();
        }

        criteria1.andEqualTo("ptrayMemberIdentity", "预备党员");
        if (pageParam.getApplicantName() != null && pageParam.getApplicantName() != "") {
            criteria2.andLike("ptrayMemberName", "%" + pageParam.getApplicantName() + "%");
        }
        List<PatryMember> patryMemberList = patryMemberMapper.selectByExample(example);
        example.and(criteria2);
        List<PatryMember> patryMembers =
                patryMemberMapper.selectByExampleAndRowBounds(
                        example,
                        new RowBounds((pageParam.getPage() - 1) * pageParam.getLimit(), pageParam.getLimit()));
        PageInfo<PatryMember> pageInfo = new PageInfo<PatryMember>(patryMembers);
        pageInfo.setTotal(patryMemberList.size());
        return pageInfo;
    }
}




