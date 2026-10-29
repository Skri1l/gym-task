package com.Skr1l.training.service;

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

  @Autowired
  public void setTrainingDao(TrainingDao trainingDao) {
    this.trainingDao = trainingDao;
  }

  @Override
  public Long createTrainer(Training training) {
    log.info("Starting createTrainer");

    Training trainingObj =  new Training();

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
    log.info("Starting selectTrainer");

    return trainingDao.getTrainingById(trainingId);
  }
}
