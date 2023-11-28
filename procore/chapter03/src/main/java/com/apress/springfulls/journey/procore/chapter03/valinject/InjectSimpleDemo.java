package com.apress.springfulls.journey.procore.chapter03.valinject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component(value = "injectSimple")
public class InjectSimpleDemo {
  @Value("John Mayer")
  private String name;
  @Value("40")
  private int age;
  @Value("1.92")
  private float height;
  @Value("false")
  private boolean developer;
  @Value("1241401112")
  private Long ageInSeconds;

  @Override
  public String toString() {
    return "Name: " + name + "\n"
            + "Age: " + age + "\n"
            + "Age in Seconds: " + ageInSeconds + "\n"
            + "Height: " + height + "\n"
            + "Is Developer?: " + developer;
  }
}
