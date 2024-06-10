package com.apress.springfulls.journey.procore.chapter05.pointcut;

import com.apress.springfulls.journey.procore.chapter05.common.GoodGuitarist;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
  @Override
  public boolean matches(Method method, Class<?> targetClass) {
    return ("sing".equals(method.getName()));
  }

  @Override
  public ClassFilter getClassFilter() {
    return cls -> (cls == GoodGuitarist.class);
  }
}
