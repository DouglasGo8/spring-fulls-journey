package com.apress.springfulls.journey.procore.chapter04.impl.provider;

import com.apress.springfulls.journey.procore.chapter04.advconfig.MessageProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigurableMessageProvider implements MessageProvider {
  private final String message;

  public ConfigurableMessageProvider(@Value("Text Sample") String message) {
    this.message = message;
  }


  @Override
  public String message() {
    return this.message;
  }
}
