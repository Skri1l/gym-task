package com.Skr1l.trainee.service;

import com.Skr1l.trainee.Trainee;
import com.Skr1l.trainee.dao.TraineeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraineeServiceImpl implements TraineeService {

  private TraineeDao traineeDao;

  @Autowired
  public void setTraineeDao(TraineeDao traineeDao) {
    this.traineeDao = traineeDao;
  }

  @Override
  public Long createTrainee(Trainee trainee) {

    Trainee traineeObj = new Trainee();

    traineeObj.setDateOfBirth(trainee.getDateOfBirth());
    traineeObj.setAddress(trainee.getAddress());
    traineeObj.setUserId(trainee.getUserId());

    traineeDao.addTrainee(traineeObj);

    return traineeObj.getUserId();
  }

  @Override
  public void updateTrainee(Trainee trainee) {

    Trainee traineeObj = traineeDao.getTraineeByUserId(trainee.getUserId());

    if (traineeObj == null) {
      throw new RuntimeException("This trainee does not exist");
    }

    if (trainee.getDateOfBirth() != null) {
      traineeObj.setDateOfBirth(trainee.getDateOfBirth());
    }

    if (trainee.getAddress() != null) {
      traineeObj.setAddress(trainee.getAddress());
    }

    traineeDao.updateTrainee(traineeObj);
  }

  @Override
  public void deleteTrainee(Long userId) {
    traineeDao.deleteTrainee(userId);
  }

  @Override
  public Trainee selectTrainee(Long userId) {

    return traineeDao.getTraineeByUserId(userId);
  }
}
