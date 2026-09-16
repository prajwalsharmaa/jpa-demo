package com.prajwal.jpa_demo.student;

import com.prajwal.jpa_demo.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }

    public Student toStudent(StudentDto dto){
        if(dto == null){
            throw new NullPointerException("The Student Dto should not be null");
        }
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
