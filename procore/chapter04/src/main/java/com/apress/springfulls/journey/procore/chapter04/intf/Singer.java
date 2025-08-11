package com.apress.springfulls.journey.procore.chapter04.intf;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class Singer implements InitializingBean {

  static final String DEFAULT_NAME = "No Name";
  String name;
  int age = Integer.MIN_VALUE;


  public void setName(String name) {
    log.info("Calling setName for bean of type {}.", Singer.class);
    this.name = name;
  }

  public void setAge(int age) {
    log.info("Calling setAge for bean of type {}.", Singer.class);
    this.age = age;
  }

  @PostConstruct
  public void init() {
    log.info("Calling init @PostConstructor/jsr-250 for bean of type {}.", Singer.class);
  }

  @Override
  public void afterPropertiesSet() {
    log.info("Initializing bean using 'afterPropertiesSet()'");
    if (null == name) {
      log.info("Using default name");
      name = DEFAULT_NAME;
    }
    if (age == Integer.MIN_VALUE) {
      throw new IllegalArgumentException("You must set the age property of any beans of type " + Singer.class);
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
