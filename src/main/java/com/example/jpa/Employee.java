package com.example.jpa;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer salary;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    @JoinTable(
            name = "employee_tasks",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    @Column(updatable = false)
    private Set<Task> tasks = new HashSet<>();

    public Employee() { super(); }

    public Employee(Long id, String name, Integer salary) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, Integer salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, Integer salary, Set<Task> tasks) {
        super();
        this.name = name;
        this.salary = salary;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", tasks=" + tasks +
                '}';
    }
}
