package com.example.jpa;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private List<Task> tasks;
}
