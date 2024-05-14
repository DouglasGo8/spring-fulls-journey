package com.apress.springfulls.journey.procore.chapter04;

import com.apress.springfulls.journey.procore.chapter04.advconfig.MessageProvider;
import com.apress.springfulls.journey.procore.chapter04.advconfig.StandardOutMessageRenderer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

@Slf4j
public class MessageRenderTest {

  @Test
  public void testStandardOutMessageRenderer() {

    var mockProvider = mock(MessageProvider.class);
    when(mockProvider.message()).thenReturn("test message");

    var msgRenderer = new StandardOutMessageRenderer();
    msgRenderer.setMessageProvider(mockProvider);

    msgRenderer.render();
    verify(mockProvider, times(1)).message();

  }
}
