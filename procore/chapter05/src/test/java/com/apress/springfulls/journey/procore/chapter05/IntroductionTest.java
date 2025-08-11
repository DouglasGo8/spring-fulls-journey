package com.apress.springfulls.journey.procore.chapter05;

import com.apress.springfulls.journey.procore.chapter05.introduction.Contact;
import com.apress.springfulls.journey.procore.chapter05.introduction.IsModified;
import com.apress.springfulls.journey.procore.chapter05.introduction.IsModifiedAdvisor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

@Slf4j
public class IntroductionTest {
  @Test
  public void testIntroduction(){
    var contact = new Contact();
    contact.setName("John Mayer");
    //
    var advisor = new IsModifiedAdvisor();
    var pf = new ProxyFactory();
    pf.setTarget(contact);
    pf.addAdvisor(advisor);
    pf.setOptimize(true);
    //
    Contact proxy = (Contact) pf.getProxy();
    IsModified proxyInterface = (IsModified)proxy;
    log.info("Is Contact? => {} " , (proxy instanceof Contact));
    log.info("Is IsModified? => {} " , (proxy instanceof IsModified));
    log.info("Has been modified? => {} " , proxyInterface.isModified());
  }
}
