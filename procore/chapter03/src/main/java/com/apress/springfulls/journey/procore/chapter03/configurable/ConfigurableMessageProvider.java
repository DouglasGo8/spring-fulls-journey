package com.apress.springfulls.journey.procore.chapter03.configurable;


import com.apress.springfulls.journey.procore.chapter03.renderer.MessageProvider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("provider")
public class ConfigurableMessageProvider implements MessageProvider {

  private final String message;

  public ConfigurableMessageProvider(@Value("Configurable Message") String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return this.message;
  }
}
