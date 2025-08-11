package com.apress.springfulls.journey.procore.chapter06.plain;


import com.apress.springfulls.journey.procore.chapter06.common.SingerDao;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
public class JdbcSingerDao implements SingerDao, InitializingBean {

  @Setter
  private DataSource dataSource;

  @Override
  public String findNameById(Long id) {
    var result = "";
    try (var connection = dataSource.getConnection();
         var statement = connection.prepareStatement("select first_name, last_name from tbl_singer where id=" + id);
         var resultSet = statement.executeQuery()) {
      while (resultSet.next()) {
        return resultSet.getString("first_name") + " " + resultSet.getString("last_name");
      }
    } catch (SQLException ex) {
      log.error("Problem when executing SELECT!", ex);
    }
    return result;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    if (dataSource == null) {
      throw new BeanCreationException("Must set dataSource on SingerDao");
    }
  }
}
