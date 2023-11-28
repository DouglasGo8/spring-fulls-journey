package com.apress.springfulls.journey.procore.chapter02.decoupled;

public interface MessageRenderer {
  void render();

  void setMessageProvider(MessageProvider messageProvider);

  MessageProvider getMessageProvider();
}
