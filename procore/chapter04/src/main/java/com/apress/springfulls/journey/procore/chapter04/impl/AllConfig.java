package com.apress.springfulls.journey.procore.chapter04.impl;


import com.apress.springfulls.journey.procore.chapter04.advconfig.MessageProvider;
import com.apress.springfulls.journey.procore.chapter04.advconfig.MessageRenderer;
import com.apress.springfulls.journey.procore.chapter04.impl.provider.ConfigurableMessageProvider;
import com.apress.springfulls.journey.procore.chapter04.impl.renderer.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AllConfig {

  @Bean
  @Profile("dev")
  MessageProvider messageProvider() {
    return new ConfigurableMessageProvider("Text Sample");
  }

  @Bean
  MessageRenderer messageRenderer() {
    var msgRenderer = new StandardOutMessageRenderer();
    msgRenderer.setMessageProvider(this.messageProvider());
    return msgRenderer;
  }
}
