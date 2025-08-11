package com.apress.springfulls.journey.procore.chapter03.annotated;

import com.apress.springfulls.journey.procore.chapter03.configurable.ConfigurableMessageProvider;
import com.apress.springfulls.journey.procore.chapter03.renderer.HelloGalaxyMessageProvider;
import com.apress.springfulls.journey.procore.chapter03.renderer.MessageProvider;
import com.apress.springfulls.journey.procore.chapter03.renderer.MessageRenderer;
import com.apress.springfulls.journey.procore.chapter03.renderer.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfiguration {
  @Bean
  public MessageProvider provider() {
    return new HelloGalaxyMessageProvider();
  }

  @Bean
  public MessageRenderer renderer() {
    return new StandardOutMessageRenderer(this.provider());
  }

}
