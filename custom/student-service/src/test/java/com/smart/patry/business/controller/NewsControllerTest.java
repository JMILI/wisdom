package com.smart.patry.business.controller; 

import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.provider.domain.PatryNews;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/** 
* NewsController Tester. 
* 
* @author <JIMILI> 
* @since <pre>6�� 1, 2020</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class NewsControllerTest { 

/** 
* 
* Method: findNews() 
* 
*/ 
@Test
public void testFindNews() throws Exception {

//    List<PatryNews> patryNewsList = patryNewsService.findNews();
//    return new ResponseResult<List<PatryNews>>(CodeStatus.OK, "查询成功", patryNewsList);
} 


} 
