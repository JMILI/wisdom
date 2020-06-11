package com.smart.patry.provider.service;

import com.smart.patry.provider.domain.ExternalTeacher;
import com.smart.patry.provider.mapper.ExternalTeacherMapper;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ExternalTeacherServiceImpl Tester.
 *
 * @author <JIMILI>
 * @since
 *     <pre>5�� 7, 2020</pre>
 *
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback
public class ExternalTeacherServiceImplTest {
  @Resource private ExternalTeacherMapper externalTeacherMapper;
  @Resource private BCryptPasswordEncoder passwordEncoder;
  /** Method: get(String username) */
  @Test
  public void testGet() throws Exception {
    // TODO: Test goes here...
    System.out.println(externalTeacherMapper.selectByPrimaryKey("200001"));
  }

  @Test
  public void insert() {
    for (int i = 10; i < 40; i++) {
      ExternalTeacher externalTeacher = new ExternalTeacher();
      String s = "2000" + String.valueOf(i);
      externalTeacher.setUsername(s);
      externalTeacher.setTeacherName("李" + String.valueOf(i));
//      externalTeacher.setPassword(passwordEncoder.encode(s));
      externalTeacher.setTeacherSex("男");
      externalTeacher.setTeacherHometown("陕西咸阳");
      externalTeacher.setTeacherEducation("博士");
      externalTeacher.setTeacherHomeaddress("陕西省咸阳市彬州市新民镇");
      externalTeacher.setTeacherUnit("西南建筑科技大学");
//      externalTeacher.setLoginidentity("教师");
      externalTeacher.setTeacherEmail("923456871@qq.com");
      externalTeacher.setTeacherPhone("12345678974");

      externalTeacherMapper.insertSelective(externalTeacher);
    }
  }
}
