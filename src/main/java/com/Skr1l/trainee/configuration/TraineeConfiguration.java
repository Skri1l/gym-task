package com.Skr1l.trainee.configuration;

import com.Skr1l.trainee.Trainee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TraineeConfiguration {

  @Bean
  public Map<Long, Trainee> traineeStorage() {
    Map<Long, Trainee> traineeMap = new HashMap<Long, Trainee>();

    return traineeMap;
  }
}
