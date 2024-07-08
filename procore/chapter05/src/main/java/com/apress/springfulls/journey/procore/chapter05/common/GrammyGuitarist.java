package com.apress.springfulls.journey.procore.chapter05.common;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GrammyGuitarist implements Singer {
  @Override
  public void sing() {
    log.info("sing: Gravity is working against me And gravity wants to bring me down");
  }

  public void sing(Guitar guitar) {
    log.info("play: {}", guitar.play());
  }
  public void talk(){
    log.info("talk");
  }

  @Override
  public void rest(){
    log.info("zzz");
  }
}
