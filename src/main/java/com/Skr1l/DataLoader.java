package com.Skr1l;

import com.Skr1l.trainee.Trainee;
import com.Skr1l.trainer.Trainer;
import com.Skr1l.training.Training;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Component
public class DataLoader {

  private Map<Long, Trainee> traineeStorage;
  private Map<Long, Trainer> trainerStorage;
  private Map<Long, Training> trainingStorage;
  private Resource dataFile;

  @Autowired
  public void setTraineeStorage(
    @Qualifier("traineeStorage") Map<Long, Trainee> traineeStorage) {
    this.traineeStorage = traineeStorage;
  }

  @Autowired
  public void setTrainerStorage(
    @Qualifier("trainersStorage") Map<Long, Trainer> trainerStorage) {
    this.trainerStorage = trainerStorage;
  }

  @Autowired
  public void setTrainingStorage(
    @Qualifier("trainingStorage") Map<Long, Training> trainingStorage) {
    this.trainingStorage = trainingStorage;
  }

  @Value("${storage.data-file}")
  public void setDataFile(Resource dataFile) {
    this.dataFile = dataFile;
  }

  @PostConstruct
  public void load() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());

    try (InputStream input = dataFile.getInputStream()) {
      InitialData data = mapper.readValue(input, InitialData.class);

      for (Trainee trainee : data.getTrainees()) {
        traineeStorage.put(trainee.getUserId(), trainee);
      }

      for (Trainer trainer : data.getTrainers()) {
        trainerStorage.put(trainer.getUserId(), trainer);
      }

      for (Training training : data.getTrainings()) {
        trainingStorage.put(training.getTrainingId(), training);
      }
    } catch (IOException e) {
      throw new IllegalStateException("Failed", e);
    }
  }
}
