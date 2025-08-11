package com.apress.springfulls.journey.procore.chapter06.common;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

import static com.apress.springfulls.journey.procore.chapter06.common.QueryConstants.PARAMETRIZED_FIND_NAME;

@Slf4j
@AllArgsConstructor
public class JdbcSingerDao implements SingerDao {

  final JdbcTemplate jdbcTemplate;

  @Override
  public String findNameById(Long id) {
    return this.jdbcTemplate.queryForObject(PARAMETRIZED_FIND_NAME, String.class, id);
  }
}
