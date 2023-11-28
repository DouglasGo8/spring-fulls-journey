package com.apress.springfulls.journey.procore.chapter04.advconfig;

public interface MessageRenderer {
  void render();

  MessageProvider getMessageProvider();

  void setMessageProvider(MessageProvider provider);
}
