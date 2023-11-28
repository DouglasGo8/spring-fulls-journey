package com.apress.springfulls.journey.recipes.sequence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@NoArgsConstructor
public class Sequence {
  final AtomicInteger counter = new AtomicInteger();
  String prefix;
  String suffix;


  public void setInitial(int initial) {
    this.counter.set(initial);
  }

  public String nextValue() {
    return prefix + counter.getAndIncrement() + suffix;
  }
}
