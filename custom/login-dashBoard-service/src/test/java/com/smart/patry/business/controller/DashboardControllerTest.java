package com.smart.patry.business.controller; 

import com.smart.patry.business.feign.dto.NewsList;
import com.smart.patry.provider.api.PatryNewsService;
import com.smart.patry.provider.api.StudyHrefService;
import com.smart.patry.provider.domain.PatryNews;
import com.smart.patry.provider.domain.StudyHref;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/** 
* DashboardController Tester. 
* 
* @author <JIMILI> 
* @since <pre>5�� 28, 2020</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class DashboardControllerTest {
    @Reference(version = "1.0.0")
    private PatryNewsService patryNewsService;
    @Reference(version = "1.0.0")
    private StudyHrefService studyHrefService;
/** 
* 
* Method: fetchNewsList() 
* 
*/ 
@Test
public void testFetchNewsList() throws Exception {
    List<PatryNews> patryNewsList = patryNewsService.findNewsNoActivity("可以");
    List<NewsList> newsListList = new ArrayList<NewsList>();

    for (PatryNews item : patryNewsList) {
        NewsList newsList = new NewsList();

        newsList.setTitle(item.getPatryNewsTheme());
        newsList.setContent(item.getPatryNewsContent());
//      由于News表字段没有外链，所以设置为空
        newsList.setHref("");
        newsList.setIsActivity(item.getPatryNewsActivity());
        newsList.setTime(item.getPatryNewsTime());
        newsListList.add(newsList);
    }

    List<StudyHref> studyNews = studyHrefService.findStudyNews();
    for (StudyHref item :studyNews ) {
        NewsList newsList = new NewsList();
        newsList.setTitle(item.getStudyTheme());
        newsList.setContent("");
        newsList.setHref(item.getStudyHref());
        newsList.setIsActivity("");
        newsList.setTime(item.getStudyUploadTime());
        newsListList.add(newsList);
    }
    System.out.println("ok");
}


} 
