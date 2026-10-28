package com.Skr1l.trainee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trainee {

  private LocalDate dateOfBirth;

  private String address;

  private Long userId;

}
