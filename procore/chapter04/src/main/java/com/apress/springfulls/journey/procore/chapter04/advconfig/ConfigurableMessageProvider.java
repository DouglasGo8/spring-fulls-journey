package com.apress.springfulls.journey.procore.chapter04.advconfig;


import org.springframework.beans.factory.annotation.Value;

public record ConfigurableMessageProvider(String message) implements MessageProvider {

  public ConfigurableMessageProvider(@Value(value = "Configurable message") String message) {
    this.message = message;
  }
}
