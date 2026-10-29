package com.Skr1l.training.service;

import com.Skr1l.training.Training;

public interface TrainingService {

  Long createTraining(Training training);

  Training selectTraining(Long trainingId);
}
