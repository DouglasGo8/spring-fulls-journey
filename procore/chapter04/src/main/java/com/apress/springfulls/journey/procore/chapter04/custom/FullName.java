package com.apress.springfulls.journey.procore.chapter04.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang.builder.ToStringBuilder;

@Getter
@AllArgsConstructor
public class FullName {
  private String firstName;
  private String lastName;

  @Override
  public String toString() {
    //
    return new ToStringBuilder(this)
            .append("firstName", firstName)
            .append("lastName", lastName)
            .toString();
  }
}
