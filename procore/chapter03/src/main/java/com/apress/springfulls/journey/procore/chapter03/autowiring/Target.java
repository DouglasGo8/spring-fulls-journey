package com.apress.springfulls.journey.procore.chapter03.autowiring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Slf4j
@Component
public class Target {

  public Foo fooOne;
  public Foo fooTwo;
  public Bar bar;


  public Target() {
    log.info("--> Target Constructor called");
  }

  public Target(Foo foo) {
    this.fooOne = foo;
    log.info(" --> Target(Foo) called");
  }

  public Target(Foo foo, Bar bar) {
    this.fooOne = foo;
    this.bar = bar;
    log.info(" --> Target(Foo, Bar) called");
  }
}
