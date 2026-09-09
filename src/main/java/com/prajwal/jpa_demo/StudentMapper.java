package com.prajwal.jpa_demo;

import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail(),
                student.getSchool().getId()
        );
    }

    public Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstname(dto.firstName());
        student.setLastname(dto.lastName());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
    }
}
