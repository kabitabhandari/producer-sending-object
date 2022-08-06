package com.example.producersendingobject;

import lombok.Data;
import org.apache.kafka.clients.producer.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Future;

@SpringBootApplication
public class ProducerSendingObjectApplication {

	public static void main(String[] args) throws ParseException {

		//message info
		String topic = "producer-contactdetails-topic";
		String key = "Random-key"; // optional
		MessageSupplier value1 = new MessageSupplier(
				115,
				"tom",
				"dancing is his passion",
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-07-02"));
		String description = value1.getDescription();
		System.out.println(">>>" + description);

		MessageSupplier value2 = new MessageSupplier(
				100,
				"Jina",
				"drinking is her passion",
				new SimpleDateFormat("yyyy-MM-dd").parse("2021-03-22"));



		// producer properties, following 3 are mandatory props
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "com.example.producersendingobject.MySerializer");

		//create Producer object
		Producer<String, MessageSupplier> producer1 = new KafkaProducer<>(props);

		//create producer record1
		ProducerRecord<String, MessageSupplier> producerRecord1 = new ProducerRecord<>(topic, key, value1);

		//send record as a future

		Future<RecordMetadata> future1 = producer1.send(producerRecord1, new Callback() {
			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				System.out.println("Broker's Acknowledgement for the received message on the topic " + metadata);
				if (exception != null) {
					exception.getMessage();
				}
			}
		});    //create producer record2
		ProducerRecord<String, MessageSupplier> producerRecord2 = new ProducerRecord<>(topic, key, value2);

		//send record as a future

		Future<RecordMetadata> future2 = producer1.send(producerRecord2, new Callback() {
			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				System.out.println("Broker's Acknowledgement for the received message on the topic " + metadata);
				if (exception != null) {
					exception.getMessage();
				}
			}
		});


		//close producer
		producer1.close();
		System.out.println("Producer Completed");
	}
}

