package com.smart.patry.provider.service;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.smart.patry.provider.domain.StudyHref;
import com.smart.patry.provider.mapper.StudyHrefMapper;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/** 
* StudyHrefServiceImpl Tester. 
* 
* @author <JIMILI> 
* @since <pre>5�� 28, 2020</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class StudyHrefServiceImplTest {
    @Resource
    private StudyHrefMapper studyHrefMapper;
/** 
* 
* Method: findStudyNews() 
* 
*/ 
@Test
public void testFindStudyNews() throws Exception { 
//TODO: Test goes here... 
} 

@Test
    public void insert(){
    for (int i = 0; i < 10; i++) {
        StudyHref studyHref = new StudyHref();
        Format format = new SimpleDateFormat("yyyyMMddHHmmss");
        studyHref.setStudyId(format.format(new Date()));
        studyHref.setStudyTheme("青年大学习，青年大学习，青年年大学");
        studyHref.setStudyHref("https://juejin.im/post/59097cd7a22b9d0065fb61d2");
        studyHref.setStudyUploadTime(new Date());
        studyHref.setStudyStatus("发布");
        studyHrefMapper.insert(studyHref);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

  @Test
  public void getByUnit() {
      Example example = new Example(StudyHref.class); // 实例化

      Example.Criteria criteria1 = example.createCriteria();
      //        Example.Criteria criteria2 = example.createCriteria();
      example.orderBy("studyId").desc();
          criteria1.orEqualTo("studyUploadUnit", "建筑学院党总支");

      List<StudyHref> studyHrefList = studyHrefMapper.selectByExample(example);
  }
}
