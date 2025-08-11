package com.apress.springfulls.journey.procore.chapter05.advice;

import com.apress.springfulls.journey.procore.chapter05.common.Guitar;
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
public class AroundAdviceV2 {


  @Pointcut("execution(* com.apress.springfulls.journey.procore.chapter05..sing*(com.apress.springfulls.journey.procore.chapter05.common.Guitar)) && args(value)")
  public void singExecution(Guitar value) {
  }

  @Around(value = "singExecution(guitar)", argNames = "pjp,guitar")
  public Object simpleAroundAdvice(ProceedingJoinPoint pjp, Guitar guitar) throws Throwable {
    var signature = (MethodSignature) pjp.getSignature();
    log.info(" > Before Executing: {} from {} with argument {}", signature.getName(), signature.getDeclaringTypeName(), guitar.getBrand());
    Object retVal = pjp.proceed();
    log.info(" > After Executing: {} from {} with argument {}", signature.getName(), signature.getDeclaringTypeName(), guitar.getBrand());
    return retVal;
  }

}
