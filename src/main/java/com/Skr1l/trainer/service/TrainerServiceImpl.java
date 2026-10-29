package com.Skr1l.trainer.service;

import com.Skr1l.trainer.Trainer;
import com.Skr1l.trainer.dao.TrainerDao;
import com.Skr1l.user.configuration.PasswordGenerator;
import com.Skr1l.user.configuration.UsernameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements TrainerService {

  private static final Logger log = LoggerFactory.getLogger(TrainerServiceImpl.class);

  private TrainerDao trainerDao;

  private UsernameGenerator usernameGenerator;

  private PasswordGenerator passwordGenerator;

  @Autowired
  public void setTrainerDao(TrainerDao trainerDao) {
    this.trainerDao = trainerDao;
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
  public Long createTrainer(Trainer trainer) {
    log.info("Starting createTrainer");

    Trainer trainerObj = new Trainer();

    trainerObj.setFirstName(trainer.getFirstName());
    trainerObj.setLastName(trainer.getLastName());
    trainerObj.setSpecialization(trainer.getSpecialization());
    trainerObj.setActive(trainer.isActive());

    trainerObj.setUsername(usernameGenerator.generate(
      trainerObj.getFirstName(), trainerObj.getLastName()));

    trainerObj.setPassword(passwordGenerator.generatePassword());

    return trainerDao.addTrainer(trainerObj);
  }

  @Override
  public void updateTrainer(Trainer trainer) {
    log.info("Starting updateTrainer");

    Trainer trainerObj = trainerDao.getTrainerByUserId(trainer.getUserId());

    if (trainerObj == null) {
      throw new RuntimeException("This trainer does not exist");
    }

    if (trainer.getFirstName() != null) {
      trainerObj.setFirstName(trainer.getFirstName());
    }

    if (trainer.getLastName() != null) {
      trainerObj.setLastName(trainer.getLastName());
    }

    if (trainer.getSpecialization() != null) {
      trainerObj.setSpecialization(trainer.getSpecialization());
    }

    trainerDao.updateTrainer(trainerObj);
  }

  @Override
  public Trainer selectTrainer(Long userId) {
    log.info("Starting selectTrainer");

    return trainerDao.getTrainerByUserId(userId);
  }
}
