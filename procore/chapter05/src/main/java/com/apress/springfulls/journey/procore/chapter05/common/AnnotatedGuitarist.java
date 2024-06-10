package com.apress.springfulls.journey.procore.chapter05.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnnotatedGuitarist implements Singer {

  @Override
  public void sing() {
  }

  @AdviceRequired
  public void sing(Guitar guitar) {
    logger.info("play from AnnotatedGuitarist.class: {}", guitar.play());
  }
}
