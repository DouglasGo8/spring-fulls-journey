package com.apress.springfulls.journey.procore.chapter05.manual;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

@Slf4j
@NoArgsConstructor
public class SimpleBeforeAdvice implements MethodBeforeAdvice {

  @Override
  public void before(Method method, Object[] args, Object target) {
    log.info("Before: set up concert hall.");
  }

}
