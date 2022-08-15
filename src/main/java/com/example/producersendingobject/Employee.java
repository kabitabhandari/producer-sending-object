package com.example.producersendingobject;

import lombok.Data;

@Data
public class Employee {
    private String name;
    private Long salary;
    private boolean isRemote;

    public Employee() {

    }

    public Employee(String name, Long salary, boolean isRemote) {
        this.name = name;
        this.salary = salary;
        this.isRemote = isRemote;
    }
}