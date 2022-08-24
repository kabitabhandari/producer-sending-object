package com.example.producersendingobject;

import com.example.producersendingobject.avro.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("kafka")
public class Controller {
    private final static String TOPIC_MILKTEA = "milktea";
    private final static String KEY_MILKTEA = "key-milk-1";
    private final static String TOPIC_GREENTEA = "greentea";
    private final static String KEY_GREENTEA = "key-tp-1";
    private final static String TOPIC_COFFEE = "coffee";
    private final static String KEY_COFFEE = "key-coffee-1";

    @Autowired
    @Qualifier("kafkaTemplateJsonUser")
    private KafkaTemplate<String, User> kafkaTemplateJsonUser;

    @Autowired
    @Qualifier("kafkaTemplateJsonEmployee")
    private KafkaTemplate<String, Employee> kafkaTemplateJsonEmployee;

    @Autowired
    @Qualifier("kafkaTemplateAvro")
    private KafkaTemplate<String, Student> kafkaTemplateAvro;


    @PostMapping("/producer/json/userdetails")
    public String postUserDetails(@RequestBody User newUser) {

        kafkaTemplateJsonUser.send(TOPIC_MILKTEA, KEY_MILKTEA, newUser);

        return "Published successfully";
    }

    @PostMapping("/producer/json/employeedetails")
    public String postEmployeeDetails(@RequestBody Employee newEmployee) {

        kafkaTemplateJsonEmployee.send(TOPIC_GREENTEA, KEY_GREENTEA, newEmployee);

        return "Published successfully";
    }
    @PostMapping("/producer/avro/studentdetails")
    public String postStudentDetails(@RequestBody Student newStudent) throws InterruptedException, ExecutionException, TimeoutException {
        ListenableFuture<SendResult<String, Student>> future = kafkaTemplateAvro.send(TOPIC_COFFEE, KEY_COFFEE, newStudent);
        future.get(2, TimeUnit.SECONDS);
        return " ";
    }
}