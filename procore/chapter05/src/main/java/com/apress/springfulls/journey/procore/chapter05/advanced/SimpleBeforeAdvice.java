package com.apress.springfulls.journey.procore.chapter05.advanced;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

@Slf4j
public class SimpleBeforeAdvice implements MethodBeforeAdvice {
  @Override
  public void before(Method method, Object[] args, Object target) throws Throwable {
    log.info("Before advice for method {}", method.getName());
  }
}
