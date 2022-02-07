package com.example.kafka.producer.demo.kafka.producer.config;/*
 * @created 06/02/2022 - 14:52
 * @project kafka-producer-example
 * @author Ratkovski
 */

import com.example.kafka.producer.demo.kafka.producer.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@RequiredArgsConstructor
public class KafkaConfiguration {


  @Bean
  public ProducerFactory<String, User> producerFactory() {
    Map<String, Object> config = new HashMap<>();


    config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

    config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
    config.put(ProducerConfig.ACKS_CONFIG,"all");
    config.put(ProducerConfig.RETRIES_CONFIG, 10);

    return new DefaultKafkaProducerFactory(config);
  }

  @Bean
  public KafkaTemplate<String, User> kafkaTemplate() {
    return new KafkaTemplate(producerFactory());
  }

  @Bean
  public NewTopic topic() {
    return new NewTopic("topic_test", 1, (short) 1);
  }
}
