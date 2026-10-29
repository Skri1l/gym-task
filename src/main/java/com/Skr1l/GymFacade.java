package com.Skr1l;

import com.Skr1l.trainee.Trainee;
import com.Skr1l.trainee.service.TraineeService;
import com.Skr1l.trainer.Trainer;
import com.Skr1l.trainer.service.TrainerService;
import com.Skr1l.training.Training;
import com.Skr1l.training.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GymFacade {

  private final TraineeService traineeService;

  private final TrainerService trainerService;

  private final TrainingService trainingService;

  public Long createTrainee(Trainee trainee) {
    return traineeService.createTrainee(trainee);
  }

  public void updateTrainee(Trainee trainee) {
    traineeService.updateTrainee(trainee);
  }

  public void deleteTrainee(Long userId) {
    traineeService.deleteTrainee(userId);
  }

  public Trainee selectTrainee(Long userId) {
    return traineeService.selectTrainee(userId);
  }


  public Long createTrainer(Trainer trainer) {
    return trainerService.createTrainer(trainer);
  }

  public void updateTrainer(Trainer trainer) {
    trainerService.updateTrainer(trainer);
  }

  public Trainer selectTrainer(Long userId) {
    return trainerService.selectTrainer(userId);
  }


  public Long createTraining(Training training) {
    return trainingService.createTraining(training);
  }

  public Training selectTraining(Long userId) {
    return trainingService.selectTraining(userId);
  }
}
