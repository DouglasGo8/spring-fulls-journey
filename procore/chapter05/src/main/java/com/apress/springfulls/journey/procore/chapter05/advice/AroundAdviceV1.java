package com.apress.springfulls.journey.procore.chapter05.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AroundAdviceV1 {

  @Pointcut("execution(* com.apress.springfulls.journey.procore.chapter05..sing*(com.apress.springfulls.journey.procore.chapter05.common.Guitar))")
  public void singExecution() {
  }

  @Around("singExecution()")
  public Object simpleAroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
    var signature = (MethodSignature) pjp.getSignature();
    log.info(" > Before Executing: {} from {}", signature.getName(), signature.getDeclaringTypeName() );
    Object retVal = pjp.proceed();
    log.info(" > After Executing: {} from {}", signature.getName(), signature.getDeclaringTypeName() );
    return retVal;
  }
}
