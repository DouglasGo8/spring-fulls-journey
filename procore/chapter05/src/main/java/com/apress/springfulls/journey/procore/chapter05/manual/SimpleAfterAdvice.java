package com.apress.springfulls.journey.procore.chapter05.manual;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

@Slf4j
@NoArgsConstructor
public class SimpleAfterAdvice implements AfterReturningAdvice {
  @Override
  public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
    log.info("After: offer standing ovation.");
  }
}
