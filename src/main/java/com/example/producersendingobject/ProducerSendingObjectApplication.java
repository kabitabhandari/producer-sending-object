package com.example.producersendingobject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Springboot provides an auto configuration for Kafka via KafkaAutoConfiguration class.
When you use @EnableAutoConfiguration or @SpringBootApplication, Spring boot automatically configures Kafka for you.
If you don't use Springboot, then you would have to use @EnableKafka to configure Kafka for your Spring app.
 */


@SpringBootApplication
public class ProducerSendingObjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerSendingObjectApplication.class, args);
    }
}