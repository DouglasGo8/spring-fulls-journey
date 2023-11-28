package com.apress.springfulls.journey.procore.chapter04.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MessageEvent extends ApplicationEvent {

  private final String msg;

  public MessageEvent(Object source, String msg) {
    super(source);
    this.msg = msg;
  }
}
