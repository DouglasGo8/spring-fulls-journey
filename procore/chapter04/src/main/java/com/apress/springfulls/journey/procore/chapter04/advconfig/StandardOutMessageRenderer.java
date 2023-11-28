package com.apress.springfulls.journey.procore.chapter04.advconfig;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class StandardOutMessageRenderer implements MessageRenderer {

  private MessageProvider messageProvider;

  @Override
  public void setMessageProvider(MessageProvider provider) {
    this.messageProvider = provider;
  }

  @Override
  public MessageProvider getMessageProvider() {
    return this.messageProvider;
  }

  @Override
  public void render() {
    log.info(messageProvider.message());
  }
}
