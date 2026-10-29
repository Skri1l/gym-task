package com.Skr1l.training.service;

import com.Skr1l.trainee.dao.TraineeDao;
import com.Skr1l.trainer.dao.TrainerDao;
import com.Skr1l.training.Training;
import com.Skr1l.training.dao.TrainingDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingServiceImpl implements TrainingService {

  private static final Logger log = LoggerFactory.getLogger(TrainingServiceImpl.class);

  private TrainingDao trainingDao;

  private TraineeDao traineeDao;

  private TrainerDao trainerDao;

  @Autowired
  public void setTrainingDao(TrainingDao trainingDao) {
    this.trainingDao = trainingDao;
  }

  @Autowired
  public void setTraineeDao(TraineeDao traineeDao) {
    this.traineeDao = traineeDao;
  }

  @Autowired
  public void setTrainerDao(TrainerDao trainerDao) {
    this.trainerDao = trainerDao;
  }

  @Override
  public Long createTraining(Training training) {
    log.info("Starting createTraining");

    Training trainingObj =  new Training();

    if (traineeDao.getTraineeByUserId(training.getTraineeId()) == null) {
      throw new RuntimeException("Trainee does not exist");
    }

    if (trainerDao.getTrainerByUserId(training.getTrainerId()) != null) {
      throw new RuntimeException("Trainer does not exist");
    }
    trainingObj.setTraineeId(training.getTraineeId());
    trainingObj.setTrainerId(training.getTrainerId());
    trainingObj.setTrainingName(training.getTrainingName());
    trainingObj.setTrainingType(training.getTrainingType());
    trainingObj.setTrainingDate(training.getTrainingDate());
    trainingObj.setTrainingDuration(training.getTrainingDuration());

    return trainingDao.addTraining(trainingObj);
  }

  @Override
  public Training selectTraining(Long trainingId) {
    log.info("Starting selectTraining");

    return trainingDao.getTrainingById(trainingId);
  }
}
