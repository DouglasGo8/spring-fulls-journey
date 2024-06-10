package com.apress.springfulls.journey.procore.chapter05.pointcut;

import com.apress.springfulls.journey.procore.chapter05.common.GoodGuitarist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

@Slf4j
public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

  @Override
  public ClassFilter getClassFilter() {
    return cls -> (cls == GoodGuitarist.class);
  }

  @Override
  public boolean matches(Method method, Class<?> targetClass, Object... args) {

    log.info("Dynamic check for {}", method.getName());

    return (args.length == 0) ? false :
            ((String) args[0]).equalsIgnoreCase("C");
  }

  @Override
  public boolean matches(Method method, Class<?> targetClass) {
    log.info("Static check for {}", method.getName());
    return ("sing".equals(method.getName()));
  }
}
