package com.Skr1l;

import com.Skr1l.trainee.Trainee;
import com.Skr1l.trainer.Trainer;
import com.Skr1l.training.Training;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Main {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    try (var context =
           new AnnotationConfigApplicationContext(AppConfig.class)) {

      GymFacade facade = context.getBean(GymFacade.class);

      Trainee trainee = new Trainee();
      trainee.setFirstName("John");
      trainee.setLastName("Smith");
      trainee.setActive(true);

      Long id = facade.createTrainee(trainee);
      Trainee created = facade.selectTrainee(id);

      System.out.println("New ID: " + id);
      System.out.println("Username: " + created.getUsername());
      System.out.println(
        "Password length: " + created.getPassword().length()
      );

      Map<Long, Trainee> trainees =
        context.getBean("traineeStorage", Map.class);

      Map<Long, Trainer> trainers =
        context.getBean("trainersStorage", Map.class);

      Map<Long, Training> trainings =
        context.getBean("trainingStorage", Map.class);

      System.out.println("Trainees: " + trainees);
      System.out.println("Trainers: " + trainers);
      System.out.println("Trainings: " + trainings);
    }
  }
}
