package com.example.jpa;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

public class Task {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "tasks")
    private List<Employee> employees;
}