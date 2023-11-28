package com.apress.springfulls.journey.procore.chapter03.autowiring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Slf4j
@Component
public class AnotherTarget {

  public Foo fooOne;
  public Foo fooTwo;
  public Bar bar;

  @Autowired
  public void setFooOne(Foo fooOne) {
    log.info(" --> AnotherTarget#setFooOne(Foo) called");
    this.fooOne = fooOne;
  }

  @Autowired
  public void setFooTwo(Foo fooTwo) {
    log.info(" --> AnotherTarget#setFooTwo(Foo) called");
    this.fooTwo = fooTwo;
  }

  @Autowired
  public void setBar(Bar bar) {
    log.info(" --> AnotherTarget#setBar(Bar) called");
    this.bar = bar;
  }
}
