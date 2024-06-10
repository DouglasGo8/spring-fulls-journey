package com.apress.springfulls.journey.procore.chapter05;


import com.apress.springfulls.journey.procore.chapter05.manual.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

@Slf4j
public class AppTest {

  @Test
  @Disabled
  public void manualAdviceDemo() {
    var concert = new Concert();
    var pf = new ProxyFactory();
    //
    pf.addAdvice(new SimpleBeforeAdvice());
    pf.addAdvice(new SimpleAroundAdvice());
    pf.addAdvice(new SimpleAfterAdvice());
    pf.setTarget(concert);

    var proxy = (Performance) pf.getProxy();
    proxy.execute();
  }

}
