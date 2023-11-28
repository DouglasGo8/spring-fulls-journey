package com.apress.springfulls.journey.procore.chapter03.methodinjection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Scope("prototype")
@Component("keyHelper")
public class KeyHelper {
  public void open() {
    //log.info("KeyHelper.open()");
  }
}
