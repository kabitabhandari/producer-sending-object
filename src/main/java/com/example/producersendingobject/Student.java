package com.example.producersendingobject;

import lombok.Data;



@Data
public class Student {
    private String name;
    private String course;
    private int age;
    private boolean isOnline;

    public Student() {

    }

    public Student(String name, String course, int age, boolean isOnline) {
        this.name = name;
        this.course = course;
        this.age = age;
        this.isOnline = isOnline;
    }
}
