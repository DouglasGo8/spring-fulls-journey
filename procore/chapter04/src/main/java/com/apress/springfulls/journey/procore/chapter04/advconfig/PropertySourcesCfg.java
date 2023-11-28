package com.apress.springfulls.journey.procore.chapter04.advconfig;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@AllArgsConstructor
@PropertySource(value = "classpath:message.properties")
//@Import()
public class PropertySourcesCfg {
  final Environment env;

  @Bean
  @Lazy
  MessageProvider messageProvider() {
    return new ConfigurableMessageProvider(env.getProperty("message"));
  }

  @Scope(value = "prototype")
  @Bean(name = "messageRenderer")
  @DependsOn(value = "messageProvider")
  MessageRenderer messageRenderer() {
    var renderer = new StandardOutMessageRenderer();
    renderer.setMessageProvider(this.messageProvider());
    return renderer;
  }

}
