package com.prajwal.jpa_demo.student;

import com.prajwal.jpa_demo.studentProfile.StudentProfile;
import com.prajwal.jpa_demo.studentProfile.StudentProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;
    private final StudentProfileRepository profileRepository;

    public StudentService(StudentRepository repository, StudentMapper studentMapper, StudentProfileRepository profileRepository) {
        this.repository = repository;
        this.studentMapper = studentMapper;
        this.profileRepository = profileRepository;
    }

    public StudentResponseDto saveStudent(
            StudentDto dto
    ){
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }
    public List<Student> findAllStudents(){
        return repository.findAll();
    }
    public Student findStudentById(
            Integer id
    ){
        return repository.findById(id)
                .orElse(new Student());
    }
    public List<Student> findStudentByName(
            String name
    ){
        return repository.findAllByFirstnameContaining(name);
    }
    public void delete(
            Integer id
    ){
        repository.deleteById(id);
    }
    public StudentProfile createProfile(
            Integer studentId,
            StudentProfile profile) {

        Student student = repository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        profile.setStudent(student);

        return profileRepository.save(profile);
    }
}
