package com.smart.patry.business.controller; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* AdminController Tester. 
* 
* @author <JIMILI> 
* @since <pre>5�� 29, 2020</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class AdminControllerTest { 

/** 
* 
* Method: reg(@RequestBody PatryAdmin patryAdmin) 
* 
*/ 
@Test
public void testReg() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: info(@PathVariable String username) 
* 
*/ 
@Test
public void testInfo() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: update(@RequestBody ProfileParam profileParam) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: modifyPassword(@RequestBody PasswordParam passwordParam) 
* 
*/ 
@Test
public void testModifyPassword() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: acquireUnitData() 
* 
*/ 
@Test
public void testAcquireUnitData() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: fetchActRegistList(@RequestBody PageParam pageParam) 
* 
*/ 
@Test
public void testFetchActRegistList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteAllOverActRegist(@RequestBody List<ActivityRegist> activityRegistList) 
* 
*/ 
@Test
public void testDeleteAllOverActRegist() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: validateReg(String username) 
* 
*/ 
@Test
public void testValidateReg() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = AdminController.getClass().getMethod("validateReg", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
