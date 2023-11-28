package com.apress.springfulls.journey.procore.chapter02.annotated;

import com.apress.springfulls.journey.procore.chapter02.decoupled.HelloGalaxyMessageProvider;
import com.apress.springfulls.journey.procore.chapter02.decoupled.MessageProvider;
import com.apress.springfulls.journey.procore.chapter02.decoupled.MessageRenderer;
import com.apress.springfulls.journey.procore.chapter02.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class HelloGalaxyConfiguration {

  @Lazy
  @Bean
  MessageProvider provider() {
    return new HelloGalaxyMessageProvider();
  }

  @Lazy
  @Bean
  MessageRenderer renderer() {
    var renderer = new StandardOutMessageRenderer();
    renderer.setMessageProvider(this.provider());
    return renderer;
  }
}
