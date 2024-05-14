package com.apress.springfulls.journey.procore.chapter04;


import com.apress.springfulls.journey.procore.chapter04.custom.CustomPropertyEditorCfg;
import com.apress.springfulls.journey.procore.chapter04.custom.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class CustomPropertyEditorTest {

  @Test
  public void testCustomPropertyEditor() {
    try (var ctx = new AnnotationConfigApplicationContext(CustomPropertyEditorCfg.class)) {
      var person = ctx.getBean(Person.class, "person");
      log.info("Person full nam = {}" , person.getName());
    }
  }
}
