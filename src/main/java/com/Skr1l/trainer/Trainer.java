package com.Skr1l.trainer;

import com.Skr1l.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trainer extends User {

  private String specialization;

  private Long userId;
}
