package com.apress.springfulls.journey.procore.chapter03.autowiring;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Foo {
  public String id = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
}
