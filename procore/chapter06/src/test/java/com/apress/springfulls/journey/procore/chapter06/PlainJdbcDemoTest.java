package com.apress.springfulls.journey.procore.chapter06;

import com.apress.springfulls.journey.procore.chapter06.plain.dao.pojos.PlainSingerDao;
import com.apress.springfulls.journey.procore.chapter06.plain.dao.pojos.SingerDao;
import com.apress.springfulls.journey.procore.chapter06.plain.pojos.Singer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Slf4j
public class PlainJdbcDemoTest {

  final SingerDao singerDao = new PlainSingerDao();

  // Must truncate tables before run the test
  @Test
  @Disabled
  public void listAllSingers() {
    log.info("Listing initial singer data:");
    var singers = singerDao.findAll();
    singers.forEach(singer -> log.info(singer.toString()));

    log.info("-------------");
    log.info("Insert a new singer");
    Singer singer = new Singer();
    singer.setFirstName("Ed");
    singer.setLastName("Sheeran");
    singer.setBirthDate(LocalDate.of(1991, 2, 13));
    singerDao.insert(singer);
    //
    log.info("The singer has ID now: {}", singer.getId());
    log.info("-------------");
    //
    log.info("Listing singer data after new singer created:");
    listAllSingers();

    log.info("-------------");
    log.info("Deleting the previous created singer");
    singerDao.delete(singer.getId());
    log.info("Listing singer data after new singer deleted:");
    listAllSingers();
  }
}
