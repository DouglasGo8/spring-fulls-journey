package com.apress.springfulls.journey.procore.chapter06.plain.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Album implements Serializable {
  private Long id;
  private Long singerId;
  private String title;
  private LocalDate releaseDate;
}
