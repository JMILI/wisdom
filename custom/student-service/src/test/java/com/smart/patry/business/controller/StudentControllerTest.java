package com.smart.patry.business.controller; 

import com.smart.patry.business.dto.end2front.StudentProfile;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.provider.api.ExternalStudentService;
import com.smart.patry.provider.api.PatryApplyService;
import com.smart.patry.provider.api.PatryMemberService;
import com.smart.patry.provider.domain.ExternalStudent;
import com.smart.patry.provider.domain.PatryApply;
import com.smart.patry.provider.domain.PatryMember;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/** 
* StudentController Tester. 
* 
* @author <JIMILI> 
* @since <pre>5�� 19, 2020</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class StudentControllerTest {
    @Reference(version = "1.0.0")
    private PatryApplyService patryApplyService;
    @Reference(version = "1.0.0")
    private ExternalStudentService externalStudentService;
    @Reference(version = "1.0.0")
    private PatryMemberService patryMemberService;

/** 
* 
* Method: info(@PathVariable String username) 
* 
*/ 
@Test
public void testInfo() throws Exception {
    ExternalStudent externalStudent = externalStudentService.get("100000");
    StudentProfile dto = new StudentProfile();
    if (externalStudent != null) {
        BeanUtils.copyProperties(externalStudent, dto);
    }
    //        (资源，目标）

    PatryMember patryMember = patryMemberService.get("100001");
    if (patryMember != null) {
        BeanUtils.copyProperties(patryMember, dto);
    }
} 

/** 
* 
* Method: applyInfo(@PathVariable String username) 
* 
*/ 
@Test
public void testApplyInfo() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: apply(@RequestBody StudentApplyParam studentApplyParam) 
* 
*/ 
@Test
public void testApply() throws Exception { 
//TODO: Test goes here... 
} 



/** 
* 
* Method: applyDelete(@RequestBody ApplyDelete applyDelete) 
* 
*/ 
@Test
public void testApplyDelete() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findNews() 
* 
*/ 
@Test
public void testFindNews() throws Exception { 
//TODO: Test goes here... 
} 


} 
