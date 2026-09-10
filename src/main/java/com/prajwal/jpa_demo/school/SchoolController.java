package com.prajwal.jpa_demo.school;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {
    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDto create(
            @RequestBody SchoolDto dto
    ){
        var school = schoolDtoToSchool(dto);
        var savedSchool = schoolRepository.save(school);
        return dto;
    }
    private School schoolDtoToSchool(SchoolDto dto){
        return new School(dto.name());
    }
    private SchoolDto schoolToSchooDto(School school){
        return new SchoolDto(school.getName());
    }
//    @GetMapping("/schools")
//    public List<School> findAll(){
//        return schoolRepository.findAll();
//    }
    @GetMapping("/schools")
    public List<SchoolDto> findAll(){
        return schoolRepository.findAll()
                .stream()
                .map(this::schoolToSchooDto)
                .collect(Collectors.toList());
    }
}
