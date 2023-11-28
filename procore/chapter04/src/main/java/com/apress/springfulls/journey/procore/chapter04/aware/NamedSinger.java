package com.apress.springfulls.journey.procore.chapter04.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;

@Slf4j
public class NamedSinger implements BeanNameAware {
  private String name;

  @Override
  /** @Implements {@link BeanNameAware#setBeanName(String)} */
  public void setBeanName(String name) {
    this.name = name;
  }

  public void sing() {
    log.info("Singer " + name + " - sing()");
  }
}
