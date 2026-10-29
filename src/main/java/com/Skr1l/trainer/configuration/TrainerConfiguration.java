package com.Skr1l.trainer.configuration;

import com.Skr1l.trainer.Trainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TrainerConfiguration {

  @Bean
  public Map<Long, Trainer> trainersStorage() {
    Map<Long, Trainer> trainersMap = new HashMap<Long, Trainer>();

    return trainersMap;
  }
}
