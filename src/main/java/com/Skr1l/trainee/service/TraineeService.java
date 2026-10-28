package com.Skr1l.trainee.service;

import com.Skr1l.trainee.Trainee;

public interface TraineeService {

  Long createTrainee(Trainee trainee);

  void updateTrainee(Trainee trainee);

  void deleteTrainee(Long userId);

  Trainee selectTrainee(Long userId);
}
