package com.apress.springfulls.journey.procore.chapter04.custom;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    var name = text.split("\\s"); // String[]
    setValue(new FullName(name[0], name[1]));
  }
}
