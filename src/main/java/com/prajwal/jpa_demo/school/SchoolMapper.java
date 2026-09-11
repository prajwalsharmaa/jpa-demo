package com.prajwal.jpa_demo.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public School schoolDtoToSchool(SchoolDto dto){
        return new School(dto.name());
    }
    public SchoolDto schoolToSchooDto(School school){
        return new SchoolDto(school.getName());
    }
}
