package com.Skr1l.trainee;

import com.Skr1l.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Trainee extends User {

  private LocalDate dateOfBirth;

  private String address;

  private Long userId;

}
