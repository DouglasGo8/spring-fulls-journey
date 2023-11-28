package com.apress.springfulls.journey.procore.chapter04.propsource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropDemoConfig {
  @Bean
  AppProperty appProperty() {
    return new AppProperty();
  }
}
