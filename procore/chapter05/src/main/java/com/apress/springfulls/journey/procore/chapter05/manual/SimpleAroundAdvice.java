package com.apress.springfulls.journey.procore.chapter05.manual;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

@Slf4j
@NoArgsConstructor
public class SimpleAroundAdvice implements MethodInterceptor {
  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    log.info("Around: starting time:");

    var sw = new StopWatch();
    sw.start(invocation.getMethod().getName());

    var result = invocation.proceed();
    sw.stop();

    log.info("Around: concert duration = {}", sw.getTotalTimeMillis());
    return result;
  }
}
