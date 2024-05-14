package com.apress.springfulls.journey.procore.chapter04;

import com.apress.springfulls.journey.procore.chapter04.advconfig.MessageProvider;
import com.apress.springfulls.journey.procore.chapter04.advconfig.MessageRenderer;
import com.apress.springfulls.journey.procore.chapter04.impl.provider.ProviderConfig;
import com.apress.springfulls.journey.procore.chapter04.impl.renderer.RendererConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MessageRenderTwoIT {
  public static ApplicationContext ctx;

  @BeforeAll
  static void setUp() {
    ctx = new AnnotationConfigApplicationContext(RendererConfig.class, ProviderConfig.class);
  }

  void testProvider() {
    var messageProvider = ctx.getBean(MessageProvider.class);
    assertNotNull(messageProvider);
  }

  @Test
  void testRenderer() {
    var messageRenderer = ctx.getBean(MessageRenderer.class);
    assertAll("messageTest", () -> assertNotNull(messageRenderer),
            () -> assertNotNull(messageRenderer.getMessageProvider()));
    messageRenderer.render();
  }

}
