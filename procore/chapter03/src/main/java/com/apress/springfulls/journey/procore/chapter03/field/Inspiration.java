package com.apress.springfulls.journey.procore.chapter03.field;

import lombok.Getter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Slf4j
@Getter
@Component
public class Inspiration {

  private String lyric = "I can dream about you...";
  //
  public Inspiration(@Value("For all my running") String lyric) {
    this.lyric = lyric;
  }

}
