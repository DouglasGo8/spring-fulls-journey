package com.apress.springfulls.journey.procore.chapter04.initmethod;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Slf4j
public class Singer {
  static final String DEFAULT_NAME = "No Name";
  String name;
  int age;

  public void setName(String name) {
    log.info("Calling setName for bean of type {}.", Singer.class);
    this.name = name;
  }

  public void setAge(int age) {
    log.info("Calling setAge for bean of type {}.", Singer.class);
    this.age = age;
  }

  public void init() {
    log.info("Initializing bean on init method...");
    if (null == name) {
      log.info("Using default name");
      name = DEFAULT_NAME;
    }
    if (age == Integer.MIN_VALUE) {
      throw new IllegalArgumentException("You must, set the age property of any beans of type " + Singer.class);
    }
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("name", name)
            .append("age", age)
            .toString();
  }
}
