package com.apress.springfulls.journey.procore.chapter04;

import com.apress.springfulls.journey.procore.chapter04.advconfig.MessageProvider;
import com.apress.springfulls.journey.procore.chapter04.impl.AllConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@ActiveProfiles("test")
@SpringJUnitConfig(classes = {AllConfig.class, TestConfig.class})
public class MessageRenderFourIT {
}

@Configuration
class TestConfig {
  @Profile("test")
  @Bean
  MessageProvider messageProvider() {
    return new TestMessageProvider("Test Message");
  }
}

record TestMessageProvider(String message) implements MessageProvider {

}
