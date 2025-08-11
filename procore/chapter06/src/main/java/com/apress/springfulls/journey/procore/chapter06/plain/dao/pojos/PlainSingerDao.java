package com.apress.springfulls.journey.procore.chapter06.plain.dao.pojos;

import com.apress.springfulls.journey.procore.chapter06.plain.pojos.Singer;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class PlainSingerDao implements SingerDao {
  @Override
  public Set<Singer> findAll() {
    Set<Singer> singers = new HashSet<>();
    try (var connection = getConnection()) {
      var statement = connection.prepareStatement("SELECT * FROM tbl_singer");
      var resultSet = statement.executeQuery();
      {
        while (resultSet.next()) {
          var singer = new Singer();
          singer.setId(resultSet.getLong("id"));
          singer.setFirstName(resultSet.getString("first_name"));
          singer.setLastName(resultSet.getString("last_name"));
          singer.setBirthDate(resultSet.getDate("birth_date")
                  .toLocalDate());
          singers.add(singer);
        }
      }
    } catch (SQLException ex) {
      log.error("Problem when executing SELECT!", ex);
    }

    return singers;
  }

  @Override
  public Set<Singer> findByFirstName(String firstName) {
    return Set.of();
  }

  @Override
  public String findNameById(Long id) {
    return "";
  }

  @Override
  public String findLastNameById(Long id) {
    return "";
  }

  @Override
  public String findFirstNameById(Long id) {
    return "";
  }

  @Override
  public Singer insert(Singer singer) {
    try (var connection = getConnection()) {
      var statement = connection.prepareStatement(
              "insert into tbl_singer (first_name, last_name, birth_date) values (?, ?, ?)"
              , Statement.RETURN_GENERATED_KEYS);
      statement.setString(1, singer.getFirstName());
      statement.setString(2, singer.getLastName());
      statement.setDate(3, java.sql.Date.valueOf(singer.getBirthDate()));
      statement.execute();
      var generatedKeys = statement.getGeneratedKeys();
      if (generatedKeys.next()) {
        singer.setId(generatedKeys.getLong(1));
      }
      return singer;
    } catch (SQLException ex) {
      log.error("Problem executing INSERT", ex);
    }
    return null;
  }

  @Override
  public void update(Singer singer) {

  }

  @Override
  public void delete(Long singerId) {
    try (var connection = getConnection();
         var statement = connection.prepareStatement("delete from tbl_singer where id=?")) {
      statement.setLong(1, singerId);
      statement.execute();
    } catch (SQLException ex) {
      log.error("Problem executing DELETE", ex);
    }
  }

  @Override
  public Set<Singer> findAllWithAlbums() {
    return Set.of();
  }

  @Override
  public void insertWithAlbum(Singer singer) {

  }
}
