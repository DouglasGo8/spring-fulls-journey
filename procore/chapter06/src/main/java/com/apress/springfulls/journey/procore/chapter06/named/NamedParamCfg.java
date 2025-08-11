package com.apress.springfulls.journey.procore.chapter06.named;

import com.apress.springfulls.journey.procore.chapter06.common.SingerDao;
import com.apress.springfulls.journey.procore.chapter06.config.BasicDataSourceCfg;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
@Import(BasicDataSourceCfg.class)
public class NamedParamCfg {
  private final DataSource dataSource;

  @Bean
  public NamedParameterJdbcTemplate namedTemplate() {
    return new NamedParameterJdbcTemplate(dataSource);
  }

  @Bean
  public SingerDao singerDao() {
    var dao = new NamedTemplateDao(this.namedTemplate());
    //dao.setNamedTemplate(namedTemplate());
    return dao;
  }
}
