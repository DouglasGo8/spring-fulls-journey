package com.apress.springfulls.journey.recipes.sequence.config;

import com.apress.springfulls.journey.recipes.sequence.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SequenceConfiguration {
  @Bean
  public Sequence sequence() {
    var sequence = new Sequence();
    sequence.setPrefix("30");
    sequence.setSuffix("A");
    sequence.setInitial(100_000);
    return sequence;
  }

}
