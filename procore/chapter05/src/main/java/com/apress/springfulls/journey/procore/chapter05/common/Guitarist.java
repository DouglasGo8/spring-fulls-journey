package com.apress.springfulls.journey.procore.chapter05.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Guitarist implements Singer {
  @Override
  public void sing() {
    log.info("Just keep me where the light is");
  }

  public void sing2() {
    log.info("And wrap me in your arms");
  }

  @Override
  public void rest() {
    log.info("zzz...");
  }
}
