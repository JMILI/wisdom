package com.smart.patry.business.controller;

import com.smart.patry.provider.api.PatryNewsService;
import com.smart.patry.provider.domain.PatryNews;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/26,1:29 @Version: @Package:
 * com.smart.patry.business.controller 注解解释：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {
  @Reference(version = "1.0.0")
  private PatryNewsService patryNewsService;
}
