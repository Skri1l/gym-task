package com.Skr1l.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

  private String firstName;

  private String lastName;

  private String username;

  private String password;

  private boolean isActive;
}
