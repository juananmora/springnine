package com.example.es.java.springnine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Application {
  public String password="";
  
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
