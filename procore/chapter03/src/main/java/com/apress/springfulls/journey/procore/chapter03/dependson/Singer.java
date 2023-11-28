package com.apress.springfulls.journey.procore.chapter03.dependson;

import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@DependsOn("gopher")
@Component("johnMayer")
public class Singer implements ApplicationContextAware {
  private ApplicationContext ctx;
  private Guitar guitar;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.ctx = applicationContext;
  }

  void sing() {
    guitar = ctx.getBean("gopher", Guitar.class);
    guitar.sing();
  }
}
