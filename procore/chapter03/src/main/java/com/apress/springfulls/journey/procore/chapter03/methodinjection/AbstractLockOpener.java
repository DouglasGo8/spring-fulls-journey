package com.apress.springfulls.journey.procore.chapter03.methodinjection;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("abstractLockOpener")
public abstract class AbstractLockOpener implements LockOpener {

  @Override
  @Lookup("keyHelper")
  public abstract KeyHelper getMyKeyOpener();

  public void openLock() {
    getMyKeyOpener().open();
  }
}
