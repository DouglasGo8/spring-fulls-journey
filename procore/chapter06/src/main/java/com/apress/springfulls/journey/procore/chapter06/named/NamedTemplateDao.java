package com.apress.springfulls.journey.procore.chapter06.named;

import com.apress.springfulls.journey.procore.chapter06.common.SingerDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Map;

import static com.apress.springfulls.journey.procore.chapter06.common.QueryConstants.NAMED_FIND_NAME;

@Slf4j
@AllArgsConstructor
public class NamedTemplateDao implements SingerDao {
  private final NamedParameterJdbcTemplate namedTemplate;

  @Override
  public String findNameById(Long id) {
    return namedTemplate.queryForObject(NAMED_FIND_NAME, Map.of("singerId", id), String.class);
  }
}
