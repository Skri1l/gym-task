package com.Skr1l.trainer;

import com.Skr1l.training.TrainingType;
import com.Skr1l.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Trainer extends User {

  private TrainingType specialization;

  private Long userId;
}
