package com.apress.springfulls.journey.procore.chapter03;

import com.apress.springfulls.journey.procore.chapter03.annotated.HelloConfiguration;
import com.apress.springfulls.journey.procore.chapter03.autowiring.AnotherTarget;
import com.apress.springfulls.journey.procore.chapter03.autowiring.AutowiringCfg;
import com.apress.springfulls.journey.procore.chapter03.autowiring.Target;
import com.apress.springfulls.journey.procore.chapter03.collection.CollectionBean;
import com.apress.springfulls.journey.procore.chapter03.collection.CollectionConfig;
import com.apress.springfulls.journey.procore.chapter03.field.Inspiration;
import com.apress.springfulls.journey.procore.chapter03.field.Singer;
import com.apress.springfulls.journey.procore.chapter03.methodinjection.LockOpener;
import com.apress.springfulls.journey.procore.chapter03.methodinjection.LookupConfig;
import com.apress.springfulls.journey.procore.chapter03.nesting.ChildConfig;
import com.apress.springfulls.journey.procore.chapter03.nesting.ParentConfig;
import com.apress.springfulls.journey.procore.chapter03.nesting.Song;
import com.apress.springfulls.journey.procore.chapter03.renderer.MessageRenderer;
import com.apress.springfulls.journey.procore.chapter03.valinject.InjectSimpleConfig;
import com.apress.springfulls.journey.procore.chapter03.valinject.InjectSimpleDemo;
import com.apress.springfulls.journey.procore.chapter03.valinject.InjectSimpleSpELDemo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;

@Slf4j
public class AppTest {

  @Test
  @Disabled
  public void testAnnotatedBeans() {
    try (var ctx = new AnnotationConfigApplicationContext(HelloConfiguration.class)) {
      ctx.getBean("renderer", MessageRenderer.class).renderer();
    }
  }

  @Test
  @Disabled
  public void testFieldInjection() {
    try (var ctx = new AnnotationConfigApplicationContext()) {
      ctx.register(Singer.class, Inspiration.class);
      ctx.refresh();
      //
      var singer = ctx.getBean(Singer.class);
      singer.sing();
    }

  }

  @Test
  @Disabled
  public void testNesting() {
    var parentCtx = new AnnotationConfigApplicationContext();
    parentCtx.register(ParentConfig.class);
    parentCtx.refresh();
    //
    var childCtx = new AnnotationConfigApplicationContext();
    childCtx.register(ChildConfig.class);
    childCtx.setParent(parentCtx);
    childCtx.refresh();
    //
    var song1 = childCtx.getBean("song1", Song.class);
    var song2 = childCtx.getBean("song2", Song.class);
    var song3 = childCtx.getBean("song3", Song.class);
    //
    log.info("from parent ctx: {}", song1.title());
    log.info("from parent ctx: {}", song2.title());
    log.info("from parent ctx: {}", song3.title());

  }

  @Test
  @Disabled
  public void testSimpleInjection() {
    try (var ctx = new AnnotationConfigApplicationContext()) {
      ctx.registerBean(InjectSimpleDemo.class);
      ctx.refresh();
      var bean = ctx.getBean("injectSimple", InjectSimpleDemo.class);
      log.info("{}", bean);
    }
  }

  @Test
  @Disabled
  public void testExternalSimpleInjection() {
    try (var ctx = new AnnotationConfigApplicationContext()) {
      ctx.register(InjectSimpleConfig.class, InjectSimpleSpELDemo.class);
      ctx.refresh();

      // Injection and ApplicationContext Nesting
      //var childCtx = new AnnotationConfigApplicationContext();
      //childCtx.registerBean(InjectSimpleSpELDemo.class);
      //childCtx.setParent(ctx);
      //childCtx.refresh();
      //
      var bean = ctx.getBean("injectSimpleSpEL", InjectSimpleSpELDemo.class);
      log.info("{}", bean);
      //var config = ctx.getBean("injectSimpleConfig", InjectSimpleConfig.class);
      //log.info(config.getName());

    }
  }

  @Test
  @Disabled
  public void printCollections() {
    try (var ctx = new AnnotationConfigApplicationContext()) {
      ctx.register(CollectionBean.class, CollectionConfig.class);
      ctx.refresh();
      //
      var collect = ctx.getBean(CollectionBean.class);
      collect.printCollections();
    }
  }

  @Test
  @Disabled
  public void methodInjectionDemo() {
    try (var ctx = new AnnotationConfigApplicationContext(LookupConfig.class)) {
      var abstractLockOpener = ctx.getBean("abstractLockOpener", LockOpener.class);
      var standardLockOpener = ctx.getBean("standardLockOpener", LockOpener.class);
      //
      /*
      abstract class is supported only when using Lookup Method Injection,
      in which Spring will use CGLIB to generate a subclass of the AbstractLockOpener class that overrides the
      method dynamically
       */
      this.displayInfo("abstractLockOpener", abstractLockOpener);
      this.displayInfo("standardLockOpener", standardLockOpener);
    }
  }

  @Test
  @Disabled
  public void autowiringDemo() {
    try (var ctx = new AnnotationConfigApplicationContext(AutowiringCfg.class)) {
      var target = ctx.getBean(Target.class);
      log.info("Created target? {}", target != null);
      log.info("Injected bar? {}", target.bar != null);
      log.info("Injected fooOne? {}", target.fooOne != null ? target.fooOne.id : "");
      log.info("Injected fooTwo? {}", target.fooTwo != null ? target.fooTwo.id : "");
      //
      var anotherTarget = ctx.getBean(AnotherTarget.class);
      log.info("anotherTarget: Created anotherTarget? {}", anotherTarget != null);
      log.info("anotherTarget: Injected bar? {}", anotherTarget.bar != null);
      log.info("anotherTarget: Injected fooOne? {}", anotherTarget.fooOne != null ?
              anotherTarget.fooOne.id : "");
      log.info("anotherTarget: Injected fooTwo? {}", anotherTarget.fooTwo != null ?
              anotherTarget.fooTwo.id : "");
    }
  }

  void displayInfo(String beanName, LockOpener lockOpener) {
    var keyHelperOne = lockOpener.getMyKeyOpener();
    var keyHelperTwo = lockOpener.getMyKeyOpener();
    log.info("[{}]: KeyHelper Instances the Same? + ({})", beanName, keyHelperOne == keyHelperTwo);
    var stopWatch = new StopWatch();
    stopWatch.start("lookupDemo");
    //for (int x = 0; x < 100_000; x++) {
    //  var keyHelper = lockOpener.getMyKeyOpener();
    //  keyHelper.open();
    // }
    stopWatch.stop();
    log.info("100000 gets took {} ms ", +stopWatch.getTotalTimeMillis());
  }
}
