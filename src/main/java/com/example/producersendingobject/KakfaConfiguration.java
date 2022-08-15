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
    public ProducerFactory<String, User> producerFactoryForJsonMessage() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
        config.put(JsonSerializer.TYPE_MAPPINGS, "user:com.example.producersendingobject.User");


        return new DefaultKafkaProducerFactory<>(config);
    }


    @Bean(name = "kafkaTemplateJson")
    public KafkaTemplate<String, User> kafkaTemplateForJsonMessage() {
        return new KafkaTemplate<>(producerFactoryForJsonMessage());
    }
    @Bean(name = "producerFactorySerializerAvro")
    public ProducerFactory<String, User> producerFactoryForAvroMessage() {
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);



        return new DefaultKafkaProducerFactory<>(config);
    }


    @Bean(name = "kafkaTemplateAvro")
    public KafkaTemplate<String, User> kafkaTemplateForAvroMessage() {
        return new KafkaTemplate<>(producerFactoryForAvroMessage());
    }


}
