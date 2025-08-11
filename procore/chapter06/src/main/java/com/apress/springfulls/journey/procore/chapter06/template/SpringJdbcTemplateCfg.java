package com.apress.springfulls.journey.procore.chapter06.template;

import com.apress.springfulls.journey.procore.chapter06.common.JdbcSingerDao;
import com.apress.springfulls.journey.procore.chapter06.common.SingerDao;
import com.apress.springfulls.journey.procore.chapter06.config.BasicDataSourceCfg;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
@Import(BasicDataSourceCfg.class)
public class SpringJdbcTemplateCfg {
  private final DataSource dataSource;

  @Bean
  public JdbcTemplate jdbcTemplate() {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource);
    return jdbcTemplate;
  }

  @Bean
  public SingerDao singerDao() {
    JdbcSingerDao dao = new JdbcSingerDao(this.jdbcTemplate());
    //dao.setJdbcTemplate(jdbcTemplate());
    return dao;
  }
}
