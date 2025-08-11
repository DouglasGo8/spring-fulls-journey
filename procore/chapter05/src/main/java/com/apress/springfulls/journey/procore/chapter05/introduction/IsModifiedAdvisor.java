package com.apress.springfulls.journey.procore.chapter05.introduction;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class IsModifiedAdvisor extends DefaultIntroductionAdvisor {
  public IsModifiedAdvisor() {
    super(new IsModifiedMixin());
  }
}
