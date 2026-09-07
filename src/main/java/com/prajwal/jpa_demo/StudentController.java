package com.prajwal.jpa_demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @PostMapping("/student")
    public Student post(
            @RequestBody StudentDto dto
    ){
        var student = toStudent(dto);
        return repository.save(student);
    }

    private Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstname(dto.firstName());
        student.setLastname(dto.lastName());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
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
    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByName(
            @PathVariable("student-name")String name
    ){
        return repository.findAllByFirstnameContaining(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ){
        repository.deleteById(id);
    }

}
