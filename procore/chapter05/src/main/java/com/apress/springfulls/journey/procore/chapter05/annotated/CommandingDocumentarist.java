package com.apress.springfulls.journey.procore.chapter05.annotated;

import com.apress.springfulls.journey.procore.chapter05.common.Guitar;
import org.springframework.stereotype.Component;

@Component("commandingDocumentarist")
public class CommandingDocumentarist extends NewDocumentarist {

  @Override
  public void execute() {
    guitarist.sing();
    var guitar = new Guitar();
    guitar.setBrand("Gibson");
    guitarist.sing(guitar);
    guitarist.sing(new Guitar());
    guitarist.talk();
  }
}
