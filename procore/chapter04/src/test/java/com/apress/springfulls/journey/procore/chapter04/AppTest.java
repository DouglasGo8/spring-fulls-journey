package com.apress.springfulls.journey.procore.chapter04;

import com.apress.springfulls.journey.procore.chapter04.advconfig.MessageRenderer;
import com.apress.springfulls.journey.procore.chapter04.advconfig.PropertySourcesCfg;
import com.apress.springfulls.journey.procore.chapter04.aware.AwareConfig;
import com.apress.springfulls.journey.procore.chapter04.aware.NamedSinger;
import com.apress.springfulls.journey.procore.chapter04.config.SingerConfiguration;
import com.apress.springfulls.journey.procore.chapter04.destroyed.DestroyConfig;
import com.apress.springfulls.journey.procore.chapter04.events.EventsConfig;
import com.apress.springfulls.journey.procore.chapter04.events.Publisher;
import com.apress.springfulls.journey.procore.chapter04.factory.MessageDigestConfig;
import com.apress.springfulls.journey.procore.chapter04.factory.MessageDigestFactoryBean;
import com.apress.springfulls.journey.procore.chapter04.factory.MessageDigester;
import com.apress.springfulls.journey.procore.chapter04.full.MultiInitConfiguration;
import com.apress.springfulls.journey.procore.chapter04.initmethod.Singer;
import com.apress.springfulls.journey.procore.chapter04.locale.MessageSourceConfig;
import com.apress.springfulls.journey.procore.chapter04.profile.Food;
import com.apress.springfulls.journey.procore.chapter04.profile.FoodProviderService;
import com.apress.springfulls.journey.procore.chapter04.profile.HighSchoolConfig;
import com.apress.springfulls.journey.procore.chapter04.profile.KindergartenConfig;
import com.apress.springfulls.journey.procore.chapter04.props.DiverseValuesContainer;
import com.apress.springfulls.journey.procore.chapter04.props.ValuesHolder;
import com.apress.springfulls.journey.procore.chapter04.propsource.AppProperty;
import com.apress.springfulls.journey.procore.chapter04.propsource.PropDemoConfig;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
public class AppTest {

  @Test
  public void testInitMethod() {
    try (var ctx = new AnnotationConfigApplicationContext(SingerConfiguration.class)) {
      //
      this.getBean("singerOne", ctx);
      this.getBean("singerTwo", ctx);
      this.getBean("singerThree", ctx);
      //
    }


  }

  @Test
  public void initializeBeanTest() {
    try (var ctx = new AnnotationConfigApplicationContext(com.apress.springfulls.journey.procore.chapter04.intf.SingerConfiguration.class)) {
      getBeanFromInitF("singerOne", ctx);
      //getBeanFromInitF("singerTwo", ctx);
      //getBeanFromInitF("singerThree", ctx);
    }
  }

  @Test
  public void allInitMethod() {
    try (var ctx = new AnnotationConfigApplicationContext(MultiInitConfiguration.class)) {
    }
  }

  @Test
  @Disabled
  public void destroyMethod() {
    try (var ctx = new AnnotationConfigApplicationContext(DestroyConfig.class)) {
      //ctx.close(); // needed to close the context
      log.info("Hi");
      //ctx.registerShutdownHook();
    }
  }

  @Test

  public void awareDemo() {
    try (var ctx = new AnnotationConfigApplicationContext(AwareConfig.class)) {
      //ctx.close(); // needed to close the context
      var singer = ctx.getBean(NamedSinger.class);
      singer.sing();
      //ctx.registerShutdownHook();
    }
  }

  @Test
  @Disabled
  public void factoryBeanDemo() {
    try (var ctx = new AnnotationConfigApplicationContext(MessageDigestConfig.class)) {
      var digester = ctx.getBean("digester", MessageDigester.class);
      digester.digest("Hello World!");
    }
  }

  /*
  Avoid accessing FactoryBean directly and invoking its getObject() manually
   */
  @Test
  @Disabled
  public void factoryBeanDemoV2() {
    try (var ctx = new AnnotationConfigApplicationContext(MessageDigestConfig.class)) {
      var factoryBean = ctx.getBean("&shaDigest", MessageDigestFactoryBean.class);
      var shaDigest = factoryBean.getObject();
      log.info("Explicit use digest bean: {}", shaDigest.digest("Hello world".getBytes()));
    } catch (Exception ex) {
      log.error("Could not find MessageDigestFactoryBean ", ex);
    }
  }

  @Test
  @Disabled
  public void diverseValuesDemo() throws Exception {
    var baseDir = new File(System.getProperty("java.io.tmpdir"));
    var path = Files.createFile(Path.of(baseDir.getAbsolutePath(), "test.txt"));
    Files.writeString(path, "Hello World");
    path.toFile().deleteOnExit();
    //
    var ctx = new AnnotationConfigApplicationContext();
    ctx.register(ValuesHolder.class, DiverseValuesContainer.class);
    ctx.refresh();
    ctx.close();
  }

  @Test
  @Disabled
  public void eventPublisherConsumerDemo() {
    try (var ctx = new AnnotationConfigApplicationContext(EventsConfig.class)) {
      var pub = ctx.getBean("publisher", Publisher.class);
      pub.publish("I send SOS the to World...");
      pub.publish("... I hope that someone gets my...");
      pub.publish("... Message in a bottle");
    }
  }

