package com.smart.patry.business.controller;

import com.smart.patry.business.feign.dto.NewsList;
import com.smart.patry.business.feign.dto.RegistActivityInfo;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import com.smart.patry.provider.api.ActivityRegistService;
import com.smart.patry.provider.api.ExternalStudentService;
import com.smart.patry.provider.api.ExternalTeacherService;
import com.smart.patry.provider.api.FileSaveService;
import com.smart.patry.provider.api.PatryNewsService;
import com.smart.patry.provider.api.StudyHrefService;
import com.smart.patry.provider.domain.ActivityRegist;
import com.smart.patry.provider.domain.ExternalStudent;
import com.smart.patry.provider.domain.ExternalTeacher;
import com.smart.patry.provider.domain.FileSave;
import com.smart.patry.provider.domain.PatryNews;
import com.smart.patry.provider.domain.StudyHref;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/8,20:59 @Version: @Package:
 * com.smart.patry.business.controller 注解解释：
 */
@RestController
@RequestMapping(value = "dashboard")
public class DashboardController {
  @Reference(version = "1.0.0")
  private PatryNewsService patryNewsService;

  @Reference(version = "1.0.0")
  private StudyHrefService studyHrefService;

  @Reference(version = "1.0.0")
  private ExternalTeacherService externalTeacherService;

  @Reference(version = "1.0.0")
  private ExternalStudentService externalStudentService;

  @Reference(version = "1.0.0")
  private ActivityRegistService activityRegistService;
  @Reference(version = "1.0.0")
  private FileSaveService fileSaveService;
  public List<NewsList> findNews(String isActivity) {
    //    findNewsNoActivity根据是否可以报名。来查找
    List<PatryNews> patryNewsList = patryNewsService.findNewsNoActivity(isActivity);
    List<NewsList> newsListList = new ArrayList<NewsList>();

    for (PatryNews item : patryNewsList) {
      NewsList newsList = new NewsList();
      newsList.setActivityId(item.getPatryNewsId());
      newsList.setTitle(item.getPatryNewsTheme());
      newsList.setContent(item.getPatryNewsContent());
      //      由于News表字段没有外链，所以设置为空
      newsList.setHref("");
      newsList.setIsActivity(item.getPatryNewsActivity());
      newsList.setTime(item.getPatryNewsTime());
      newsListList.add(newsList);
    }
    return newsListList;
  }

  @GetMapping(value = "fetchNewsList")
  public ResponseResult<List<NewsList>> fetchNewsList() throws Exception {
    List<NewsList> newsListList = findNews("不可以");
    if (newsListList.size() > 0) {
      return new ResponseResult<List<NewsList>>(CodeStatus.OK, "成功", newsListList);
    } else {
      return new ResponseResult<List<NewsList>>(CodeStatus.FAIL, "没有公告");
    }
  }

  @GetMapping(value = "fetchActivityNewsList")
  public ResponseResult<List<NewsList>> fetchActivityNewsList() throws Exception {
    List<NewsList> newsListList = findNews("可以");
    if (newsListList.size() > 0) {
      return new ResponseResult<List<NewsList>>(CodeStatus.OK, "成功", newsListList);
    } else {
      return new ResponseResult<List<NewsList>>(CodeStatus.FAIL, "没有公告");
    }
  }

  @GetMapping(value = "fetchStudyList")
  public ResponseResult<List<NewsList>> fetchStudyList() throws Exception {
    List<NewsList> newsListList = new ArrayList<NewsList>();
    List<StudyHref> studyNews = studyHrefService.findStudyNews();
    for (StudyHref item : studyNews) {
      NewsList newsList = new NewsList();
      newsList.setActivityId(item.getStudyId());
      newsList.setTitle(item.getStudyTheme());
      newsList.setContent("");
      newsList.setHref(item.getStudyHref());
      newsList.setIsActivity("");
      newsList.setTime(item.getStudyUploadTime());
      newsListList.add(newsList);
    }
    if (studyNews.size() > 0) {
      return new ResponseResult<List<NewsList>>(CodeStatus.OK, "成功", newsListList);
    } else {
      return new ResponseResult<List<NewsList>>(CodeStatus.FAIL, "没有公告");
    }
  }

  @PostMapping(value = "registActivity")
  ResponseResult<Void> registActivity(@RequestBody RegistActivityInfo registActivityInfo) {
    if (activityRegistService.getByUsernameAndActivityId(
            registActivityInfo.getActRegistUsername(), registActivityInfo.getActRegistActivityid())
        == true) {
      return new ResponseResult<Void>(CodeStatus.FAIL, "您已经报过一次名了");
    }
    int insert = 0;
    ExternalTeacher externalTeacher =
        externalTeacherService.get(registActivityInfo.getActRegistUsername());
    ExternalStudent externalStudent =
        externalStudentService.get(registActivityInfo.getActRegistUsername());
    ActivityRegist activityRegist = new ActivityRegist();
    if (externalTeacher != null) {
      activityRegist.setActRegistName(externalTeacher.getTeacherName());
      activityRegist.setActRegistSex(externalTeacher.getTeacherSex());
      activityRegist.setActRegistWorkUnit(externalTeacher.getTeacherUnit());
      activityRegist.setActRegistCall(externalTeacher.getTeacherPhone());
      activityRegist.setActRegistActivityid(registActivityInfo.getActRegistActivityid());
      activityRegist.setActRegistTheme(registActivityInfo.getActRegistTheme());
      activityRegist.setActRegistUsername(registActivityInfo.getActRegistUsername());
      activityRegist.setActRegistUnit(registActivityInfo.getActRegistUnit());
      insert = activityRegistService.insert(activityRegist);
    } else if (externalStudent != null) {
      activityRegist.setActRegistName(externalStudent.getStudentName());
      activityRegist.setActRegistSex(externalStudent.getStudentSex());
      activityRegist.setActRegistWorkUnit(externalStudent.getStudentUnit());
      activityRegist.setActRegistCall(externalStudent.getStudentPhone());
      activityRegist.setActRegistActivityid(registActivityInfo.getActRegistActivityid());
      activityRegist.setActRegistTheme(registActivityInfo.getActRegistTheme());
      activityRegist.setActRegistUsername(registActivityInfo.getActRegistUsername());
      activityRegist.setActRegistUnit(registActivityInfo.getActRegistUnit());
      insert = activityRegistService.insert(activityRegist);
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "您没有权限报名");
    }
    if (insert > 0) {
      return new ResponseResult<Void>(CodeStatus.OK, "报名成功，请等待通知");
    } else {
      return new ResponseResult<Void>(CodeStatus.FAIL, "报名失败，可能活动进行完了");
    }
  }


  @GetMapping(value = "fetchFileList")
  public ResponseResult<List<FileSave>> fetchFileList() throws Exception {
    List<FileSave> fileSaveList = fileSaveService.findFiles();
    if (fileSaveList.size() > 0) {
      return new ResponseResult<List<FileSave>>(CodeStatus.OK, "成功", fileSaveList);
    } else {
      return new ResponseResult<List<FileSave>>(CodeStatus.FAIL, "没有文件可以下载");
    }
  }

}
