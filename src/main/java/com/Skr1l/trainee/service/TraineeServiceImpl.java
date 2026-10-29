package com.Skr1l.trainee.service;

import com.Skr1l.trainee.Trainee;
import com.Skr1l.trainee.dao.TraineeDao;
import com.Skr1l.user.configuration.PasswordGenerator;
import com.Skr1l.user.configuration.UsernameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TraineeServiceImpl implements TraineeService {

  private static final Logger log = LoggerFactory.getLogger(TraineeServiceImpl.class);

  private TraineeDao traineeDao;

  private UsernameGenerator usernameGenerator;

  private PasswordGenerator passwordGenerator;

  @Autowired
  public void setTraineeDao(TraineeDao traineeDao) {
    this.traineeDao = traineeDao;
  }

  @Autowired
  public void setUsernameGenerator(UsernameGenerator usernameGenerator) {
    this.usernameGenerator = usernameGenerator;
  }

  @Autowired
  public void setPasswordGenerator(PasswordGenerator passwordGenerator) {
    this.passwordGenerator = passwordGenerator;
  }

  @Override
  public Long createTrainee(Trainee trainee) {
    log.info("Starting createTrainee");

    Trainee traineeObj = new Trainee();

    traineeObj.setFirstName(trainee.getFirstName());
    traineeObj.setLastName(trainee.getLastName());
    traineeObj.setActive(trainee.isActive());
    traineeObj.setDateOfBirth(trainee.getDateOfBirth());
    traineeObj.setAddress(trainee.getAddress());

    traineeObj.setUsername(usernameGenerator.generate(
      traineeObj.getFirstName(), traineeObj.getLastName()));

    traineeObj.setPassword(passwordGenerator.generatePassword());

    return traineeDao.addTrainee(traineeObj);
  }

  @Override
  public void updateTrainee(Trainee trainee) {
    log.info("Starting updateTrainee");

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

    if (trainee.getFirstName() != null) {
      traineeObj.setFirstName(trainee.getFirstName());
    }

    if (trainee.getLastName() != null) {
      traineeObj.setLastName(trainee.getLastName());
    }

    traineeDao.updateTrainee(traineeObj);
  }

  @Override
  public void deleteTrainee(Long userId) {
    log.info("Starting deleteTrainee");

    traineeDao.deleteTrainee(userId);
  }

  @Override
  public Trainee selectTrainee(Long userId) {
    log.info("Starting selectTrainee");

    return traineeDao.getTraineeByUserId(userId);
  }
}
