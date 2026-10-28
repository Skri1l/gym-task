package com.Skr1l.trainee.dao;

import com.Skr1l.trainee.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TraineeDao {

  private Map<Long, Trainee> traineeStorage;

  @Autowired
  public void setTraineeStorage(Map<Long, Trainee> traineeStorage) {
    this.traineeStorage = traineeStorage;
  }

  public Trainee getTraineeByUserId(Long userId) {
    return traineeStorage.get(userId);
  }

  public List<Trainee> getAllTrainees() {
    return new ArrayList<>(traineeStorage.values());
  }

  public void addTrainee(Trainee trainee) {
    if (getTraineeByUserId(trainee.getUserId()) != null) {
      throw new RuntimeException("Trainee already exists");
    }
    traineeStorage.put(trainee.getUserId(), trainee);
  }

  public  void deleteTrainee(Long userId) {
    traineeStorage.remove(userId);
  }

  public void updateTrainee(Trainee trainee) {
    if (getTraineeByUserId(trainee.getUserId()) == null) {
      throw new RuntimeException("Trainee with this userId" +  trainee.getUserId() + " doesn't exists");
    }
    traineeStorage.put(trainee.getUserId(), trainee);
  }
}
