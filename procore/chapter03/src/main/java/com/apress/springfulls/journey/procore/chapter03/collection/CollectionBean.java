package com.apress.springfulls.journey.procore.chapter03.collection;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class CollectionBean {

  /*
   The @Autowired annotation is semantically defined in a way that
it always treats arrays, collections, and maps as sets of corresponding beans, with the target bean type
derived from the declared collection value type
   */
  //@Autowired
  //@Qualifier("list") // list Bean
  // @Resource is one of the preferred ways to do collection
  // injection because using one annotation is better than using two of them
  @Resource(name = "list") List<Song> songs;

  public void printCollections() {
    songs.forEach(s -> log.info("{}", s.title()));
  }
}
