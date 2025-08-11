package com.apress.springcore.v06.recipes.chapter01;

import com.apress.sprincore.v06.recipes.chapter01.sequence.SequenceDao;
import com.apress.sprincore.v06.recipes.chapter01.sequence.SimpleSequenceDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@Slf4j
@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = {
                                "com.apress.springcore.v06.recipes.chapter01.sequence.*Dao"
                        }
                )
        },
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = {org.springframework.stereotype.Controller.class}
                )
        }
)
public class MainTests {


  @Test
  public void testSequence() {
    try (var ctx = new AnnotationConfigApplicationContext(SimpleSequenceDao.class)) {
      var dao = ctx.getBean("sequenceDao", SequenceDao.class);
      log.info("{}", dao.getNextValue("IT"));
      log.info("{}", dao.getNextValue("IT"));
    }
  }
}
