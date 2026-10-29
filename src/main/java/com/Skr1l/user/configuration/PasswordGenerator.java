package com.Skr1l.user.configuration;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class PasswordGenerator {

  private final SecureRandom random = new SecureRandom();

  private static final String CHARACTERS =
    "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

  public String generatePassword() {
    StringBuilder password = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      int index = random.nextInt(CHARACTERS.length());
      password.append(CHARACTERS.charAt(index));
    }
    return password.toString();
  }
}