  @Test
  @Disabled
  public void resourceDemo() {
    try (var ctx = new AnnotationConfigApplicationContext()) {
      var baseDir = new File(System.getProperty("java.io.tmpdir"));
      var filePath = Files.createFile(Path.of(baseDir.getAbsolutePath(), "test.txt"));
      Files.writeString(filePath, "Hello World!");
      filePath.toFile().deleteOnExit();
      //
      var res1 = ctx.getResource("file//" + filePath);
      displayInfo(res1);
      var res2 = ctx.getResource("classpath:test.txt");
      displayInfo(res2);
      var res3 = ctx.getResource("https://iuliana-cosmina.com");
      displayInfo(res3);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  @Disabled
  public void messageRenderWithPropertyDemo() {
    try (var ctx = new AnnotationConfigApplicationContext(PropertySourcesCfg.class)) {
      var mr = ctx.getBean("messageRenderer", MessageRenderer.class);
      mr.render();
    }
  }

  /**
   * @apiNote -Dspring.profiles.active="kindergarten" -Dspring.profiles.active="highschool"
   */
  @Test
  @Disabled
  public void profileDemo() {
    var profile = System.getProperty("spring.profiles.active");
    var ctx = new AnnotationConfigApplicationContext();
    ctx.getEnvironment().setActiveProfiles(profile);
    ctx.register(HighSchoolConfig.class, KindergartenConfig.class);
    ctx.refresh();
    //
    var foodProvideService = ctx.getBean("foodProviderService", FoodProviderService.class);
    var launchSet = foodProvideService.provideLunchSet();
    launchSet.forEach(f -> log.info("Food: {}", f.getName()));
    ctx.close();
  }

  @Test
  @Disabled
  public void propertySourceFromPropertyFileDemo() {
    try (var ctx = new AnnotationConfigApplicationContext(PropDemoConfig.class)) {
      var appProperty = ctx.getBean("appProperty", AppProperty.class);
      log.info("Outcome: {}", appProperty);
    }
  }

  //-page 158
  @Test
  @Disabled
  public void testPropertySourceOne() {
    try (var ctx = new GenericApplicationContext()) {
      var env = ctx.getEnvironment();
      var propSources = env.getPropertySources();
      //
      var app = new HashMap<String, Object>();
      app.put("user.home", "CUSTOM_USER_HOME");
      propSources.addLast(new MapPropertySource("prospring6_MAP", app));
      //
      log.info("-- Env Variables from java.lang.System --");
      log.info("user.home: " + System.getProperty("user.home"));
      log.info("JAVA_HOME: " + System.getenv("JAVA_HOME"));
      log.info("-- Env Variables from ConfigurableEnvironment --");
      log.info("user.home: " + env.getProperty("user.home"));
      log.info("JAVA_HOME: " + env.getProperty("JAVA_HOME"));
    }
  }

  @Test
  @Disabled
  public void testPropertySourceTwo() {
    try (var ctx = new GenericApplicationContext()) {
      var env = ctx.getEnvironment();
      var propSources = env.getPropertySources();
      //
      var app = new HashMap<String, Object>();
      app.put("user.home", "CUSTOM_USER_HOME");
      propSources.addFirst(new MapPropertySource("prospring6_MAP", app));
      //
      log.info("-- Env Variables from java.lang.System --");
      log.info("user.home: " + System.getProperty("user.home"));
      log.info("JAVA_HOME: " + System.getenv("JAVA_HOME"));
      log.info("-- Env Variables from ConfigurableEnvironment --");
      log.info("user.home: " + env.getProperty("user.home"));
      log.info("JAVA_HOME: " + env.getProperty("JAVA_HOME"));
    }



  }

  @Test
  @Disabled
  public void testLocaleResourceBundle() {
    try (var ctx = new AnnotationConfigApplicationContext(MessageSourceConfig.class)) {
      var english = Locale.ENGLISH;
      var ukrainian = Locale.of("uk", "UA");

      log.info(ctx.getMessage("msg", null, english));
      log.info(ctx.getMessage("msg", null, ukrainian));
      //
      log.info(ctx.getMessage("nameMsg", new Object[]{ "Iuliana", "Cosmina" }, english));
      log.info(ctx.getMessage("nameMsg", new Object[]{ "Iuliana", "Cosmina" }, ukrainian));
    }
  }

  private void getBean(String beanName, ApplicationContext ctx) {
    try {
      Singer bean = (Singer) ctx.getBean(beanName);
      log.info("Found: {}", bean);
    } catch (BeanCreationException ex) {
      log.error("An error occurred in bean configuration: " + ex.getMessage());
    }
  }

  private void getBeanFromInitF(String beanName, ApplicationContext ctx) {
    try {
      var bean = (com.apress.springfulls.journey.procore.chapter04.intf.Singer) ctx.getBean(beanName);
      log.info("Found: {}", bean);
    } catch (BeanCreationException ex) {
      log.error("An error occurred in bean configuration: " + ex.getMessage());
    }
  }

  void displayInfo(Resource res) throws IOException {
    log.info("Resource class: {}", res.getClass());
    log.info("Resource URL content: {}", new BufferedReader(new InputStreamReader((InputStream)
            res.getURL().getContent())).lines().parallel().collect(Collectors.joining("\n")));
  }
}
