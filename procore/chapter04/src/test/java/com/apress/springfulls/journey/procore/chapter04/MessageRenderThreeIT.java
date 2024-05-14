package com.apress.springfulls.journey.procore.chapter04;

import com.apress.springfulls.journey.procore.chapter04.advconfig.MessageProvider;
import com.apress.springfulls.journey.procore.chapter04.advconfig.MessageRenderer;
import com.apress.springfulls.journey.procore.chapter04.impl.provider.ProviderConfig;
import com.apress.springfulls.journey.procore.chapter04.impl.renderer.RendererConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@Slf4j
@SpringJUnitConfig(classes = {RendererConfig.class, ProviderConfig.class})
public class MessageRenderThreeIT {


  @Autowired
  MessageRenderer messageRenderer;

  @Autowired
  MessageProvider messageProvider;

  @Test
  void testProvider() {
    assertNotNull(messageProvider);
  }

  @Test
  void testRenderer() {
    assertAll("messageTest",
            () -> assertNotNull(messageRenderer),
            () -> assertNotNull(messageRenderer.getMessageProvider())
    );
    messageRenderer.render();
  }

}
