package com.apress.springfulls.journey.procore.chapter06.config;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Slf4j
@Configuration
@NoArgsConstructor
@PropertySource("classpath:db/jdbc.properties")
public class BasicDataSourceCfg {

  @Value("${jdbc.driverClassName}")
  private String driverClassName;
  @Value("${jdbc.url}")
  private String url;
  @Value("${jdbc.username}")
  private String username;
  @Value("${jdbc.password}")
  private String password;

  @Bean(destroyMethod = "close")
  public DataSource dataSource() {
    try {
      // Commons.DBCP
      var dataSource = new BasicDataSource();
      dataSource.setDriverClassName(driverClassName);
      dataSource.setUrl(url);
      dataSource.setUsername(username);
      dataSource.setPassword(password);
      return dataSource;
    } catch (Exception e) {
      log.error("DBCP DataSource bean cannot be created!", e);
      return null;
    }
  }
}
