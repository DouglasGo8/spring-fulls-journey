package com.apress.springfulls.journey.procore.chapter03.nesting;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Setter
@Getter
public class TitleProvider {
  private String title = "Gravity";

  // builder method
  public static TitleProvider instance(final String title) {
    var childProvider = new TitleProvider();
    if (StringUtils.isNotBlank(title)) {
      childProvider.setTitle(title);
    }
    return childProvider;
  }
}