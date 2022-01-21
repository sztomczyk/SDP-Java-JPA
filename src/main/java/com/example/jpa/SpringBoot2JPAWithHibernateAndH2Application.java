package com.example.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringBoot2JPAWithHibernateAndH2Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TaskRepository taskRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2JPAWithHibernateAndH2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Inserting -> {}", studentRepository.save(new Student("Szymon", "E1234567")));
        logger.info("Inserting -> {}", studentRepository.save(new Student("Adrian", "A1234568")));
        logger.info("Inserting -> {}", studentRepository.save(new Student("Maciej", "C1233124")));

        Set<Task> emp1Tasks = new HashSet<>();
        emp1Tasks.add(new Task("Wycentrować div horyzontalnie i wertykalnie"));
        emp1Tasks.add(new Task("Stworzyć raport z poprzedniego zadania"));
        emp1Tasks.add(new Task("ISSUE #A3B3F"));

        Set<Task> emp2Tasks = new HashSet<>();
        emp2Tasks.add(new Task("Przeprowadzić prezentację o nowym feature"));
        emp2Tasks.add(new Task("Spotkanie z klientem o 13:15"));

        Set<Task> tasks = new HashSet<>();
        tasks.add(new Task("Task 1"));
        tasks.add(new Task("Task 2"));

        Employee emp1 = new Employee("Michał", 350000, emp1Tasks);
        Employee emp2 = new Employee("Szymon", 1000000, emp2Tasks);

        logger.info("Inserting -> {}", employeeRepository.save(emp1));
        logger.info("Inserting -> {}", employeeRepository.save(emp2));
        logger.info("Inserting -> {}", employeeRepository.save(new Employee("Mikołaj", 500000)));

        employeeRepository.delete(emp1);
        emp2.setName("Szymon2");
        emp2.setSalary(1500000);
        employeeRepository.save(emp2);
    }
}
