package com.apress.springfulls.journey.procore.chapter04;


import com.apress.springfulls.journey.procore.chapter04.advconfig.MessageProvider;
import com.apress.springfulls.journey.procore.chapter04.advconfig.MessageRenderer;
import com.apress.springfulls.journey.procore.chapter04.impl.provider.ProviderConfig;
import com.apress.springfulls.journey.procore.chapter04.impl.renderer.RendererConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class MessageRenderOneIT {

  // Review the git project
  @Test
  public void testConfig() {
    var ctx = new AnnotationConfigApplicationContext(RendererConfig.class, ProviderConfig.class);
    var messageProvider = ctx.getBean(MessageProvider.class);
    var messageRenderer = ctx.getBean(MessageRenderer.class);

    assertAll( "messageTest" , () ->
            assertNotNull(messageRenderer), () ->
            assertNotNull(messageProvider), () ->
            assertEquals(messageProvider, messageRenderer.getMessageProvider())
    );

    //messageRenderer.render();

  }
}
