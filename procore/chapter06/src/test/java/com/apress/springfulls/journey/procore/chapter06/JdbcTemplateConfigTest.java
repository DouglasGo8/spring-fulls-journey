package com.apress.springfulls.journey.procore.chapter06;

import com.apress.springfulls.journey.procore.chapter06.common.SingerDao;
import com.apress.springfulls.journey.procore.chapter06.template.SpringJdbcTemplateCfg;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
/*@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = {
                                "com.apress.springfulls.journey.procore.chapter06.template.*Dao"
                        }
                )
        })*/
public class JdbcTemplateConfigTest {


  @Test
  public void testSpringJdbcTemplate() {
    try (var ctx = new AnnotationConfigApplicationContext(SpringJdbcTemplateCfg.class)) {
      var jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
      assertNotNull(jdbcTemplate);

      var singerDao = ctx.getBean("singerDao", SingerDao.class);
      assertEquals("John Mayer", singerDao.findNameById(1L));
    }
  }
}
