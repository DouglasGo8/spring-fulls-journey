package com.apress.springfulls.journey.procore.chapter04.full;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiInitConfiguration {

  @Bean
  Dependency dependency() {
    return new Dependency();
  }

  @Bean(initMethod = "initMe")
  MultiInit multiInitBean() {
    return new MultiInit();
  }
}
