package com.smart.patry.business.controller; 

import com.github.pagehelper.PageInfo;
import com.smart.patry.provider.api.UnitRelationService;
import com.smart.patry.provider.domain.PatryApply;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/** 
* HeadController Tester. 
* 
* @author <JIMILI> 
* @since <pre>5�� 26, 2020</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class HeadControllerTest {
    @Reference(version = "1.0.0")
    private UnitRelationService unitRelationService;
/** 
* 
* Method: fetchApplyList(@RequestBody PageParamByUsername pageParamByUsername) 
* 
*/ 
@Test
public void testFetchApplyList() throws Exception {

//    List<String> stringList =unitRelationService.getUnitBySuperUnit(pageParamByUsername.getUsername());
//    PageInfo<PatryApply> pageInfo =
//            patryApplyService.headWatch(pageParamByUsername, stringList);
////TODO: Test goes here...
} 

/** 
* 
* Method: updateApply(@RequestBody PatryApply patryApply) 
* 
*/ 
@Test
public void testUpdateApply() throws Exception { 
//TODO: Test goes here... 
} 


} 
