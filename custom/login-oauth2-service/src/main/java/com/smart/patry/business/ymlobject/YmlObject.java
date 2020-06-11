package com.smart.patry.business.ymlobject;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Description: @Author: JIMILI, @Data: 2020/5/7,23:37 @Version: @Package:
 * com.smart.patry.business.ymlobject 注解解释：
 */
@Data
@Component
public class YmlObject implements Serializable {
  private static final long serialVersionUID = 3292420702443973175L;
@Value("${business.tokenUrl}")
  private String tokenUrl;

  @Value("${business.oauth2GrantType}")
  public String oauth2GrantType;

  @Value("${business.oauth2ClientId}")
  public String oauth2ClientId;

  @Value("${business.oauth2ClientSecret}")
  public String oauth2ClientSecret;

  @Value("${business.headIdentity}")
  public String headIdentity;

  @Value("${business.personIdentity}")
  public String personIdentity;

  @Value("${business.branchIdentity}")
  public String branchIdentity;

  @Value("${business.studentIdentity}")
  public String studentIdentity;

  @Value("${business.teacherIdentity}")
  public String teacherIdentity;

}
