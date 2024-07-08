package com.apress.springfulls.journey.procore.chapter05;

import com.apress.springfulls.journey.procore.chapter05.advanced.RestMethodMatcher;
import com.apress.springfulls.journey.procore.chapter05.advanced.SimpleBeforeAdvice;
import com.apress.springfulls.journey.procore.chapter05.advanced.SingMethodMatcher;
import com.apress.springfulls.journey.procore.chapter05.advanced.TalkMethodMatcher;
import com.apress.springfulls.journey.procore.chapter05.common.GrammyGuitarist;
import com.apress.springfulls.journey.procore.chapter05.common.Guitar;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

@Slf4j
public class ComposablePointcutTest {

  @Test
  public void composablePointcutTest() {
    var jimmy = new GrammyGuitarist();
    var pc = new ComposablePointcut(ClassFilter.TRUE, new SingMethodMatcher());
    //
    log.info("Test 1 >> ");
    var proxy = this.getProxy(pc, jimmy);

    log.info("Test 2 >> ");
    pc.union(new TalkMethodMatcher());
    proxy = getProxy(pc, jimmy);
    testInvoke(proxy);

    log.info("Test 3 >> ");
    pc.intersection(new RestMethodMatcher());
    proxy = getProxy(pc, jimmy);
    testInvoke(proxy);
  }

  GrammyGuitarist getProxy(ComposablePointcut pc, GrammyGuitarist target) {
    var advisor = new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice());
    var pf = new ProxyFactory();
    pf.setTarget(target);
    pf.addAdvisor(advisor);
    return (GrammyGuitarist) pf.getProxy();
  }

  void testInvoke(GrammyGuitarist proxy) {
    proxy.sing();
    proxy.sing(new Guitar());
    proxy.talk();
    proxy.rest();
  }

}
