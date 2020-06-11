package com.smart.patry.provider.service;

import com.smart.patry.provider.api.PatryNewsService;
import com.smart.patry.provider.domain.PatryNews;
import com.smart.patry.provider.mapper.PatryNewsMapper;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * PatryNewsServiceImpl Tester.
 *
 * @author <JIMILI>
 * @since
 *     <pre>5�� 9, 2020</pre>
 *
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class PatryNewsServiceImplTest {
  // @Resource
  // PatryNewsService patryNewsService;
  @Resource private PatryNewsMapper patryNewsMapper;
  /** Method: findNews() */
  @Test
  public void testFindNews() throws Exception {
    Example example = new Example(PatryNews.class);
    example.orderBy("patryNewId").desc();
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("patryNewStatus", "发布");
    List<PatryNews> patryNewsList = patryNewsMapper.selectByExample(example);
  }

  @Test
  public void insert() {
    for (int i = 0; i <10 ; i++) {
      PatryNews patryNews = new PatryNews();
      patryNews.setPatryNewsTheme("2018年秋季积极分子党员培训"+String.valueOf(i*2));
      patryNews.setPatryNewsContent("主要是积极分子的入党前培训，关于近期党委学习，学习强国，等一系列知识");
      patryNews.setPatryNewsAnnex("");

      initInsertNews(patryNews);
      patryNewsMapper.insertSelective(patryNews);
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  public void initInsertNews(PatryNews patryNews) {
    //    PatryNews patryNews = new PatryNews();
    Format format = new SimpleDateFormat("yyyyMMddHHmmss");
    patryNews.setPatryNewsId(format.format(new Date()));
    patryNews.setPatryNewsTime(new Date());
    patryNews.setPatryNewsStatus("发布");
  }

  @Test
  public void findById() {
   PatryNews patryNews= patryNewsMapper.selectByPrimaryKey("20200525130218");
  }
}
