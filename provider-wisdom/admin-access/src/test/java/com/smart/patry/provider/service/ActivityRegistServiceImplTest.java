//package com.smart.patry.provider.service;
//
//import com.github.pagehelper.PageInfo;
//import com.smart.patry.provider.domain.ActivityRegist;
//import com.smart.patry.provider.mapper.ActivityRegistMapper;
//import org.apache.ibatis.session.RowBounds;
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import tk.mybatis.mapper.entity.Example;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
//* ActivityRegistServiceImpl Tester.
//*
//* @author <JIMILI>
//* @since <pre>5�� 29, 2020</pre>
//* @version 1.0
//*/
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Rollback(false)
//public class ActivityRegistServiceImplTest {
//    @Resource
//    private ActivityRegistMapper activityRegistMapper;
///**
//*
//* Method: insert(ActivityRegist activityRegist)
//*
//*/
//@Test
//public void testInsert() throws Exception {
////TODO: Test goes here...
//}
//
///**
//*
//* Method: getByUsernameAndActivityId(String actRegistUsername, String actRegistActivityid)
//*
//*/
//@Test
//public void testGetByUsernameAndActivityId() throws Exception {
////TODO: Test goes here...
//}
//
///**
//*
//* Method: getActRegistList(PageParam pageParam, List<String> stringList)
//*
//*/
//@Test
//public void testGetActRegistList() throws Exception {
//    Example example = new Example(ActivityRegist.class); // 实例化
//
//    Example.Criteria criteria1 = example.createCriteria();
//    Example.Criteria criteria2 = example.createCriteria();
//    // 党支部
////    if (pageParam.getSort().equals("+id")) {
////        example.orderBy("actRegistId").asc();
////    } else {
////        example.orderBy("actRegistId").desc();
////    }
////    if (stringList.size() > 0) {
////        for (String item : stringList) {
////            criteria1.orEqualTo("actRegistUnit", item);
////        }
////        criteria1.orEqualTo("actRegistUnit", pageParam.getUnit());
////        criteria1.orEqualTo("actRegistUnit", "");
////    }
////
////    if (pageParam.getTitle() != "") {
////        criteria2.andLike("actRegistTheme", "%" + pageParam.getTitle() + "%");
////    }
////    if (pageParam.getApplicantName() != "") {
////        criteria2.andLike("actRegistName", "%" + pageParam.getApplicantName() + "%");
////    }
////    example.and(criteria2);
////
////    List<ActivityRegist> activityRegistList = activityRegistMapper.selectByExample(example);
////
////    List<ActivityRegist> activityRegists =
////            activityRegistMapper.selectByExampleAndRowBounds(
////                    example,
////                    new RowBounds((pageParam.getPage() - 1) * pageParam.getLimit(), pageParam.getLimit()));
////    PageInfo<ActivityRegist> pageInfo = new PageInfo<ActivityRegist>(activityRegists);
////    pageInfo.setTotal(activityRegistList.size());
//}
//
///**
//*
//* Method: delete(List<ActivityRegist> activityRegistList)
//*
//*/
//@Test
//public void testDelete() throws Exception {
////TODO: Test goes here...
//    var sr ="hhh";(api.getResult() sr)
//    assert(sr.Type==string)
//            assert (sr.Value="hhh")通过
//
//}
//
//
///**
//*
//* Method: init(ActivityRegist activityRegist)
//*
//*/
//@Test
//public void testInit() throws Exception {
////TODO: Test goes here...
///*
//try {
//   Method method = ActivityRegistServiceImpl.getClass().getMethod("init", ActivityRegist.class);
//   method.setAccessible(true);
//   method.invoke(<Object>, <Parameters>);
//} catch(NoSuchMethodException e) {
//} catch(IllegalAccessException e) {
//} catch(InvocationTargetException e) {
//}
//*/
//}
//
//}
