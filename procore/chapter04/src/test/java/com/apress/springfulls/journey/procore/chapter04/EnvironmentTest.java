package com.apress.springfulls.journey.procore.chapter04;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;

@Slf4j
public class EnvironmentTest {

  @Test
  public void testPropertySourceOne() {
    try (var ctx = new GenericApplicationContext()) {
      var env = ctx.getEnvironment();
      var propertySources = env.getPropertySources();

      var appMap = new HashMap<String, Object>();
      appMap.put("user.home", "CUSTOM_USER_HOME");
      propertySources.addLast(new MapPropertySource("prospring6_MAP", appMap)); // notice the addLast

      log.info("-- Env Variables  from java.lang.System --");
      log.info("user.home: {}", System.getProperty("user.home"));
      log.info("JAVA_HOME: {}", System.getenv("JAVA_HOME"));

      log.info("-- Env Variables  from ConfigurableEnvironment --");
      log.info("user.home: {}", env.getProperty("user.home"));
      log.info("JAVA_HOME: {}", env.getProperty("JAVA_HOME"));

    }

  }
}
