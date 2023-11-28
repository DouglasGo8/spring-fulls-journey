package com.apress.springfulls.journey.procore.chapter04.config;

import com.apress.springfulls.journey.procore.chapter04.initmethod.Singer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingerConfiguration {

  @Bean(initMethod = "init")
  Singer singerOne() {
    Singer singer = new Singer();
    singer.setName("John Mayer");
    singer.setAge(43);
    return singer;
  }

  @Bean(initMethod = "init")
  Singer singerTwo() {
    Singer singer = new Singer();
    singer.setAge(42);
    return singer;
  }

  @Bean(initMethod = "init")
  Singer singerThree() {
    Singer singer = new Singer();
    singer.setName("John Butler");
    return singer;
  }
}
