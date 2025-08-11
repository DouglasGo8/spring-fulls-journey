package com.apress.springfulls.journey.procore.chapter06.plain.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
public class Singer implements Serializable {
  private Long id;
  private String firstName;
  private String lastName;
  private LocalDate birthDate;
  private Set<Album> albums;
}
