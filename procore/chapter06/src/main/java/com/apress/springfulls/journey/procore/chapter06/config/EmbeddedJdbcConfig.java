package com.apress.springfulls.journey.procore.chapter06.config;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

//@Configuration
public class EmbeddedJdbcConfig {

  //@Bean
  public DataSource dataSource() {
    var db = new EmbeddedDatabaseBuilder();
    return db.setType(EmbeddedDatabaseType.H2)
            .addScripts("classpath:h2/schema.sql", "classpath:h2/test-data.sql")
            .build();

  }
}
