package com.apress.springfulls.journey.procore.chapter06.config;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Slf4j
@Configuration
@NoArgsConstructor
@PropertySource("classpath:db/jdbc.properties")
public class SimpleDataSourceCfg {

  @Value("${jdbc.driverClassName}")
  private String driverClassName;
  @Value("${jdbc.url}")
  private String url;
  @Value("${jdbc.username}")
  private String username;
  @Value("${jdbc.password}")
  private String password;

  @Bean
  @SuppressWarnings("unchecked")
  public DataSource dataSource() {
    try {
      var dataSource = new SimpleDriverDataSource();
      Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName(driverClassName);
      dataSource.setDriverClass(driver);
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
