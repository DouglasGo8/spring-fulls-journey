package com.apress.springfulls.journey.procore.chapter05.performance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultSimpleBean implements SimpleBean {
  @Override
  public void advised() {
    System.currentTimeMillis();
  }

  @Override
  public void unadvised() {
    System.currentTimeMillis();
  }
}
