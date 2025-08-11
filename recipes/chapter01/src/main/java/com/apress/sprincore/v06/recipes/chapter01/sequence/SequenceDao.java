package com.apress.sprincore.v06.recipes.chapter01.sequence;

public interface SequenceDao {
  Sequence getSequence(String sequenceId);
  int getNextValue(String sequenceId);

}
