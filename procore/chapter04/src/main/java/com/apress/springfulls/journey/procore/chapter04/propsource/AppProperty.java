package com.apress.springfulls.journey.procore.chapter04.propsource;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter

public class AppProperty {
  @Value("${application.home}")
  private String appHome;
  @Value("${user.home}")
  private String userHome;

  @Override
  public String toString() {
    return appHome + "/" + userHome;
  }

}
