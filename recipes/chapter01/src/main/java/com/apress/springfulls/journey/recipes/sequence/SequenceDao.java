package com.apress.springfulls.journey.recipes.sequence;

public interface SequenceDao {
  int getNextValue(String sequenceId);

  SequenceV2 getSequence(int sequenceId);
}
