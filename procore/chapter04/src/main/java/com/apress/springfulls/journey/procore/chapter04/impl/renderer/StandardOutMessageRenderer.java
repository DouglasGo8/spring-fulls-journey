package com.apress.springfulls.journey.procore.chapter04.impl.renderer;


import com.apress.springfulls.journey.procore.chapter04.advconfig.MessageProvider;
import com.apress.springfulls.journey.procore.chapter04.advconfig.MessageRenderer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class StandardOutMessageRenderer implements MessageRenderer {
  private MessageProvider messageProvider;

  @Override
  public void render() {
    log.info(messageProvider.message());
  }

  @Override
  public MessageProvider getMessageProvider() {
    return this.messageProvider;
  }

  @Override
  public void setMessageProvider(MessageProvider provider) {
    this.messageProvider = provider;
  }
}
