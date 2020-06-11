package com.smart.patry.provider.service;

import javax.annotation.Resource;

import com.smart.patry.provider.domain.PatryAdmin;
import com.smart.patry.provider.domain.PatryOrganization;
import com.smart.patry.provider.mapper.PatryOrganizationMapper;
import com.smart.patry.provider.api.PatryOrganizationService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/7,15:40
 * @Version:
 * @Package: com.smart.patry.provider.service
 * 注解解释：
 */
@Service(version = "1.0.0")
public class PatryOrganizationServiceImpl implements PatryOrganizationService {

    @Resource
    private PatryOrganizationMapper patryOrganizationMapper;

    /**
     * 插入部门结构数据
     *
     * @param patryOrganization
     * @return
     */
    @Override
    public int insert(PatryOrganization patryOrganization) {
        return patryOrganizationMapper.insert(patryOrganization);
    }

//    /**
//     * 根据部门查看该部门组织结构
//     * @param unit
//     * @return
//     */
//    @Override
//    public PatryOrganization findByUnit(String unit) {
//        Example example = new Example(PatryOrganization.class);
//        example.createCriteria().andEqualTo("patryOrganizationUnit", unit);
//        return patryOrganizationMapper.selectOneByExample(example);
//    }


}




