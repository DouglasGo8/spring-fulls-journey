package com.apress.springfulls.journey.procore.chapter03.methodinjection;

public interface LockOpener {
  void openLock();

  KeyHelper getMyKeyOpener();
}
