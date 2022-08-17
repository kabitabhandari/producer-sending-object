package com.example.producersendingobject;

import lombok.Data;

@Data
public class Employee {
    private String name;
    private String dept;
    private Long salary;
    private String title;

    public Employee() {

    }

    public Employee(String name, String dept, Long salary, String title) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.title = title;
    }
}