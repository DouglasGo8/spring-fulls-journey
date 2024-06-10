package com.apress.springfulls.journey.procore.chapter05;


import com.apress.springfulls.journey.procore.chapter05.common.*;
import com.apress.springfulls.journey.procore.chapter05.pointcut.SimpleDynamicPointcut;
import com.apress.springfulls.journey.procore.chapter05.pointcut.SimpleStaticPointcut;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;


@Slf4j
public class PointcutTest {

  @Test
  @Disabled
  public void staticPointcutDemo() {
    var steveVai = new GoodGuitarist();
    var jimmyPage = new GreatGuitarist();
    //
    final Singer proxyOne, proxyTwo;
    //
    var advice = new SimpleAroundAdvice();
    var pointcut = new SimpleStaticPointcut();
    var advisor = new DefaultPointcutAdvisor(pointcut, advice);
    //
    var pf = new ProxyFactory();
    pf.addAdvisor(advisor);
    pf.setTarget(steveVai);
    proxyOne = (Singer) pf.getProxy();

    pf = new ProxyFactory();
    pf.addAdvisor(advisor);
    pf.setTarget(jimmyPage);
    proxyTwo = (Singer) pf.getProxy();
    //
    proxyOne.sing();
    proxyTwo.sing();
  }

  @Test
  @Disabled
  public void dynamicPointcutDemo() {
    var target = new GoodGuitarist();
    var advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(), new SimpleAroundAdvice());
    //
    var pf = new ProxyFactory();
    pf.setTarget(target);
    pf.addAdvisor(advisor);

    var singer = (Singer) pf.getProxy();
    singer.sing("C");
    singer.sing("c");
    singer.sing("E");
    //
    singer.sing();
  }

  @Test
  @Disabled
  public void namedPointcutDemo() {
    var target = new GrammyGuitarist();
    var nmp = new NameMatchMethodPointcut();
    nmp.addMethodName("sing");
    nmp.addMethodName("rest");
    var advisor = new DefaultPointcutAdvisor(nmp, new SimpleAroundAdvice());
    //
    var pf = new ProxyFactory();
    pf.setTarget(target);
    pf.addAdvisor(advisor);
    //
    var singer = (GrammyGuitarist) pf.getProxy();
    singer.sing();
    singer.sing(new Guitar());
    singer.rest();
    singer.talk();
  }

  @Test
  @Disabled
  public void nameMatchMethodPointcutAdvisorDemo() {
    var target = new GrammyGuitarist();
    var advisor = new NameMatchMethodPointcutAdvisor(new SimpleAroundAdvice());
    advisor.setMappedNames("sing", "rest");
    //var advisor = new DefaultPointcutAdvisor(nmp, new SimpleAroundAdvice());
    //
    var pf = new ProxyFactory();
    pf.setTarget(target);
    pf.addAdvisor(advisor);
    //
    var singer = (GrammyGuitarist) pf.getProxy();
    singer.sing();
    singer.sing(new Guitar());
    singer.rest();
    singer.talk();
  }

  @Test
  @Disabled
  public void regxpPointcutDemo() {
    var target = new Guitarist();
    var regxp = new JdkRegexpMethodPointcut();
    regxp.setPattern(".*sing.*");
    //
    var advisor = new DefaultPointcutAdvisor(regxp, new SimpleAroundAdvice());
    var pf = new ProxyFactory();
    pf.setTarget(target);
    pf.addAdvisor(advisor);
    //
    Guitarist proxy = (Guitarist) pf.getProxy();
    proxy.sing();
    proxy.sing2();
    proxy.rest();
  }

  @Test
  @Disabled
  public void aspectJExpressionDemo() {
    var target = new Guitarist();
    var pointcut = new AspectJExpressionPointcut();
    pointcut.setExpression("execution(* sing*(..))");
    //
    var advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAroundAdvice());
    var pf = new ProxyFactory();
    pf.setTarget(target);
    pf.addAdvisor(advisor);

    var singer = (Guitarist) pf.getProxy();
    singer.sing();
    singer.sing2();
    singer.rest();
  }

  @Test
  public void annotatedPointcutDemo() {
    var target = new AnnotatedGuitarist();
    var pointcut = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
    var advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAroundAdvice());
    var pf = new ProxyFactory();
    pf.setTarget(target);
    pf.addAdvisor(advisor);
    //
    var singer = (AnnotatedGuitarist) pf.getProxy();
    singer.sing(new Guitar());
    singer.rest();
  }
}
