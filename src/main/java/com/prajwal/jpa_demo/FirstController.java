package com.prajwal.jpa_demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {
    private final StudentRepository repository;

    public FirstController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @PostMapping("/students")
    public Student post(
            @RequestBody Student student
    ){
        return repository.save(student);
    }
    @GetMapping("/all-students")
    public List<Student> findAllStudents(){
        return repository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(
            @PathVariable("student-id")Integer id
    ){
        return repository.findById(id)
                .orElse(new Student());
    }
}
