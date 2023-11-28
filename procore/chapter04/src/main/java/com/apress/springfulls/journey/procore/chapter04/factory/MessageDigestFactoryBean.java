package com.apress.springfulls.journey.procore.chapter04.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {

  private String algorithmName = "MD5";
  private MessageDigest messageDigest = null;

  @Override
  public MessageDigest getObject() {
    return this.messageDigest;
  }

  @Override
  public Class<?> getObjectType() {
    return MessageDigest.class;
  }

  @Override
  public void afterPropertiesSet() throws NoSuchAlgorithmException {
    log.info("InitializingBean.afterPropertiesSet invoked");
    this.messageDigest = MessageDigest.getInstance(this.algorithmName);
  }

  @Override
  public boolean isSingleton() {
    return true;
  }

  void setAlgorithmName(String algorithmName) {
    this.algorithmName = algorithmName;
  }
}
