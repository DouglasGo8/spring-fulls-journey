package com.apress.springfulls.journey.procore.chapter04.destroyed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DestroyConfig {

  @Bean(/*destroyMethod = "destroyMethod"*/)
  public FileManager fileManager() {
    return new FileManager();
  }
}
