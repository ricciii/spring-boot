package com.ecc.exercises.springexercise.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.ecc.exercises.springexercise.repository")
@EnableTransactionManagement
@EnableCaching
@EntityScan(basePackages="com.ecc.exercises.springexercise.model")
@ComponentScan("com.ecc.exercises.springexercise")
public class Application {
   
   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }
}