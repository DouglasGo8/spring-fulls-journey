package com.apress.springfulls.journey.procore.chapter05.performance;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Slf4j
public class TestResults {

  public long advisedMethodTime;
  public long unadvisedMethodTime;
  public long equalsTime;
  public long hashCodeTime;
  public long proxyTargetTime;

  //
  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("advised", advisedMethodTime)
            .append("unadvised", unadvisedMethodTime)
            .append("equals ", equalsTime)
            .append("hashCode", hashCodeTime)
            .append("getProxyTargetClass ", proxyTargetTime)
            .toString();
  }
}
