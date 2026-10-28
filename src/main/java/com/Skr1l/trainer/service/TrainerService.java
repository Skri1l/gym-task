package com.Skr1l.trainer.service;

import com.Skr1l.trainer.Trainer;

public interface TrainerService {

  Long createTrainer(Trainer trainer);

  void updateTrainer(Trainer trainer);

  Trainer selectTrainer(Long userId);
}
