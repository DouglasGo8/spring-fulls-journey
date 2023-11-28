package com.apress.springfulls.journey.procore.chapter04.intf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingerConfiguration {
  @Bean
  Singer singerOne() {
    var singer = new Singer();
    singer.setName("John Mayer");
    singer.setAge(43);
    return singer;
  }
}
