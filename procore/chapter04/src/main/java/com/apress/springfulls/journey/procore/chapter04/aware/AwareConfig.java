package com.apress.springfulls.journey.procore.chapter04.aware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class AwareConfig {
  @Bean
  NamedSinger johnMayer() {
    return new NamedSinger();
  }
  @Bean
  MyShutdownHookBean shutdownHookBean() {
    return new MyShutdownHookBean();
  }

}
