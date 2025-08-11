package com.apress.springfulls.journey.procore.chapter06.plain;

import com.apress.springfulls.journey.procore.chapter06.common.SingerDao;
import com.apress.springfulls.journey.procore.chapter06.config.BasicDataSourceCfg;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Slf4j
@Configuration
@AllArgsConstructor
@Import(BasicDataSourceCfg.class)
public class SpringDatasourceCfg {
  final DataSource dataSource;

  @Bean
  public SingerDao singerDao() {
    var dao = new JdbcSingerDao();
    dao.setDataSource(dataSource);
    return dao;
  }
}
