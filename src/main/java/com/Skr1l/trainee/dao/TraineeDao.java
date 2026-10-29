package com.Skr1l.trainee.dao;

import com.Skr1l.trainee.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TraineeDao {

  private Map<Long, Trainee> traineeStorage;

  private final AtomicLong idGeneration = new AtomicLong(0);

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

  public Long addTrainee(Trainee trainee) {
    Long userId = idGeneration.incrementAndGet();
    trainee.setUserId(userId);
    traineeStorage.put(userId, trainee);

    return userId;
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

  public boolean existsByUsername(String username) {
    return traineeStorage.values().stream()
      .anyMatch(trainee -> username.equals(trainee.getUsername()));
  }
}
