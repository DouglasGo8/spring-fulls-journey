package com.apress.sprincore.v06.recipes.chapter01.sequence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Sequence {
  private final String id;
  private final String prefix;
  private final String suffix;
}
