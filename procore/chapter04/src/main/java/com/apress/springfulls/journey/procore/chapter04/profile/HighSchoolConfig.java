package com.apress.springfulls.journey.procore.chapter04.profile;

import com.apress.springfulls.journey.procore.chapter04.profile.highschool.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("highschool")
public class HighSchoolConfig {
  @Bean
  FoodProviderService foodProviderService() {
    return new FoodProviderServiceImpl();
  }
}
