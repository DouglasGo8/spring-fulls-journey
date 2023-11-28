package com.apress.springfulls.journey.procore.chapter04.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MessageDigestConfig {

  @Bean
  public MessageDigestFactoryBean shaDigest() {
    var shaDigest = new MessageDigestFactoryBean();
    shaDigest.setAlgorithmName("SHA1");
    return shaDigest;
  }

  @Bean
  public MessageDigestFactoryBean defaultDigest() {
    return new MessageDigestFactoryBean();
  }

  @Bean
  public MessageDigester digester() {
    var msgDigester = new MessageDigester();
    msgDigester.setDigest1(shaDigest().getObject());
    msgDigester.setDigest2(defaultDigest().getObject());
    return msgDigester;
  }
}
