package com.apress.springfulls.journey.procore.chapter03.renderer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class StandardOutMessageRenderer implements MessageRenderer {

  final MessageProvider messageProvider; // @Autowired

  @Override
  public void renderer() {
    log.info("{}", this.messageProvider.getMessage());
  }
}
