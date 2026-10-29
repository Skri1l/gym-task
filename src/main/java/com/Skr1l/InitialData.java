package com.Skr1l;

import com.Skr1l.trainee.Trainee;
import com.Skr1l.trainer.Trainer;
import com.Skr1l.training.Training;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class InitialData {

  private List<Trainee> trainees;

  private List<Trainer> trainers;

  private List<Training> trainings;
}
