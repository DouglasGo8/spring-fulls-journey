package com.apress.springfulls.journey.procore.chapter05.advice;

import com.apress.springfulls.journey.procore.chapter05.common.Guitar;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class BeforeAdviceV4 {

  @Pointcut("execution(* com.apress.springfulls.journey.procore.chapter05..sing*(com.apress.springfulls.journey.procore.chapter05.common.Guitar)) && args(value)")
  public void singExecution(Guitar value) {}

  @Pointcut("bean(john*)")
  public void isJohn() {
  }

  @Before(value = "singExecution(guitar) && isJohn()", argNames = "joinPoint,guitar")
  public void simpleBeforeAdvice(JoinPoint joinPoint, Guitar guitar) {if(guitar.getBrand().equals("Gibson")) {
    var signature = (MethodSignature) joinPoint.getSignature();
    log.info(" > Executing: {} from {}", signature.getName(), signature.getDeclaringTypeName());
  }
  }
}
