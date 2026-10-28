package com.Skr1l.user.configuration;

import com.Skr1l.trainee.dao.TraineeDao;
import com.Skr1l.trainer.dao.TrainerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsernameGenerator {

  private TraineeDao traineeDao;
  private TrainerDao trainerDao;

  @Autowired
  public void setTraineeDao(TraineeDao traineeDao) {
    this.traineeDao = traineeDao;
  }

  @Autowired
  public void setTrainerDao(TrainerDao trainerDao) {
    this.trainerDao = trainerDao;
  }

  public String generate(String firstName, String lastName) {
    String baseUsername = firstName + "." + lastName;
    String username = baseUsername;
    int finalNumber = 1;

    while (traineeDao.existsByUsername(username) || trainerDao.existsByUsername(username)) {
      username = baseUsername + finalNumber;
      finalNumber++;
    }
    return username;
  }
}
