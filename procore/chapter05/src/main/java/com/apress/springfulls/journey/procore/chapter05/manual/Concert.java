package com.apress.springfulls.journey.procore.chapter05.manual;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Concert implements Performance {

  @Override
  @SneakyThrows
  public void execute() {
    log.info("... La la la la whata hell ....");
    TimeUnit.MILLISECONDS.sleep(2000);
  }
}
