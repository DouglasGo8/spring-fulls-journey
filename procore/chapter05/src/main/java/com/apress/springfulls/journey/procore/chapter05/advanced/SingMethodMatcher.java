package com.apress.springfulls.journey.procore.chapter05.advanced;

import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

public class SingMethodMatcher extends StaticMethodMatcher {
  @Override
  public boolean matches(Method method, Class<?> targetClass) {
    return (method.getName().startsWith("si"));
  }
}