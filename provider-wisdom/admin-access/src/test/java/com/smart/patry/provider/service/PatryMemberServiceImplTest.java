package com.smart.patry.provider.service;


import com.smart.patry.provider.api.PatryAdminService;
import com.smart.patry.provider.domain.PatryMember;
import com.smart.patry.provider.mapper.PatryMemberMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: JIMILI,
 * @Data: 2020/5/20,15:57
 * @Version:
 * @Package: com.smart.patry.provider.service
 * 注解解释：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class PatryMemberServiceImplTest {

    @Resource
    private PatryMemberMapper patryMemberMapper;

  @Test
  public void get() {
      Example example = new Example(PatryMember.class);
      Example.Criteria criteria =example.createCriteria();
      criteria.andEqualTo("patryMemberUsername","100000");
      List<PatryMember> patryMemberList= patryMemberMapper.selectByExample(example);
//      if (patryMemberList == null) {
//          return null;
//      }else{
//          return patryMemberList.get(0);
//      }
      for (PatryMember i :patryMemberList ) {
      System.out.println(i);
      }
  }
}
