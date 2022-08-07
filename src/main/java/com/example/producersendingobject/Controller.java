package com.example.producersendingobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class Controller {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;



    @PostMapping("/post/{name}")
    public String postName(@PathVariable("name") final String name) {

        kafkaTemplate.send("blacktea", new User(name, "n/a", 1L));

        return "Published successfully";
    }


    @PostMapping("/post/user")
    public String postDetails(@RequestBody User newUser) {

        kafkaTemplate.send("milktea",newUser);

        return "Published successfully";
    }
}