package com.apress.springfulls.journey.procore.chapter06.plain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface CoreDao {

  default Connection getConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/prospringdb?escapeSyntaxCallMode=callIfNoReturn",
            "guest", "welcome1");
  }

  default void closeConnection(Connection connection) throws SQLException {
    if (connection == null) {
      return;
    }
    connection.close();
  }
}
