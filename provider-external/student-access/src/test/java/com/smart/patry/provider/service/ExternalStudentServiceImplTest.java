package com.smart.patry.provider.service;

import com.smart.patry.provider.domain.ExternalStudent;
import com.smart.patry.provider.mapper.ExternalStudentMapper;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * ExternalStudentServiceImpl Tester.
 *
 * @author <JIMILI>
 * @since
 *     <pre>5月 11, 2020</pre>
 *
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class ExternalStudentServiceImplTest {
//  @Bean
//  public BCryptPasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }

  @Resource ExternalStudentMapper externalStudentMapper;
  @Resource private BCryptPasswordEncoder passwordEncoder;
  /** Method: get(String username) */
  @Test
  public void testGet() throws Exception {
    // TODO: Test goes here...
  }

  /** Method: insert(ExternalStudent externalStudent) */
  @Test
  public void testInsert() throws Exception {
    for (int i = 10; i < 40; i++) {

      ExternalStudent externalStudent = new ExternalStudent();
      String s = "1000" + String.valueOf(i);
      externalStudent.setUsername(s);
      externalStudent.setStudentName("刘" + String.valueOf(i));
//      externalStudent.setPassword(passwordEncoder.encode(s));
      externalStudent.setStudentSex("女");
      externalStudent.setStudentHometown("陕西省延安市");
      externalStudent.setStudentEducation("本科");
      externalStudent.setStudentHomeaddress("陕西省延安市洛川县果果镇锅锅乡");
      externalStudent.setStudentUnit("西安建筑科技大学嘻嘻与控制工程学院");
//      externalStudent.setLoginidentity("学生");
      externalStudent.setStudentEmail("923749851@qq.com");
      externalStudent.setStudentPhone("12456454861");
      externalStudentMapper.insertSelective(externalStudent);
    }
  }
}
