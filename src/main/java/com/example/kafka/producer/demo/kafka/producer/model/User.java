package com.example.kafka.producer.demo.kafka.producer.model;/*
 * @created 06/02/2022 - 14:47
 * @project kafka-producer-example
 * @author Ratkovski
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
  private String name;
  private String department;
  private Long salary;

  public User(String name, String department, Long salary) {
    this.name = name;
    this.department = department;
    this.salary = salary;
  }
}

