package com.apress.springfulls.journey.procore.chapter05.common;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
@NoArgsConstructor
public class SimpleAroundAdvice implements MethodInterceptor {
  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    log.info(">> Invoking {}", invocation.getMethod().getName());
    var retVal = invocation.proceed();
    log.info(">> Done!");
    return retVal;
  }
}
