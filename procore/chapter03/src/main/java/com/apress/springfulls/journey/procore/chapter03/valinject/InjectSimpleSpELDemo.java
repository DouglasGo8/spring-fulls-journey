package com.apress.springfulls.journey.procore.chapter03.valinject;


import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@ToString
@Component(value = "injectSimpleSpEL")
public class InjectSimpleSpELDemo {

  @Value("#{injectSimpleConfig.name.toUpperCase()}")
  private String name;
}
