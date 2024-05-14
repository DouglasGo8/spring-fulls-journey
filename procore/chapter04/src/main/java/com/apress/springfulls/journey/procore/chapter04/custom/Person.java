package com.apress.springfulls.journey.procore.chapter04.custom;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Person {

  private FullName name;

  @Value("John Mayer")
  public void setName(FullName name) {
    this.name = name;
  }

  public FullName getName() {
    return name;
  }
}
