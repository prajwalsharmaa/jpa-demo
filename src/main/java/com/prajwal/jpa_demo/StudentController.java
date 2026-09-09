package com.prajwal.jpa_demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @PostMapping("/student")
    public StudentResponseDto saveStudent(
            @RequestBody StudentDto dto
    ){
        return this.studentService.saveStudent(dto);
    }
    @GetMapping("/all-students")
    public List<Student> findAllStudents(){
        return this.studentService.findAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(
            @PathVariable("student-id")Integer id
    ){
        return this.studentService.findStudentById(id);
    }
    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByName(
            @PathVariable("student-name")String name
    ){
        return this.studentService.findStudentByName(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ){
        this.studentService.delete(id);
    }

}
