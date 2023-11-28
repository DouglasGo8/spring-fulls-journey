package com.apress.springfulls.journey.procore.chapter04.profile.kindergarten;

import com.apress.springfulls.journey.procore.chapter04.profile.Food;
import com.apress.springfulls.journey.procore.chapter04.profile.FoodProviderService;

import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService {
  @Override
  public List<Food> provideLunchSet() {
    return List.of(new Food("Milk"), new Food("Biscuits"));
  }
}
