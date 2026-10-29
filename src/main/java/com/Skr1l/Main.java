package com.Skr1l;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    try (var context =
           new AnnotationConfigApplicationContext(AppConfig.class)) {

      GymFacade facade = context.getBean(GymFacade.class);
    }
  }
}
