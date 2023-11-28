package com.apress.springfulls.journey.recipes;

import com.apress.springfulls.journey.recipes.sequence.Sequence;
import com.apress.springfulls.journey.recipes.sequence.SequenceDao;
import com.apress.springfulls.journey.recipes.sequence.config.SequenceConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
/*
// Spring Boot Main/Other Package when need to be injected
@ComponentScan(includeFilters = @ComponentScan.Filter
        (
                type = FilterType.REGEX,
                pattern = {
                        "com.apress.springfulls.journey.recipes.sequence.*Dao"
                }
        ))*/
public class AppTest {

  final String basePackages = "com.apress.springfulls.journey.recipes.sequence";

  @Test
  @Disabled
  public void initialSequenceDemo() {
    try (var ctx = new AnnotationConfigApplicationContext(SequenceConfiguration.class)) {
      var gen = ctx.getBean(Sequence.class);
      log.info("{}", gen.nextValue());
      log.info("{}", gen.nextValue());
      //
    }
  }

  @Test
  @Disabled
  public void initialSequenceDaoDemo() {
    try (var ctx = new AnnotationConfigApplicationContext(basePackages)) {
      var dao = ctx.getBean(SequenceDao.class);
      log.info("{}", dao.getNextValue("IT"));
      log.info("{}", dao.getNextValue("IT"));
    }
  }
}
