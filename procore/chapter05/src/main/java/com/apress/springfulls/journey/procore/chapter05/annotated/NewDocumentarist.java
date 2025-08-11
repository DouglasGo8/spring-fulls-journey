package com.apress.springfulls.journey.procore.chapter05.annotated;

import com.apress.springfulls.journey.procore.chapter05.common.Guitar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component("documentarist")
public class NewDocumentarist {

  protected GrammyGuitarist guitarist;

  public void execute() {
    guitarist.sing();
    Guitar guitar = new Guitar();
    guitar.setBrand("Gibson");
    guitarist.sing(guitar);
    guitarist.talk();
  }

  @Autowired
  @Qualifier("johnMayer")
  public void setGuitarist(GrammyGuitarist guitarist) {
    log.info("Qualifying Guitarist method");
    this.guitarist = guitarist;
  }
}
