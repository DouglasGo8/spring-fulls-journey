package com.apress.springfulls.journey.procore.chapter02.decoupled;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloGalaxyMessageProvider implements MessageProvider {
  @Value("${galaxy.name}")
  private String galaxyName;

  @Override
  public String getMessage() {
    return "Hello, ".concat(galaxyName);
  }
}
