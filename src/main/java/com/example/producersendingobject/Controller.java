package com.example.producersendingobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class Controller<U,V> {
    private final static String TOPIC_BLACKTEA = "blacktea";
    private final static String TOPIC_MILKTEA = "milktea";
    private final static String KEY_MILKTEA = "key-milk-1";
    private final static String TOPIC_GREENTEA = "greentea";
    private final static String KEY_GREENTEA = "key-green-1";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;



    @PostMapping("/producer/string/{name}")
    public String postName(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC_BLACKTEA, new User(name, "n/a", 1L));

        return "Published successfully";
    }


    @PostMapping("/producer/json/userdetails")
    public String postUserDetails(@RequestBody User newUser) {

        kafkaTemplate.send(TOPIC_MILKTEA, KEY_MILKTEA, newUser);

        return "Published successfully";
    }

    @PostMapping("/producer/json/employeedetails")
    public String postEmployeeDetails(@RequestBody User newUser) {

        kafkaTemplate.send(TOPIC_GREENTEA, KEY_GREENTEA, newUser);

        return "Published successfully";
    }
}