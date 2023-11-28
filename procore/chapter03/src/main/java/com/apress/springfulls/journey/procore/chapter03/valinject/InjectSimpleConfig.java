package com.apress.springfulls.journey.procore.chapter03.valinject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Getter
@NoArgsConstructor
@Component(value = "injectSimpleConfig")
public class InjectSimpleConfig {
  private String name = "John Mayer";
  //private int age = 40;
  //private float height = 1.92f;
  //private boolean developer = false;
  //private Long ageInSeconds = 1_241_401_112L;

}
