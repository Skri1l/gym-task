package com.Skr1l.training.service;

import com.Skr1l.training.Training;

public interface TrainingService {

  Long createTrainer(Training training);

  Training selectTraining(Long trainingId);
}
