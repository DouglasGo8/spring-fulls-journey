package com.apress.springfulls.journey.procore.chapter02;

import com.apress.springfulls.journey.procore.chapter02.annotated.HelloGalaxyConfiguration;
import com.apress.springfulls.journey.procore.chapter02.decoupled.HelloGalaxyMessageProvider;
import com.apress.springfulls.journey.procore.chapter02.decoupled.MessageProvider;
import com.apress.springfulls.journey.procore.chapter02.decoupled.MessageRenderer;
import com.apress.springfulls.journey.procore.chapter02.decoupled.StandardOutMessageRenderer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class AppTest {


  @Test
  @Disabled
  public void helloGalaxyDecoupledTest() {
    final MessageRenderer mr = new StandardOutMessageRenderer();
    final MessageProvider mp = new HelloGalaxyMessageProvider();
    mr.setMessageProvider(mp);
    mr.render();
  }

  // Spring 5 has dropped support for XML configurations
  @Test
  @Disabled
  public void helloGalaxyDecoupledMangedBySpringXml() {
    try (var ctx = new ClassPathXmlApplicationContext("spring/app-context.xml")) {
      var renderer = ctx.getBean("renderer", MessageRenderer.class);
      renderer.render();
    }
  }

  @Test

  public void helloGalaxyDecoupledMangedBySpringAnnotation() {
    try (var ctx = new AnnotationConfigApplicationContext(HelloGalaxyConfiguration.class)) {
      var renderer = ctx.getBean("renderer", MessageRenderer.class);
      renderer.render();
    }
  }
}
