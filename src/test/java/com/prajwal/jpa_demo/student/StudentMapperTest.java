package com.prajwal.jpa_demo.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent(){
        StudentDto dto = new StudentDto("John","Doe","john@gmail.com",1);
        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstName(),student.getFirstname());
        assertEquals(dto.lastName(),student.getLastname());
        assertEquals(dto.email(),student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(),student.getSchool().getId());
    }
    @Test
    public void shouldMapStudentToStudentResponseDto(){
        //Given
        Student student = new Student("John","Doe","john@gmail.com",1);
        //When
        StudentResponseDto dto = mapper.toStudentResponseDto(student);
        //Then
        assertEquals(dto.firstName(),student.getFirstname());
        assertEquals(dto.lastName(),student.getLastname());
        assertEquals(dto.email(),student.getEmail());

    }
    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null(){
        var exp = assertThrows(NullPointerException.class,()->mapper.toStudent(null));
        assertEquals("The Student Dto should not be null",exp.getMessage());
    }
}