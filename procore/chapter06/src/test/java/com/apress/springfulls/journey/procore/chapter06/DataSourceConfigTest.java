package com.apress.springfulls.journey.procore.chapter06;

import com.apress.springfulls.journey.procore.chapter06.config.BasicDataSourceCfg;
import com.apress.springfulls.journey.procore.chapter06.config.SimpleDataSourceCfg;
import com.apress.springfulls.journey.procore.chapter06.common.SingerDao;
import com.apress.springfulls.journey.procore.chapter06.plain.SpringDatasourceCfg;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public class DataSourceConfigTest {

  @Test
  public void testSimpleDataSource() {
    try (var ctx = new AnnotationConfigApplicationContext(SimpleDataSourceCfg.class)) {
      var dataSource = ctx.getBean("dataSource", DataSource.class);
      assertNotNull(dataSource);
      this.testDataSource(dataSource);
    }
  }

  @Test
  public void testBasicDataSource() {
    var ctx = new AnnotationConfigApplicationContext(BasicDataSourceCfg.class);
    var dataSource = ctx.getBean("dataSource", DataSource.class);
    assertNotNull(dataSource);
    this.testDataSource(dataSource);

  }

  @Test
  public void testSpringJdbc() {
    try (var ctx = new AnnotationConfigApplicationContext(SpringDatasourceCfg.class)) {
      var dataSource = ctx.getBean("dataSource", DataSource.class);
      assertNotNull(dataSource);
      this.testDataSource(dataSource);
      var singerDao = ctx.getBean("singerDao", SingerDao.class);
      assertEquals("John Mayer", singerDao.findNameById(1L));
    }
  }

  void testDataSource(DataSource ds) {
    try (var connection = ds.getConnection()) {
      //log.info("Connection to database is {}", connection);
      var statement = connection.prepareStatement("SELECT 1 as \"1\"");
      var resultSet = statement.executeQuery();
      //
      while (resultSet.next()) {
        var mockVal = resultSet.getInt("1");
        assertEquals(1, mockVal);
      }

      log.info("Successfully executed query");

    } catch (SQLException e) {
      log.error("Something unexpected happened.", e);
    }
  }
}
