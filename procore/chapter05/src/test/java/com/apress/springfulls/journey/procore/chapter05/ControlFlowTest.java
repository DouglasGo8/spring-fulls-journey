package com.apress.springfulls.journey.procore.chapter05;

import com.apress.springfulls.journey.procore.chapter05.advanced.SimpleBeforeAdvice;
import com.apress.springfulls.journey.procore.chapter05.advanced.MyBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

@Slf4j
public class ControlFlowTest {

  @Test
  public void controlFlow() {
    var target = new MyBean();
    var pc = new ControlFlowPointcut(ControlFlowTest.class, "test");
    var advisor = new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice());
    var pf = new ProxyFactory();
    pf.setTarget(target);
    pf.addAdvisor(advisor);
    //
    var proxy = (MyBean) pf.getProxy();
    log.info("\tTrying normal invoke");
    proxy.sendCurses();
    log.info("\tTrying under ControlFlowTest.test");
    test(proxy);
  }

  private void test(MyBean bean) {
    bean.sendCurses();
  }
}
