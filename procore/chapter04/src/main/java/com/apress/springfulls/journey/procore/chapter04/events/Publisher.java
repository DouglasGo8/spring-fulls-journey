package com.apress.springfulls.journey.procore.chapter04.events;


import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Publisher {
  final ApplicationContext ctx;

  public void publish(String message) {
    ctx.publishEvent(new MessageEvent(this.ctx, message));
  }
}
