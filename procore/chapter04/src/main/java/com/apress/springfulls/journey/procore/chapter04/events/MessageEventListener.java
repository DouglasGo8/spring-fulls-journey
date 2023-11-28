package com.apress.springfulls.journey.procore.chapter04.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageEventListener implements ApplicationListener<MessageEvent> {
  @Override
  public void onApplicationEvent(MessageEvent event) {
    log.info("Received: {}", event.getMsg());
  }
}
