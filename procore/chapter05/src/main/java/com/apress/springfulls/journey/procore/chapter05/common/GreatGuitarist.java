package com.apress.springfulls.journey.procore.chapter05.common;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class GreatGuitarist implements Singer {
  @Override
  public void sing() {
    log.info("You've got my soul in your hands!!");
  }
}
