package com.Skr1l.trainer.dao;

import com.Skr1l.trainer.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TrainerDao {

  private Map<Long, Trainer> trainerStorage;

  private final AtomicLong idGeneration = new AtomicLong(0);

  @Autowired
  public void setTrainerStorage(Map<Long, Trainer> trainerStorage) {
    this.trainerStorage = trainerStorage;
  }

  public Long addTrainer(Trainer trainer) {
    Long userId = idGeneration.incrementAndGet();
    trainer.setUserId(userId);
    trainerStorage.put(userId, trainer);

    return userId;
  }

  public Trainer getTrainerByUserId(Long userId) {
    return trainerStorage.get(userId);
  }

  public List<Trainer> getAllTrainers() {
    return new ArrayList<>(trainerStorage.values());
  }

  public void updateTrainer(Trainer trainer) {
    if (!trainerStorage.containsKey(trainer.getUserId())) {
      throw new RuntimeException(
        "Trainer with this id " + trainer.getUserId() + " doesnt exist");
    }
    trainerStorage.put(trainer.getUserId(), trainer);
  }

  public boolean existsByUsername(String username) {
    return trainerStorage.values().stream()
      .anyMatch(trainer -> username.equals(trainer.getUsername()));
  }

  public void initializeIdSequence() {
    long maxId = trainerStorage.keySet().stream()
      .mapToLong(Long::longValue)
      .max()
      .orElse(0L);

    idGeneration.set(maxId);
  }
}
