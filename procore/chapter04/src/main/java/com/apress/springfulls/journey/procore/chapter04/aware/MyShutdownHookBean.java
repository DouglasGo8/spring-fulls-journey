package com.apress.springfulls.journey.procore.chapter04.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

@Slf4j
public class MyShutdownHookBean implements ApplicationContextAware {
   ApplicationContext ctx;

  @Override
  public void setApplicationContext(ApplicationContext ctx) throws BeansException {
    if (ctx instanceof GenericApplicationContext context) {
      context.registerShutdownHook();
    }
  }
}
