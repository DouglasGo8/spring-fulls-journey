package com.apress.springfulls.journey.procore.chapter02.decoupled;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class StandardOutMessageRenderer implements MessageRenderer {
  private MessageProvider provider;

  @Override
  public void render() {
    if (null == provider) {
      throw new RuntimeException(
              "You must set the property messageProvider of class:"
                      + StandardOutMessageRenderer.class.getName());
    }
    log.info("{}", this.provider.getMessage());
  }

  @Override
  public void setMessageProvider(MessageProvider provider) {
    log.info(" --> StandardOutMessageRenderer: setting the provider");
    this.provider = provider;
  }

  @Override
  public MessageProvider getMessageProvider() {
    return this.provider;
  }
}
