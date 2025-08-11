package com.apress.springfulls.journey.procore.chapter06;

import com.apress.springfulls.journey.procore.chapter06.common.SingerDao;
import com.apress.springfulls.journey.procore.chapter06.named.NamedParamCfg;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public class JdbcNamedTemplateConfigTest {

  @Test
  public void testSpringJdbcTemplate() {
    try (var ctx = new AnnotationConfigApplicationContext(NamedParamCfg.class)) {
      var jdbcTemplate = ctx.getBean("namedTemplate", NamedParameterJdbcTemplate.class);
      assertNotNull(jdbcTemplate);

      var singerDao = ctx.getBean("singerDao", SingerDao.class);
      assertEquals("John Mayer", singerDao.findNameById(1L));
    }
  }
}
