package com.apress.springfulls.journey.procore.chapter03.field;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component("singer")
public class Singer {
  @Autowired
  protected Inspiration inspiration;

  public void sing() {
    log.info("... {}", inspiration.getLyric());
  }
}
