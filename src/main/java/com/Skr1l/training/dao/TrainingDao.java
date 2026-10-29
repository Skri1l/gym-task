package com.Skr1l.training.dao;

import com.Skr1l.training.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TrainingDao {

  private Map<Long, Training> trainingStorage;

  private final AtomicLong idGeneration = new AtomicLong(0);

  @Autowired
  public void setTrainingStorage(Map<Long, Training> trainingStorage) {
    this.trainingStorage = trainingStorage;
  }

  public Long addTraining(Training training) {
    Long trainingId = idGeneration.incrementAndGet();
    training.setTrainingId(trainingId);
    trainingStorage.put(trainingId, training);

    return trainingId;
  }

  public Training getTrainingById(Long trainingId) {
    return trainingStorage.get(trainingId);
  }

  public void initializeIdSequence() {
    long maxId = trainingStorage.keySet().stream()
      .mapToLong(Long::longValue)
      .max()
      .orElse(0L);

    idGeneration.set(maxId);
  }
}
