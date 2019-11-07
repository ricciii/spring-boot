package com.ecc.exercises.springexercise.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ecc.exercises.springexercise.controller",
"com.ecc.exercises.springexercise.service", "com.ecc.exercises.springexercise.util"} )
public class Application {
   
   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }
}