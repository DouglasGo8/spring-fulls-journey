package com.apress.springfulls.journey.procore.chapter05;

import com.apress.springfulls.journey.procore.chapter05.advice.*;
import com.apress.springfulls.journey.procore.chapter05.annotated.AspectJAopConfig;
import com.apress.springfulls.journey.procore.chapter05.annotated.NewDocumentarist;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class AnnotatedAdviceTest {

  @Test
  @Disabled
  public void testBeforeAdviceV1() {
    try (var ctx = new AnnotationConfigApplicationContext()) {
      ctx.register(AspectJAopConfig.class, BeforeAdviceV1.class);
      ctx.refresh();
      //
      assertTrue(Arrays.asList(ctx.getBeanDefinitionNames()).contains("beforeAdviceV1"));
      //
      var documentarist = ctx.getBean("documentarist", NewDocumentarist.class);
      documentarist.execute();
    }
  }

  @Test
  @Disabled
  public void testBeforeAdviceV2() {
    try (var ctx = new AnnotationConfigApplicationContext()) {
      ctx.register(AspectJAopConfig.class, BeforeAdviceV2.class);
      ctx.refresh();
      //
      assertTrue(Arrays.asList(ctx.getBeanDefinitionNames()).contains("beforeAdviceV2"));
      //
      var documentarist = ctx.getBean("documentarist", NewDocumentarist.class);
      documentarist.execute();
    }
  }

  @Test
  @Disabled
  public void testBeforeAdviceV3() {
    try (var ctx = new AnnotationConfigApplicationContext()) {
      ctx.register(AspectJAopConfig.class, BeforeAdviceV3.class);
      ctx.refresh();
      //
      assertTrue(Arrays.asList(ctx.getBeanDefinitionNames()).contains("beforeAdviceV3"));
      //
      var documentarist = ctx.getBean("documentarist", NewDocumentarist.class);
      documentarist.execute();
    }
  }

  @Test
  @Disabled
  public void testBeforeAdviceV4() {
    try (var ctx = new AnnotationConfigApplicationContext()) {
      ctx.register(AspectJAopConfig.class, BeforeAdviceV4.class);
      ctx.refresh();
      //
      assertTrue(Arrays.asList(ctx.getBeanDefinitionNames()).contains("beforeAdviceV4"));
      //
      var documentarist = ctx.getBean("documentarist", NewDocumentarist.class);
      documentarist.execute();
    }
  }

  @Test
  @Disabled
  public void testAroundAdviceV1() {
    try (var ctx = new AnnotationConfigApplicationContext()) {
      ctx.register(AspectJAopConfig.class, AroundAdviceV1.class);
      ctx.refresh();
      //
      assertTrue(Arrays.asList(ctx.getBeanDefinitionNames()).contains("aroundAdviceV1"));
      //
      var documentarist = ctx.getBean("documentarist", NewDocumentarist.class);
      documentarist.execute();
    }
  }

  @Test

  public void testAroundAdviceV2() {
    try (var ctx = new AnnotationConfigApplicationContext()) {
      ctx.register(AspectJAopConfig.class, AroundAdviceV2.class);
      ctx.refresh();
      //
      assertTrue(Arrays.asList(ctx.getBeanDefinitionNames()).contains("aroundAdviceV2"));
      //
      var documentarist = ctx.getBean("documentarist", NewDocumentarist.class);
      documentarist.execute();
    }
  }
}
