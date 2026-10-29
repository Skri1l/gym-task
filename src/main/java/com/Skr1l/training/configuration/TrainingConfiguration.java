package com.Skr1l.training.configuration;

import com.Skr1l.training.Training;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TrainingConfiguration {

  @Bean
  public Map<Long, Training>  trainingStorage() {
    Map<Long, Training> trainingMap = new HashMap<>();

    return trainingMap;
  }
}
