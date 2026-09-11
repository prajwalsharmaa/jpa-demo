package com.prajwal.jpa_demo.school;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;
    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    public SchoolDto create(
            SchoolDto dto
    ){
        var school = schoolMapper.schoolDtoToSchool(dto);
        var savedSchool = schoolRepository.save(school);
        return dto;
    }
    @GetMapping("/schools")
    public List<SchoolDto> findAll(){
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::schoolToSchooDto)
                .collect(Collectors.toList());
    }

}
