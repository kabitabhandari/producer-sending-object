package com.example.producersendingobject;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KakfaConfiguration {

    @Bean(name = "producerFactorySerializerJson")
    public ProducerFactory<String, User> producerFactoryForJsonMessageForUser() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }
    @Bean(name = "producerFactorySerializerJson")
    public ProducerFactory<String, Employee> producerFactoryForJsonMessageForEmployee() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }


    @Bean(name = "kafkaTemplateJsonUser")
    public KafkaTemplate<String, User> kafkaTemplateForJsonMessageForUser() {
        return new KafkaTemplate<>(producerFactoryForJsonMessageForUser());
    }

    @Bean(name = "kafkaTemplateJsonEmployee")
    public KafkaTemplate<String, Employee> kafkaTemplateForJsonMessageForEmployee() {
        return new KafkaTemplate<>(producerFactoryForJsonMessageForEmployee());
    }
//    @Bean(name = "producerFactorySerializerAvro")
//    public ProducerFactory<String, Student> producerFactoryForAvroMessage() {
//
//        Map<String, Object> config = new HashMap<>();
//
//        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
//        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
//
//        return new DefaultKafkaProducerFactory<>(config);
//    }
//
//
//    @Bean(name = "kafkaTemplateAvro")
//    public KafkaTemplate<String, Student> kafkaTemplateForAvroMessage() {
//        return new KafkaTemplate<>(producerFactoryForAvroMessage());
//    }


}
