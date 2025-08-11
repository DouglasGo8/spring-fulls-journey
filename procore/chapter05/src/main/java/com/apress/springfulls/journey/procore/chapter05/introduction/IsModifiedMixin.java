package com.apress.springfulls.journey.procore.chapter05.introduction;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

@Slf4j
public class IsModifiedMixin extends DelegatingIntroductionInterceptor implements IsModified {
  private boolean isModified = false;
  private final Map<Method, Method> methodCache = new HashMap<>();
  private final Predicate<MethodInvocation> isSetter = invocation ->
          invocation.getMethod().getName().startsWith("set") && (invocation.getArguments().length == 1);

  @Override
  public boolean isModified() {
    return this.isModified;
  }

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    if (!isModified) {
      if (isSetter.test(invocation)) {
        Method getter = getGetter(invocation.getMethod());
        if (getter != null) {
          Object newVal = invocation.getArguments()[0];
          Object oldVal = getter.invoke(invocation.getThis(), null);
          if (newVal == null && oldVal == null) {
            isModified = false;
          } else if ((newVal == null && oldVal != null) || (newVal != null && oldVal == null)) {
            isModified = true;
          } else {
            isModified = !newVal.equals(oldVal);
          }
        }
      }
    }
    return super.invoke(invocation);
  }

  private Method getGetter(Method setter) {
    Method getter = methodCache.get(setter);
    if (getter != null) {
      return getter;
    }
    String getterName = setter.getName().replaceFirst("set", "get");
    try {
      getter = setter.getDeclaringClass().getMethod(getterName, null);
      synchronized (methodCache) {
        methodCache.put(setter, getter);
      }
      return getter;
    } catch (NoSuchMethodException ex) {
      return null;
    }
  }
}
