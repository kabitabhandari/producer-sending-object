package com.example.producersendingobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class Controller {
    private final static String TOPIC_MILKTEA = "milktea";
    private final static String KEY_MILKTEA = "key-milk-1";
    private final static String TOPIC_GREENTEA = "greentea";
    private final static String KEY_GREENTEA = "key-green-1";

    @Autowired
    @Qualifier("kafkaTemplateJson")
    private KafkaTemplate<String, User> kafkaTemplateJson;

    @Autowired
    @Qualifier("kafkaTemplateJson")
    private KafkaTemplate<String, User> kafkaTemplateAvro;


    @PostMapping("/producer/json/userdetails")
    public String postUserDetails(@RequestBody User newUser) {

        kafkaTemplateJson.send(TOPIC_MILKTEA, KEY_MILKTEA, newUser);

        return "Published successfully";
    }

    @PostMapping("/producer/json/employeedetails")
    public String postEmployeeDetails(@RequestBody User newEmployee) {

        kafkaTemplateJson.send(TOPIC_GREENTEA, KEY_GREENTEA, newEmployee);

        return "Published successfully";
    }
}