package com.apress.springfulls.journey.procore.chapter03.collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CollectionConfig {
  @Bean
  List<Song> list() {
    return List.of(new Song("Not the End"), new Song("Rise up"));
  }

  @Bean
  public Song song1() {
    return new Song("Insemination of Demonic Purulence");
  }

  @Bean
  public Song song2() {
    return new Song("Ingurgitation of Hideous Rotting Evil  ");
  }
}
