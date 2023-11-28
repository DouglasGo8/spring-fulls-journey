package com.apress.springfulls.journey.procore.chapter03.dependson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("gopher")
public class Guitar {
  void sing() {
    log.info("Cm Eb Fm Ab Bb");
  }
}
