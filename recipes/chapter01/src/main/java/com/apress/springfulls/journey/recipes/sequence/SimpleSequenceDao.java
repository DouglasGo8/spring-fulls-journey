package com.apress.springfulls.journey.recipes.sequence;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


@Component("sequenceDao")
public class SimpleSequenceDao implements SequenceDao {

  final Map<String, SequenceV2> sequences = new ConcurrentHashMap<>();
  final Map<String, AtomicInteger> values = new ConcurrentHashMap<>();

  SimpleSequenceDao() {
    sequences.put("IT", new SequenceV2("IT", "30", "A"));
    values.put("IT", new AtomicInteger(10_000));
  }


  @Override
  public int getNextValue(String sequenceId) {
    return values.get(sequenceId).getAndIncrement();
  }

  @Override
  public SequenceV2 getSequence(int sequenceId) {
    return sequences.get(sequenceId);
  }
}
