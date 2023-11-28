package com.apress.springfulls.journey.procore.chapter04.factory;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

@Slf4j
@Setter
public class MessageDigester {
  private MessageDigest digest1;
  private MessageDigest digest2;

  //
  public void digest(String msg) {
    log.info("Using digest1");
    digest(msg, digest1);
    //
    log.info("Using digest2");
    digest(msg, digest2);
  }

  private void digest(String msg, MessageDigest digest) {
    log.info("Using algorithm: " + digest.getAlgorithm());
    digest.reset();
    var bytes = msg.getBytes();
    var out = digest.digest(bytes);
    log.info("Original message {}", bytes);
    log.info("Encrypted Message: {}", out);
  }

}
