package com.example.kafka.producer.demo.kafka.producer.controller;/*
 * @created 06/02/2022 - 15:28
 * @project kafka-producer-example
 * @author Ratkovski
 */

import com.example.kafka.producer.demo.kafka.producer.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
@RequiredArgsConstructor
public class UserController {

  private final KafkaTemplate<String, User> kafkaTemplate;

  @GetMapping("/publish/{name}")
  private String post(@PathVariable String name){
    kafkaTemplate.send("topic_test", new User(name, "Tech",1200L));
    return "Publicado com sucesso"  ;
  }

}