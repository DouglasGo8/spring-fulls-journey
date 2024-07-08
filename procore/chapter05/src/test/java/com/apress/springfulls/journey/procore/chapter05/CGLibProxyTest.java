package com.apress.springfulls.journey.procore.chapter05;

import com.apress.springfulls.journey.procore.chapter05.performance.DefaultSimpleBean;
import com.apress.springfulls.journey.procore.chapter05.performance.NoOpBeforeAdvice;
import com.apress.springfulls.journey.procore.chapter05.performance.SimpleBean;
import com.apress.springfulls.journey.procore.chapter05.performance.TestResults;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

import java.util.stream.IntStream;

@Slf4j
public class CGLibProxyTest {

  @Test
  public void cglibTests() {
    var target = new DefaultSimpleBean();
    //
    var advisor = new NameMatchMethodPointcutAdvisor(new NoOpBeforeAdvice());
    advisor.setMappedName("advised");
    //
    log.info("Starting CGLibProxyTest");
    this.runJdkTests(advisor, target);
    this.runCglibTests(advisor, target);
    this.runCglibFrozenTests(advisor, target);

  }

  private void runCglibTests(Advisor advisor, SimpleBean bean) {
    var pf = new ProxyFactory();
    pf.setProxyTargetClass(true);
    pf.setTarget(bean);
    pf.addAdvisor(advisor);
    var proxy = (SimpleBean) pf.getProxy();
    var result = test(proxy);
    log.info("CGLIB (Standard) Test result: ---\n {}", result);
  }

  private void runCglibFrozenTests(Advisor advisor, SimpleBean bean) {
    var pf = new ProxyFactory();
    pf.setProxyTargetClass(true);
    pf.setTarget(bean);
    pf.addAdvisor(advisor);
    pf.setFrozen(true);
    var proxy = (SimpleBean) pf.getProxy();
    var results = test(proxy);
    log.info("CGLIB (Frozen) Test results: ---\n {}", results);
  }

  private void runJdkTests(Advisor advisor, SimpleBean bean) {
    var pf = new ProxyFactory();
    pf.setProxyTargetClass(true);
    pf.setTarget(bean);
    pf.addAdvisor(advisor);
    pf.setInterfaces(SimpleBean.class);
    var proxy = (SimpleBean) pf.getProxy();
    var results = test(proxy);
    log.info("JDK Test results: ---\n {}", results);
  }

  private TestResults test(SimpleBean bean) {
    var results = new TestResults();
    //
    long before = System.currentTimeMillis();

    for (var i = 0; i < 500_000; i++) {
      bean.advised();
    }
//-----
    long after = System.currentTimeMillis();
    results.advisedMethodTime = after - before;

    before = System.currentTimeMillis();
    for (int x = 0; x < 500_000; x++) {
      bean.unadvised();
    }
    after = System.currentTimeMillis();
    results.unadvisedMethodTime = after - before;
//-----
    before = System.currentTimeMillis();
    for (int x = 0; x < 500_000; x++) {
      bean.equals(bean);
    }
    after = System.currentTimeMillis();
    results.equalsTime = after - before;
// ----
    before = System.currentTimeMillis();
    for (int x = 0; x < 500_000; x++) {
      bean.hashCode();
    }
    after = System.currentTimeMillis();
    results.hashCodeTime = after - before;
// -----
    Advised advised = (Advised) bean;
    before = System.currentTimeMillis();
    for (int x = 0; x < 500_000; x++) {
      advised.getTargetClass();
    }
    after = System.currentTimeMillis();
    results.proxyTargetTime = after - before;

    return results;
  }

}
