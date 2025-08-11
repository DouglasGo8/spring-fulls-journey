package com.apress.springfulls.journey.procore.chapter04.full;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
@Getter
@AllArgsConstructor
public class MultiInit implements InitializingBean {

  private Dependency dependency;

  public MultiInit() {
    log.info("1. Calling constructor for bean of type {}.", MultiInit.class);
  }

  @Override
  public void afterPropertiesSet() {
    log.info("4. Calling afterPropertiesSet() for bean of type {}.",
            MultiInit.class);
  }

  @Autowired
  public void setDependency(Dependency dependency) {
    log.info("2. Calling setDependency for bean of type {}.", MultiInit.class);
    this.dependency = dependency;
  }

  @PostConstruct
  private void postConstruct() throws Exception {
    log.info("3. Calling postConstruct() for bean of type {}.", MultiInit.class);
  }

  private void initMe() throws Exception {
    log.info("5. Calling initMethod() for bean of type {}.", MultiInit.class);
  }
}
