package com.apress.springfulls.journey.procore.chapter04.destroyed;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class FileManager /*implements DisposableBean*/ {
  private Path file;

  public FileManager() {
    log.info("Creating bean of type {}", FileManager.class);
    try {
      file = Files.createFile(Path.of("sample"));
    } catch (IOException e) {
      log.error("Could not create the file {}", e.getMessage());
    }
  }

  @PreDestroy
  private void destroyMethod() throws IOException {
    log.info("Calling preDestroy() on bean type {}", FileManager.class);
    if (null != file)
      Files.deleteIfExists(file);
  }
}
